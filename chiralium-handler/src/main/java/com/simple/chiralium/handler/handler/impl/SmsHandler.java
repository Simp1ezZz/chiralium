package com.simple.chiralium.handler.handler.impl;

import cn.hutool.core.collection.CollUtil;
import com.simple.chiralium.common.domain.SmsParam;
import com.simple.chiralium.common.domain.TaskInfo;
import com.simple.chiralium.handler.handler.Handler;
import com.simple.chiralium.handler.script.SmsScript;
import com.simple.chiralium.support.domain.SmsRecord;
import com.simple.chiralium.support.dao.SmsRecordDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 短信消息处理程序
 *
 * @author simpleZzz
 * @date 2022/07/04 20:23:11
 */
@Service
@RequiredArgsConstructor
public class SmsHandler implements Handler {
    private final SmsScript smsScript;
    private final SmsRecordDao smsRecordMapper;

    /**
     * 处理短信
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean doHandler(TaskInfo taskInfo) {
        SmsParam smsParam = SmsParam.builder()
                .templateId(taskInfo.getTemplateId())
                .phoneNumbers(taskInfo.getReceiver())
                .content(taskInfo.getContent()).build();
        List<SmsRecord> smsRecords = smsScript.send(smsParam);
        if (CollUtil.isEmpty(smsRecords)) {
            return false;
        }
        smsRecordMapper.saveAll(smsRecords);
        return true;
    }
}
