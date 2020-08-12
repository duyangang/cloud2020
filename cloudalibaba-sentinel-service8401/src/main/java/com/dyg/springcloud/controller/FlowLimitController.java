package com.dyg.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler="handler_testHostKey")
    public String testHostKey(@RequestParam(required = false,value = "p1") String p1,
                            @RequestParam(required = false,value = "p2") String p2) {

        return "testHostKey-----";
    }

    public String handler_testHostKey(String p1, String p2, BlockException exc) {
        return "deal testHostKey ";

    }
}