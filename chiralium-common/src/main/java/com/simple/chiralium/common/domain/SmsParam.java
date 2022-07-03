package com.simple.chiralium.common.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
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

    private Set<String> phoneNumbers;

    private Integer templateId;

    private List<String> templateParams;
}
