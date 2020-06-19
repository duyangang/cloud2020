package com.dyg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.zookeeper.ConditionalOnZookeeperEnabled;

@SpringBootApplication
@EnableDiscoveryClient
@ConditionalOnZookeeperEnabled
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class);
    }
}
