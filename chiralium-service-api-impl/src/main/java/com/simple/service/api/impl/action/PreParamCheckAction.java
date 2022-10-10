package com.simple.service.api.impl.action;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import com.simple.chiralium.common.domain.MessageParam;
import com.simple.chiralium.common.enums.RespStatusEnum;
import com.simple.chiralium.common.vo.BasicResultVO;
import com.simple.chiralium.support.pipeline.BusinessProcess;
import com.simple.chiralium.support.pipeline.ProcessContext;
import com.simple.service.api.impl.domain.SendTaskModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 前置参数检查
 *
 * @author simpleZzz
 * @date 2022/10/08 13:45:54
 */
@Service
public class PreParamCheckAction implements BusinessProcess<SendTaskModel> {


    /**
     * 过程
     *
     * @param context 上下文
     */
    @Override
    public void process(ProcessContext<SendTaskModel> context) {

        SendTaskModel sendTaskModel = context.getProcessModel();
        Long messageTemplateId = sendTaskModel.getMessageTemplateId();
        List<MessageParam> messageParamList = sendTaskModel.getMessageParamList();

        //检查messageTemplateId和messageParamList是否为空
        if (messageTemplateId == null || CollUtil.isEmpty(messageParamList)) {
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
            return;
        }

        //过滤messageParamList里receiver为空的
        List<MessageParam> resultParamList = messageParamList.stream()
                .filter(messageParam -> CharSequenceUtil.isNotBlank(messageParam.getReceiver()))
                .collect(Collectors.toList());
        if (CollUtil.isEmpty(resultParamList)){
            context.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
            return;
        }
        sendTaskModel.setMessageParamList(resultParamList);
    }
}
