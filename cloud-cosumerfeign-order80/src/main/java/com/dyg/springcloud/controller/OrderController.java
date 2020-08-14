package com.dyg.springcloud.controller;

import com.dyg.springcloud.service.PaymentFeignClient;
import com.dyg.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author duyangang
 * @date 2020/6/27 - 21:05
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentFeignClient paymentFeignClient;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentFeignClient.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paynmentFeignTimeout() {
        return paymentFeignClient.paynmentFeignTimeout();
    }
}

