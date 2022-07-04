package com.simple.chiralium.handler.handler;

import com.simple.chiralium.common.domain.TaskInfo;

/**
 * 消息处理接口
 *
 * @author SimpleZzz
 * @date 2022/07/02 09:59:16
 */
public interface Handler {

    /**
     * 处理消息
     *
     * @param taskInfo 任务信息
     * @return boolean 发送成功或失败
     */
    boolean doHandler(TaskInfo taskInfo);
}
