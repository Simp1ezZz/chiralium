package com.simple.chiralium.handler.script;

import com.simple.chiralium.common.domain.SmsParam;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 腾讯发送短信测试
 * Tencent Cloud Sms Sendsms
 *
 * @author SimpleZzz
 * @date 2022/07/01 10:17:37
 */
@Slf4j
@Component
public class TencentSendSmsScript {

    @Value("${tencent.sms.secretId}")
    public String secretId;
    @Value("${tencent.sms.secretKey}")
    public String secretKey;
    @Value("${tencent.sms.sdkAppId}")
    public String sdkAppId;
    @Value("${tencent.sms.signName}")
    String signName;

    public String sendSms(SmsParam smsParam) {
        try {
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setReqMethod("POST");
            httpProfile.setConnTimeout(60);
            httpProfile.setEndpoint("sms.tencentcloudapi.com");


            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);
            SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);

            SendSmsRequest req = new SendSmsRequest();
            req.setSmsSdkAppId(sdkAppId);
            req.setSignName(signName);
            req.setTemplateId(smsParam.getTemplateId());
            req.setTemplateParamSet(smsParam.getTemplateParams().toArray(new String[0]));
            req.setPhoneNumberSet(smsParam.getPhoneNumbers().toArray(new String[0]));

            SendSmsResponse res = client.SendSms(req);
            String result = SendSmsResponse.toJsonString(res);
            log.info(result);
            return result;

        } catch (TencentCloudSDKException e) {
            log.error("腾讯云发送短信时错误，错误信息:{},请求参数:{},本次请求的requestId:{}",
                    e.getMessage(), smsParam, e.getRequestId(), e);
        }
        return null;
    }
}
