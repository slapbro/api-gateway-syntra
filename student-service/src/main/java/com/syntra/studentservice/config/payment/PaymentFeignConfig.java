package com.syntra.studentservice.config.payment;

import com.syntra.studentservice.config.ResponseToErrorDecoder;
import com.syntra.studentservice.service.TokenStoreService;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class PaymentFeignConfig {

    private final TokenStoreService tokenStoreService;

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new PaymentFeignClientRequestInterceptor(tokenStoreService);
    }

    @Bean
    public ErrorDecoder paymentErrorDecoder() {
        return new ResponseToErrorDecoder();
    }

    @Bean
    public Retryer paymentRetry() {
        return Retryer.NEVER_RETRY;
    }
}
