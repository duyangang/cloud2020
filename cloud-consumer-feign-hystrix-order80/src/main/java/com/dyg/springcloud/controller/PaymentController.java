package com.dyg.springcloud.controller;

import com.dyg.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")//默认的降级方法
public class PaymentController {

    @Resource
    private PaymentHystrixService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //服务降级处理
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //1.5秒钟以内就是正常的业务逻辑
//    })
    @HystrixCommand//如果指定了特定的fallbackMethod那就调指定方法，如果没指定，就调用默认方法
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int a = 10 / 0 ;
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙或自己运行出错，请稍后再试。";
    }


    //全局降级处理
    public String payment_global_fallbackMethod() {
        return "Global 异常处理信息，请稍后再试。";
    }

}