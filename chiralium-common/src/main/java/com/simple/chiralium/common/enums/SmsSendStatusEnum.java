package com.simple.chiralium.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 短信发送状态枚举
 *
 * @author simpleZzz
 * @date 2022/07/04 21:24:21
 */
@AllArgsConstructor
@ToString
@Getter
public enum SmsSendStatusEnum {
    /**
     * 调用渠道接口发送短信成功
     */
    SEND_SUCCESS(10, "调用渠道接口发送短信成功"),
    /**
     * 调用渠道接口发送短信失败
     */
    SEND_FAIL(20, "调用渠道接口发送短信失败"),
    /**
     * 用户接收到短信(渠道回执状态为成功)
     */
    RECEIVE_SUCCESS(30, "用户接收到短信(渠道回执状态为成功)"),
    /**
     * 用户未接收到短信(渠道回执状态为失败)
     */
    RECEIVE_FAIL(40, "用户未接收到短信(渠道回执状态为失败)");


    /**
     * 代码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String description;

    /**
     * 根据code获取描述
     *
     * @param code 状态码
     * @return {@link String} 描述信息
     */
    public static String getDescriptionByCode(Integer code){
        for (SmsSendStatusEnum value : SmsSendStatusEnum.values()) {
            if (value.getCode().equals(code)){
                return value.getDescription();
            }
        }
        return "";
    }

}
