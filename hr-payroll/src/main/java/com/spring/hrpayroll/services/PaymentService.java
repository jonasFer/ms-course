package com.spring.hrpayroll.services;

import com.spring.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public Payment getPayment(Long workerId, int days) {
        return Payment
                .builder()
                .name("Jonas")
                .dailyIncome(200.0)
                .days(days)
                .build();
    }
}
