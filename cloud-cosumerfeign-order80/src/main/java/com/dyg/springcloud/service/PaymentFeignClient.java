package com.dyg.springcloud.service;

import com.dyg.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author duyangang
 * @date 2020/6/27 - 21:02
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignClient {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paynmentFeignTimeout() ;
}
