package com.simple.chiralium.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 短信内容模型
 * 最终发送时会将两者合并后发送
 * 分开是为了后期校验发送内容及url的合法性
 * @author simpleZzz
 * @date 2022/10/10 15:45:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SmsContentModel extends ContentModel {

    /**
     * 文本内容
     */
    private String content;

    /**
     * url链接
     */
    private String url;
}
