package com.simple.chiralium.web;

import com.simple.chiralium.common.domain.SmsParam;
import com.simple.chiralium.handler.script.TencentSendSmsScript;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@Slf4j
public class SendSmsTest {
    @Autowired
    public TencentSendSmsScript tencentSendSmsScript;
    @Test
    public void sendSms(){
        Set<String> phoneSet = new HashSet<>();
        phoneSet.add("+8617309694133");
        String templateId="1291069";
        List<String> templateParams = Arrays.asList("1234","90");
        String sendSms = tencentSendSmsScript.sendSms(SmsParam.builder()
                .phoneNumbers(phoneSet)
                .templateId(templateId)
                .templateParams(templateParams).build());
        log.info(sendSms);
    }
}
