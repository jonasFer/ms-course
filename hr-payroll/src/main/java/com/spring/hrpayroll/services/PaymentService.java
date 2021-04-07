package com.spring.hrpayroll.services;

import com.spring.hrpayroll.clients.WorkerFeignClient;
import com.spring.hrpayroll.entities.Payment;
import com.spring.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaymentService {
    @Autowired
    private WorkerFeignClient workerClient;

    public Payment getPayment(Long workerId, int days) {
        Worker worker = workerClient.findById(workerId).getBody();

        return Payment
                .builder()
                .name(worker.getName())
                .dailyIncome(worker.getDailyIncome())
                .days(days)
                .build();
    }
}
