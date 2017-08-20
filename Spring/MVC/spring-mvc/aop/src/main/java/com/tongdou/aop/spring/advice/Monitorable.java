package com.tongdou.aop.spring.advice;

/**
 * 引介增强接口
 * Created by shenyuzhu on 2017/8/20.
 */
public interface Monitorable {

    /**
     * 设置是否启动监控
     *
     * @param active true：启动监控；false：禁止监控
     */
    public void setMonitorActive(boolean active);

}
