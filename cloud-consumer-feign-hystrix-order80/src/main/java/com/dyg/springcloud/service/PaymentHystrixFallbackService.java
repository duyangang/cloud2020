package com.dyg.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author duyangang
 * @date 2020/7/4 - 16:39
 */
@Component
public class PaymentHystrixFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixFallbackService FallBack for paymentInfo_OK.";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentHystrixFallbackService FallBack for paymentInfo_TimeOut.";
    }
}
