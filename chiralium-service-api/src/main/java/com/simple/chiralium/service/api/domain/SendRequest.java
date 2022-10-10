package com.simple.chiralium.service.api.domain;

import lombok.Data;

/**
 * 发送请求
 *
 * @author simpleZzz
 * @date 2022/07/08 23:10:36
 */
@Data
public class SendRequest {

    /**
     * 消息模板id
     */
    private Long messageTemplateId;

    /**
     * 接收者
     */
    private String receiver;
}
