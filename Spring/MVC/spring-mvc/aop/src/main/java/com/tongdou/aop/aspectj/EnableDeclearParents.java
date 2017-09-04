package com.tongdou.aop.aspectj;

import com.tongdou.aop.spring.advisor.Seller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 引介增强
 * Created by shenyuzhu on 2017/9/4.
 */
@Aspect
public class EnableDeclearParents {
    /**
     * 让order具备Buyer的接口
     */
    @DeclareParents(value = "com.tongdou.aop.aspectj.MyJob", defaultImpl = MyOrder.class)
    public Order order;
}
