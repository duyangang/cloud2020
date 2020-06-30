package com.dyg.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author duyangang
 * @date 2020/6/26 - 22:43
 */
public interface MyLoadBalancer {

    /**
     * 实现轮询负载均衡算法
     * @param list
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> list);
}
