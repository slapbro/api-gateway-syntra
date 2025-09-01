package com.syntra.paymentservice.service.impl;

import com.syntra.paymentservice.data.entity.Payment;
import com.syntra.paymentservice.data.repository.PaymentRepository;
import com.syntra.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPaymentList() {
        return paymentRepository.findAll();
    }
}
