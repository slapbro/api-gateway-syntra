package com.syntra.paymentservice.mapper;

import com.syntra.paymentservice.api.request.PaymentRequest;
import com.syntra.paymentservice.api.response.PaymentResponse;
import com.syntra.paymentservice.data.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentResponse map(Payment payment);

    Payment map(PaymentRequest paymentRequest);

    List<PaymentResponse> map(List<Payment> payments);

}
