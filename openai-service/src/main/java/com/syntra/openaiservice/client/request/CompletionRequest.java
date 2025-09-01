package com.syntra.openaiservice.client.request;

public record CompletionRequest(String model, String prompt, int temperature, int max_tokens) {
}
