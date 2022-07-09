package com.simple.chiralium.web.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 卡夫卡测试消费者
 *
 * @author simpleZzz
 * @date 2022/07/09 16:24:53
 */
@Component
@Slf4j
public class KafkaTestConsumer {

    @KafkaListener(topics = {"testTopic"},groupId = "group1")
    public void consumer(ConsumerRecord<?,?> consumerRecord){
        log.info("==============================");
        log.info(consumerRecord.toString());
        log.info(consumerRecord.value().toString());
    }
}
