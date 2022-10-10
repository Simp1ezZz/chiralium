package com.simple.service.api.impl.domain;

import com.simple.chiralium.common.domain.MessageParam;
import com.simple.chiralium.common.domain.TaskInfo;
import com.simple.chiralium.support.pipeline.ProcessModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 发送消息任务模型
 *
 * @author simpleZzz
 * @date 2022/10/08 13:49:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendTaskModel implements ProcessModel {

    /**
     * 消息模板id
     */
    private Long messageTemplateId;

    /**
     * 消息参数列表
     */
    private List<MessageParam> messageParamList;

    /**
     * 发送任务列表
     */
    private List<TaskInfo> taskInfoList;
}
