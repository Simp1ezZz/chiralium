package com.simple.chiralium.handler.script;

import com.simple.chiralium.handler.domain.SmsParam;
import com.simple.chiralium.support.domain.SmsRecord;

import java.util.List;

/**
 * 短信发送脚本
 *
 * @author simpleZzz
 * @date 2022/07/04 20:34:15
 */
public interface SmsScript {

    /**
     * 发送
     *
     * @param smsParam 短信参数
     * @return {@link List}<{@link SmsRecord}> 渠道商接口返回数据
     */
    List<SmsRecord> send(SmsParam smsParam);
}
