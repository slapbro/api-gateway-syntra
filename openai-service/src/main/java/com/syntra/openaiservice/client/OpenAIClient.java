package com.syntra.openaiservice.client;

import com.syntra.openaiservice.client.request.CompletionRequest;
import com.syntra.openaiservice.client.response.CompletionResponse;
import com.syntra.openaiservice.config.OpenAIFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "openai-client", url = "${feign.services.openai-client.url}", configuration = OpenAIFeignConfig.class)
public interface OpenAIClient {

    @PostMapping("/completions")
    CompletionResponse getCompletions(@RequestBody CompletionRequest completionRequest);

}