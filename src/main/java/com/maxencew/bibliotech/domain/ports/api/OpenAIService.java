package com.maxencew.bibliotech.domain.ports.api;

import com.maxencew.bibliotech.application.response.ChatGptSummariseBookPattern;

public interface OpenAIService {

    ChatGptSummariseBookPattern getBookInformation(final String bookName, final String author);

}
