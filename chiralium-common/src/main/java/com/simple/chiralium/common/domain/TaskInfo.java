package com.simple.chiralium.common.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * 发送任务信息
 *
 * @author SimpleZzz
 * @date 2022/07/02 10:00:57
 */
@Data
@Builder
public class TaskInfo {

    /**
     * 模板Id
     */
    private Long templateId;

    /**
     * 业务Id
     */
    private String businessId;

    /**
     * 消息正文
     */
    private String content;

    /**
     * 接收人
     */
    private Set<String> receiverSet;
}
