package com.maxencew.bibliotech.application.service.api;

import com.maxencew.bibliotech.application.response.ChatGptSummariseBookPattern;

public interface OpenAIService {

    ChatGptSummariseBookPattern getBookInformation(final String bookName, final String author);

}
