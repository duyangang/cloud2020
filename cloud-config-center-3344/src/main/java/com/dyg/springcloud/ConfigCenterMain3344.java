package com.dyg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
/**
 * 1.半自动的实现刷新配置，缺点是没个config client都得手动刷新，让所有client端刷新，config做不到，得需要消息总线支持（Bus）
 *
 * 2.全自动的，消息总线需要刷新：curl -X POST "http://localhost:3344/actuator/bus-refresh"
 *
 * 3.只通知某个config-client：curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
 */
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344 .class,args);
    }
}
