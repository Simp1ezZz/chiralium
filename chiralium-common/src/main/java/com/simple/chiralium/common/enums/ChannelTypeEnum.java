package com.simple.chiralium.common.enums;

import com.simple.chiralium.common.dto.ContentModel;
import com.simple.chiralium.common.dto.SmsContentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 渠道类型
 *
 * @author simpleZzz
 * @date 2022/10/10 15:48:35
 */
@AllArgsConstructor
@Getter
public enum ChannelTypeEnum {

    /**
     * 短信渠道
     */
    SMS(10,"短信", SmsContentModel.class);

    /**
     * 渠道代码
     */
    private final Integer code;

    /**
     * 渠道描述
     */
    private final String description;

    /**
     * 渠道对应发送模型类
     */
    private final Class<? extends ContentModel> contentModelClass;

    public static Class<? extends ContentModel> getContentModelClassByCode(Integer code){
        for (ChannelTypeEnum value : values()) {
            if (value.getCode().equals(code)){
                return value.getContentModelClass();
            }
        }
        return null;
    }
}
