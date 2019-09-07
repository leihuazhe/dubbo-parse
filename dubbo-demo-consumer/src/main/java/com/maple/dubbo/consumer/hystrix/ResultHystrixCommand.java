package com.maple.dubbo.provider.hystrix;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-12-15 7:54 PM
 */
public class ResultHystrixCommand extends HystrixCommand<Result> {
    private final Invoker<?> invoker;
    private final Invocation invocation;

    public ResultHystrixCommand(Invoker<?> invoker, Invocation invocation) {
        // 设置超时时间
        super(HystrixCommandGroupKey.Factory.asKey("ResultHystrixCommand"), 100);
        // 关联 Dubbo Invoker 和 Invocation
        this.invoker = invoker;
        this.invocation = invocation;
    }

    @Override
    protected Result run() throws Exception {
        // 远程方法调用执行
        return invoker.invoke(invocation);
    }
}
