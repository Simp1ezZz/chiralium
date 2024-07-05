package com.simple.chiralium.web;

import com.simple.chiralium.common.SmsParam;
import com.simple.chiralium.handler.script.impl.UniSmsScript;
import java.util.HashMap;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChiraliumWebApplicationTests {


    @Autowired
    private UniSmsScript uniSmsScript;

    @Test
    void contextLoads() {
    }

    @Test
    void testSend(){
        HashMap<String, String> templateData = new HashMap<>();
        templateData.put("code","111122");
        templateData.put("ttl","90");
        SmsParam smsParam = new SmsParam();
        smsParam.setPhones(Set.of("17309694133"));
        smsParam.setSignature("张昕");
        smsParam.setTemplateId("pub_verif_ttl4");
        smsParam.setTemplateData(templateData);
        uniSmsScript.send(smsParam);
    }

}
