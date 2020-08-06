package com.dyg.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info("---execute ..");
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {
//        log.info("---服务降级规则测试 - RT ..");
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        log.info("---服务降级规则测试 - 异常比例  ..");
        int a = 10 / 0;
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        log.info("---服务降级规则测试 - 异常数  ..");
        int a = 10 / 0;
        return "------testC";
    }
}