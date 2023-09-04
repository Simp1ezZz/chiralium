package com.simple.chiralium.web.kafka;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class KafkaTestProducer {

    @Autowired
    public KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message) throws ExecutionException, InterruptedException {
        KafkaTestDomain kafkaTestDomain = new KafkaTestDomain();
        kafkaTestDomain.setCode("111").setName("系统日志1").setMessage(message);
        CompletableFuture<SendResult<String, String>> testTopic = kafkaTemplate.send("testTopic", JSON.toJSONString(kafkaTestDomain));
        SendResult<String, String> stringStringSendResult = testTopic.get();
        log.info(">>>>>>>>>>>>>>>>>>>>\n{}",stringStringSendResult.toString());
    }
}
