package com.maple.dubbo.consumer.hystrix;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-12-15 7:58 PM
 */
// 命名当前 Filter 为 "hystrix"

@Activate(group = Constants.CONSUMER, value = "hystrix")
public class HystrixFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return new com.maple.dubbo.provider.hystrix.ResultHystrixCommand(invoker, invocation).execute();
    }
}
