package com.maxencew.biblioto.application.service.api;

import com.maxencew.biblioto.application.response.ChatGptSummariseBookPattern;

public interface OpenAIService {

    ChatGptSummariseBookPattern getChatGptResponse(final String bookName, final String author);

}
