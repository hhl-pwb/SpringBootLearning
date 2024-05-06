package com.atguigu.boo3.core.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * 事件发送器
 */
@Service
public class EventPublisher implements ApplicationEventPublisherAware {
    /**
     * 底层发送事件的组件，SpringBoot会通过ApplicationEventPublisherAware接口自动注入给我们
     * 事件是广播出去的，所有监听这个事件的监听器都可以收到
     */
    ApplicationEventPublisher applicationEventPublisher;
    /**
     * 所有事件都可以发
     * @param event 事件
     */
    public void sendEvent(ApplicationEvent event) {
        //调用底层API发送事件
        applicationEventPublisher.publishEvent(event);
    }
    /**
     * 会被自动调用，把真正发事件的底层组件ApplicationEventPublisher给我们注入进来
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
