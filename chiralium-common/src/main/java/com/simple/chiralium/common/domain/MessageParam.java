package com.simple.chiralium.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 消息参数
 *
 * @author simpleZzz
 * @date 2022/10/08 13:53:07
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageParam {

    /**
     * 消息接收者
     */
    private String receiver;

    /**
     * 参数
     */
    private Map<String,String> variables;

}
