package com.maxencew.biblioto.application.service.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxencew.biblioto.application.request.OpenAiRequest;
import com.maxencew.biblioto.application.response.ChatGptSummariseBookPattern;
import com.maxencew.biblioto.application.response.OpenAiResponse;
import com.maxencew.biblioto.application.service.api.OpenAIService;
import com.maxencew.biblioto.infrastructure.configuration.AppConfig;
import com.maxencew.biblioto.infrastructure.configuration.ExternalApiConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OpenAIAdapter implements OpenAIService {

    private ExternalApiConfiguration externalApiConfiguration;
    private AppConfig appConfig;

    @Override
    public ChatGptSummariseBookPattern getChatGptResponse(final String bookName, final String author) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + externalApiConfiguration.getOpenAIApiKey());

        ResponseEntity<OpenAiResponse> response = appConfig.restTemplateOpenAi()
                .exchange(externalApiConfiguration.getOpenAIUrl(), HttpMethod.POST,
                        getOpenAiRequestHttpEntity(headers), OpenAiResponse.class);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(cleanJsonString(response.getBody().getChoices().get(0).getMessage().getContent()), ChatGptSummariseBookPattern.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpEntity<OpenAiRequest> getOpenAiRequestHttpEntity(HttpHeaders headers) {
        OpenAiRequest request = new OpenAiRequest(
                "gpt-3.5-turbo", List.of(new OpenAiRequest.Message("system", "You are a library assistant, your role is to create relevant summaries and condense the opinions of the literary community."),
                new OpenAiRequest.Message("user",  "Please, respond with a Json Format respecting the information below, your response must be interpretate by a java API resource :\n" +
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
                        "```"))

        );

        return new HttpEntity<>(request, headers);
    }

    public static String cleanJsonString(String jsonString) {
        // Supprimer les délimiteurs de code ```json et ```
        return jsonString.replaceAll("```json\\s*", "").replaceAll("\\s*```", "");
    }
}
