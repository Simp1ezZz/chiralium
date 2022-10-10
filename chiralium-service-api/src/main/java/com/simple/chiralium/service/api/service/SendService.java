package com.simple.chiralium.service.api.service;

import com.simple.chiralium.service.api.domain.SendRequest;
import com.simple.chiralium.service.api.domain.SendResponse;

import java.util.List;

/**
 * 发送消息服务
 *
 * @author simpleZzz
 * @date 2022/07/30 22:09:43
 */
public interface SendService {

    /**
     * 单条发送
     *
     * @param sendRequest 发送请求
     * @return {@link SendResponse}
     */
    SendResponse send(SendRequest sendRequest);

    /**
     * 批量发送
     *
     * @param sendRequestList 发送请求列表
     * @return {@link SendResponse}
     */
    SendResponse batchSend(List<SendRequest> sendRequestList);
}
