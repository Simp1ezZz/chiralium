package com.simple.chiralium.web;

import com.simple.chiralium.common.domain.TaskInfo;
import com.simple.chiralium.handler.handler.Handler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashSet;

@SpringBootTest
@Slf4j
class SendSmsTest {

    @Autowired
    private Handler handler;

    @Test
    void testSendSms(){
        boolean result = handler.doHandler(TaskInfo.builder()
                .templateId(1290981)
                .receiver(new HashSet<>(Collections.singletonList("17309694133")))
                .content("134679%;%30").build());
        Assertions.assertTrue(result);
    }
}
