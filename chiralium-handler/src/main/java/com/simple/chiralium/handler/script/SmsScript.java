package com.simple.chiralium.handler.script;

import com.simple.chiralium.common.SmsParam;
import com.simple.chiralium.common.SmsRecord;

/**
 * 短信脚本
 *
 * @author 魑魅魍魉
 * @date 2024/07/02 17:01:43
 */
public interface SmsScript {

    /**
     * 发送
     *
     * @param smsParam SMS 参数
     * @return {@link SmsRecord }
     */
    SmsRecord send(SmsParam smsParam);

}
