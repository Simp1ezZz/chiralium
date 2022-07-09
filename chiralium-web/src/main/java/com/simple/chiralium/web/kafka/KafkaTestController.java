package com.simple.chiralium.web.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ExecutionException;

/**
 * 卡夫卡测试控制器
 *
 * @author simpleZzz
 * @date 2022/07/09 12:04:03
 */
@Controller
public class KafkaTestController {

    @Autowired
    private KafkaTestProducer producer;

    @GetMapping("/kafka/send")
    public void send(String message) throws ExecutionException, InterruptedException {
        producer.sendMessage(message);
    }
}
