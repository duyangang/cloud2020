package com.dyg.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author duyangang
 * @date 2020/6/26 - 22:50
 */
@Component
public class MyLoadBalancerImpl implements MyLoadBalancer{

    private final AtomicInteger ai = new AtomicInteger(0);

    private final int getNext() {
        int current = 0;
        int next = 0;
        do{
            current = ai.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!ai.compareAndSet(current, next));
        System.out.println("次数=" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> list) {
        int index = getNext() % list.size();
        return list.get(index);
    }
}
