package com.dyg.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
//@RefreshScope + POST刷新（curl -X POST http://localhost:3355/actuator/refresh）
//如果想自动的让所有client端刷新，config做不到，得需要消息总线支持（Bus）
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}