package com.tongdou.aop.spring.advisor.composable;

import com.tongdou.aop.spring.advisor.controlflow.BuyerDelegate;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;


/**
 * 复合切点
 * Created by shenyuzhu on 2017/8/30.
 */
public class GreetingComposablePointCut {

    public ComposablePointcut getCompositablePointCut() {
        ComposablePointcut cp = new ComposablePointcut();

        // 流程切点
        Pointcut flowPointCut = new ControlFlowPointcut(BuyerDelegate.class, "service");
        // 方法切点
        NameMatchMethodPointcut matchMethodPointcut = new NameMatchMethodPointcut();
        matchMethodPointcut.addMethodName("greetTo");


        cp.intersection(flowPointCut);
        cp.intersection((Pointcut) matchMethodPointcut);

        return cp;
    }

}
