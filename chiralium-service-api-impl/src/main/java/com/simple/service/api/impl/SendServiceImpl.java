package com.simple.service.api.impl;

import com.simple.chiralium.service.api.domain.SendRequest;
import com.simple.chiralium.service.api.domain.SendResponse;
import com.simple.chiralium.service.api.service.SendService;

import java.util.List;

/**
 * 发送服务实现类
 *
 * @author simpleZzz
 * @date 2022/07/30 22:11:59
 */
public class SendServiceImpl implements SendService {
    @Override
    public SendResponse send(SendRequest sendRequest) {
        return null;
    }

    @Override
    public SendResponse batchSend(List<SendRequest> sendRequestList) {
        return null;
    }
}
