package com.syntra.paymentservice.api.controller;

import com.syntra.paymentservice.api.request.PaymentRequest;
import com.syntra.paymentservice.api.response.PaymentResponse;
import com.syntra.paymentservice.exception.ErrorCode;
import com.syntra.paymentservice.exception.PaymentServiceException;
import com.syntra.paymentservice.mapper.PaymentMapper;
import com.syntra.paymentservice.service.PaymentService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @PostMapping
    @PreAuthorize("hasRole('client_user') || hasRole('client_admin')")
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentMapper.map(paymentService.createPayment(paymentMapper.map(paymentRequest)));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('client_admin')")
    public PaymentResponse getPaymentById(@PathVariable Long id) {
        return paymentMapper.map(paymentService.getPaymentById(id));
    }

    @GetMapping
    @RolesAllowed({"ROLE_client_user", "ROLE_client_admin"})
    public List<PaymentResponse> getPaymentList() {
        return paymentMapper.map(paymentService.getPaymentList());
    }

    @GetMapping("/error")
    public List<PaymentResponse> getErrorResponse() {
        throw new PaymentServiceException(ErrorCode.UNKNOWN_ERROR);
    }

}
