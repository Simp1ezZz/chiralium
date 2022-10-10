package com.simple.chiralium.common.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * 短信参数
 *
 * @author SimpleZzz
 * @date 2022/07/01 18:15:48
 */
@Data
@Builder
public class SmsParam {

    /**
     * 电话号码
     */
    private Set<String> phoneNumbers;

    /**
     * 模板id
     */
    private Integer templateId;

    /**
     * 正式内容(多个模板参数用%;%分割)
     */
    private String content;
}
