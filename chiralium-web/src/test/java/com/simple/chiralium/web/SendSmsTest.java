package com.simple.chiralium.web;

import com.simple.chiralium.handler.TencentSendSms;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SendSmsTest {
    @Autowired
    public TencentSendSms tencentSendSms;
    @Test
    public void sendSms(){
        String sendSms = tencentSendSms.sendSms();
        log.info(sendSms);
    }
}
