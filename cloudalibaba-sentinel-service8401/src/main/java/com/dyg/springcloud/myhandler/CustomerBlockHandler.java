package com.dyg.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dyg.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");
    }
}
