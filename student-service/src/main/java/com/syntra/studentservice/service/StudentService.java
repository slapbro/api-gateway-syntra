package com.syntra.studentservice.service;

import com.syntra.studentservice.client.payment.response.PaymentResponse;
import com.syntra.studentservice.data.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<PaymentResponse> getPayments();

}