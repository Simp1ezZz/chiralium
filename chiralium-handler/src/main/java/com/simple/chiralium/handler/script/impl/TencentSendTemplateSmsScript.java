package com.simple.chiralium.handler.script.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;
import com.simple.chiralium.common.constant.CommonConstant;
import com.simple.chiralium.handler.domain.SmsParam;
import com.simple.chiralium.common.enums.SmsSendStatusEnum;
import com.simple.chiralium.handler.script.SmsScript;
import com.simple.chiralium.support.domain.SmsRecord;
import com.tencentcloudapi.common.AbstractModel;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import com.tencentcloudapi.sms.v20210111.models.SendStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 腾讯发送模板短信
 * Tencent Cloud Sms Sendsms
 *
 * @author SimpleZzz
 * @date 2022/07/01 10:17:37
 */
@Slf4j
@Component
public class TencentSendTemplateSmsScript implements SmsScript {

    @Value("${tencent.sms.secretId}")
    public String secretId;
    @Value("${tencent.sms.secretKey}")
    public String secretKey;
    @Value("${tencent.sms.sdkAppId}")
    public String sdkAppId;
    @Value("${tencent.sms.signName}")
    String signName;

    /**
     * 发送短信
     *
     * @param smsParam 短信参数
     * @return {@link List}<{@link SmsRecord}>
     */
    @Override
    public List<SmsRecord> send(SmsParam smsParam) {
        try {
            //初始化短信发送客户端
            SmsClient client = initClient();
            //组装参数
            SendSmsRequest req = assembleReq(smsParam);
            //发送短信
            SendSmsResponse res = client.SendSms(req);
            //组装返回结果
            return assembleRecord(smsParam, res);

        } catch (TencentCloudSDKException e) {
            log.error("腾讯云发送短信时错误，错误信息:{},请求参数:{},本次请求的requestId:{}",
                    e.getMessage(), JSONUtil.toJsonStr(smsParam), e.getRequestId(), e);
        }
        return new ArrayList<>();
    }

    /**
     * 初始化短信发送客户端
     * #TODO 写死的参数后期均做成配置
     *
     * @return {@link SmsClient}
     */
    private SmsClient initClient() {
        Credential cred = new Credential(secretId, secretKey);
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setReqMethod(HttpProfile.REQ_POST);
        httpProfile.setConnTimeout(HttpProfile.TM_MINUTE);
        httpProfile.setEndpoint("sms.tencentcloudapi.com");


        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setSignMethod(ClientProfile.SIGN_SHA256);
        clientProfile.setHttpProfile(httpProfile);
        return new SmsClient(cred, "ap-guangzhou", clientProfile);
    }

    /**
     * 组装发送时的参数
     *
     * @param smsParam 短信参数
     * @return {@link SendSmsRequest}
     */
    private SendSmsRequest assembleReq(SmsParam smsParam) {
        SendSmsRequest req = new SendSmsRequest();
        req.setSmsSdkAppId(sdkAppId);
        req.setSignName(signName);
        req.setTemplateId(smsParam.getTemplateId().toString());
        // 模板参数分割
        req.setTemplateParamSet(smsParam.getContent().split(CommonConstant.SPLIT_CODE));
        req.setPhoneNumberSet(smsParam.getPhoneNumbers().toArray(new String[0]));
        return req;
    }

    /**
     * 组装发送回执结果
     *
     * @param smsParam 短信参数
     * @param response 短信回执响应
     * @return {@link List}<{@link SmsRecord}>
     */
    private List<SmsRecord> assembleRecord(SmsParam smsParam, SendSmsResponse response) {

        if (response == null || ArrayUtil.isEmpty(response.getSendStatusSet())) {
            return new ArrayList<>();
        }
        log.info(AbstractModel.toJsonString(response));

        List<SmsRecord> smsRecordList = new ArrayList<>(response.getSendStatusSet().length);

        for (SendStatus sendStatus : response.getSendStatusSet()) {
            SmsRecord smsRecord = SmsRecord.builder()
                    .templateId(smsParam.getTemplateId())
                    .phoneNumber(sendStatus.getPhoneNumber())
                    .serialNo(sendStatus.getSerialNo())
                    .requestId(response.getRequestId())
                    .chargingNum(sendStatus.getFee())
                    .smsContent(smsParam.getContent())
                    .recordCode(sendStatus.getCode())
                    .recordMessage(sendStatus.getMessage())
                    .sendStatus(CommonConstant.TENCENT_OK.equals(sendStatus.getCode())
                            ? SmsSendStatusEnum.RECEIVE_SUCCESS.getCode() : SmsSendStatusEnum.RECEIVE_FAIL.getCode())
                    .sendDate(LocalDateTime.now())
                    .build();
            smsRecordList.add(smsRecord);
        }

        return smsRecordList;
    }
}
