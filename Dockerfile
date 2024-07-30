# Dockerfile for bibliotech (Spring Boot App)

# Use the official Maven image to build the app
FROM maven:3.8.4-openjdk-22 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the application code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Use the official OpenJDK image for the runtime
FROM openjdk:22-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file from the build stage
COPY --from=build /app/target/bibliotech-*.jar /app/bibliotech.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "bibliotech.jar"]
