package com.maxencew.biblioto.application.service.api;

import com.maxencew.biblioto.application.response.ChatGptSummariseBookPattern;

public interface OpenAIService {

    ChatGptSummariseBookPattern getBookInformation(final String bookName, final String author);

}
