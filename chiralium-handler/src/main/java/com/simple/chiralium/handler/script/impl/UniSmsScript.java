package com.simple.chiralium.handler.script.impl;

import com.apistd.uni.Uni;
import com.apistd.uni.UniException;
import com.apistd.uni.UniResponse;
import com.apistd.uni.sms.UniMessage;
import com.apistd.uni.sms.UniSMS;
import com.simple.chiralium.common.SmsParam;
import com.simple.chiralium.common.SmsRecord;
import com.simple.chiralium.handler.script.SmsScript;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UniSmsScript implements SmsScript {

    @Override
    public SmsRecord send(SmsParam smsParam) {
        Uni.init(System.getenv("UNI_ACCESS_KEY_ID"));
        UniMessage message = UniSMS.buildMessage()
            .setSignature(smsParam.getSignature())
            .setTemplateId(smsParam.getTemplateId())
            .setTemplateData(smsParam.getTemplateData())
            .setTo(smsParam.getPhones().toArray(String[]::new));
        try {
            UniResponse response = message.send();

        } catch (UniException e){
            log.error(e.message);
        }
        return null;
    }
}
