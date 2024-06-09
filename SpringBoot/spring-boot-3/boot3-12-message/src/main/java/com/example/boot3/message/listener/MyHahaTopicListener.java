package com.example.boot3.message.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class MyHahaTopicListener {
    //默认的监听是从消息队列最后一个消息开始拿数据,新消息才能拿到
    //@KafkaListener必须指定groupId的值和topics的值
    @KafkaListener(topics = "newhaha", groupId = "haha")
    public void haha(ConsumerRecord record) {
        // 1、获取消息的各种详细信息
//        String topic = record.topic();
        Object key = record.key();
        Object value = record.value();
        System.out.println("收到消息：key【" + key + "】 value 【" + value + "】");
    }

    // 拿到以前完整的消息
    @KafkaListener(groupId = "hehe", topicPartitions = {
            @TopicPartition(topic = "newhaha", partitionOffsets = {
                    @PartitionOffset(partition = "0", initialOffset = "0")
            })
    })
    public void hehe(ConsumerRecord record) {
        // 1、获取消息的各种详细信息
//        String topic = record.topic();
        Object key = record.key();
        Object value = record.value();
        System.out.println("收到消息：key【" + key + "】 value 【" + value + "】");
    }
}
