package com.simple.service.api.impl.action;

import com.simple.chiralium.common.constant.CommonConstant;
import com.simple.chiralium.common.domain.MessageParam;
import com.simple.chiralium.common.domain.SmsParam;
import com.simple.chiralium.common.domain.TaskInfo;
import com.simple.chiralium.common.enums.RespStatusEnum;
import com.simple.chiralium.common.vo.BasicResultVO;
import com.simple.chiralium.support.dao.MessageTemplateDao;
import com.simple.chiralium.support.domain.MessageTemplate;
import com.simple.chiralium.support.pipeline.BusinessProcess;
import com.simple.chiralium.support.pipeline.ProcessContext;
import com.simple.service.api.impl.domain.SendTaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 组装参数
 *
 * @author simpleZzz
 * @date 2022/10/08 14:24:44
 */
@Service
public class AssembleAction implements BusinessProcess<SendTaskModel> {

    @Autowired
    private MessageTemplateDao messageTemplateDao;

    @Override
    public void process(ProcessContext<SendTaskModel> processContext) {
        SendTaskModel sendTaskModel = processContext.getProcessModel();
        Long messageTemplateId = sendTaskModel.getMessageTemplateId();

        Optional<MessageTemplate> messageTemplate = messageTemplateDao.findById(messageTemplateId);
        if (!messageTemplate.isPresent() || messageTemplate.get().getIsDeleted().equals(CommonConstant.TRUE)) {
            processContext.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.TEMPLATE_NOT_FOUND));
        }

        List<MessageParam> messageParamList = sendTaskModel.getMessageParamList();
        List<TaskInfo> taskInfoList = new ArrayList<>();

        for (MessageParam messageParam : messageParamList) {

        }

    }
}
