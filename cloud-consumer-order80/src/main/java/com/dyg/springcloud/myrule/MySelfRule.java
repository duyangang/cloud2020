package com.dyg.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author duyangang
 * @date 2020/6/25 - 22:09
 *
 * 注意本类不能放到@CommonScan扫描的类路径
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getRibbonRule() {
        return new RandomRule();//定义为随机
    }
}
