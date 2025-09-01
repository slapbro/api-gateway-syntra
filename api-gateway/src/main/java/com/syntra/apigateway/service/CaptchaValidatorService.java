package com.syntra.apigateway.service;

public interface CaptchaValidatorService {

    boolean validateCaptcha(String captchaResponse);

}
