package com.simple.chiralium.service.api.domain;

import lombok.Data;

/**
 * 发送响应
 *
 * @author simpleZzz
 * @date 2022/07/08 23:10:51
 */
@Data
public class SendResponse {

    private String code;

    private String message;
}
