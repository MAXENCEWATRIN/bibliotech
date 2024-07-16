package com.maxencew.bibliotech.domain.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxencew.bibliotech.application.request.OpenAiRequest;
import com.maxencew.bibliotech.application.response.ChatGptSummariseBookPattern;
import com.maxencew.bibliotech.application.response.OpenAiResponse;
import com.maxencew.bibliotech.application.service.api.OpenAIService;
import com.maxencew.bibliotech.infrastructure.configuration.AppConfig;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class OpenAIAdapter implements OpenAIService {

    private Environment environment;
    private AppConfig appConfig;

    public static final String USER_PROMPT_CONTENT = "Please, respond with a Json Format respecting the information below, your response must be interpretate by a java API resource :\n" +
            "\n" +
            "I'd like to have a \"summary\" (Less than 500 words), a \"synopsis\"  (Less than 500 words) and a paragraph   summarizing the  public opinions of the book \"The lord of the rings\" of the author name \"Tolkien\". You can split the publicOpinions paragraphe with a part named \"overallReception\", an other named \"criticisms\" and finally \"criticisms\".\n" +
            "\n" +
            "Finally, an example of the json format you always must respect when your answer :\n" +
            "\n" +
            "\n" +
            "```json\n" +
            "{\n" +
            "  \"summary\": \"exemple\",\n" +
            "  \"synopsis\": \"exemple\"\n" +
            "  \"publicOpinions\": {\n" +
            "    \"overallReception\": \"\"exemple\"\",\n" +
            "    \"praises\": \"exemple\",\n" +
            "    \"criticisms\": \"exemple\"\n" +
            "  }\n" +
            "}\n" +
            "```";
    public static final String SYSTEM_PROMPT_CONTENT = "You are a library assistant, your role is to create relevant summaries and condense the opinions of the literary community.";

    @Override
    public ChatGptSummariseBookPattern getBookInformation(final String bookName, final String author) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + environment.getProperty("external.api.openAI.key"));

        ResponseEntity<OpenAiResponse> response = appConfig.restTemplate()
                .exchange(environment.getProperty("external.api.openAI.url"), HttpMethod.POST,
                        getOpenAiRequestHttpEntity(headers), OpenAiResponse.class);
        try {
            if (Objects.nonNull(response.getBody()) && !response.getBody().getChoices().isEmpty()) {
                return new ObjectMapper().readValue(cleanJsonString(response.getBody()
                        .getChoices().getFirst().getMessage().getContent()), ChatGptSummariseBookPattern.class);
            }
           throw new IllegalArgumentException("OpenAI Api respond with an empty body.");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpEntity<OpenAiRequest> getOpenAiRequestHttpEntity(HttpHeaders headers) {
        OpenAiRequest request = new OpenAiRequest(
                "gpt-3.5-turbo", List.of(new OpenAiRequest.Message("system", SYSTEM_PROMPT_CONTENT),
                new OpenAiRequest.Message("user", USER_PROMPT_CONTENT))

        );

        return new HttpEntity<>(request, headers);
    }

    public static String cleanJsonString(String jsonString) {
        // Supprimer les délimiteurs de code ```json et ```
        return jsonString.replaceAll("```json\\s*", "").replaceAll("\\s*```", "");
    }
}
