package com.simple.chiralium.common;

import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SMS 参数
 *
 * @author 魑魅魍魉
 * @date 2024/07/02 16:52:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SmsParam {

    private String templateId;

    private Map<String, String> templateData;

    private Set<String> phones;

    private String signature;
}
