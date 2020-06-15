package com.dyg.springcloud.service;

import com.dyg.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById( Long id);
}