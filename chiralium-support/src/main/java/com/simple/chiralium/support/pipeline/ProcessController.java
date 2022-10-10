package com.simple.chiralium.support.pipeline;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import com.simple.chiralium.common.enums.RespStatusEnum;
import com.simple.chiralium.common.vo.BasicResultVO;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 责任链控制器
 *
 * @author simpleZzz
 * @date 2022/09/30 16:21:28
 */
@Data
public class ProcessController {

    /**
     * 模板配置集合
     */
    private Map<String, ProcessTemplate> templateConfig;

    public ProcessContext process(ProcessContext context) {

        if (context == null) {
            context = new ProcessContext();
            context.setResponse(BasicResultVO.fail(RespStatusEnum.CONTEXT_IS_NULL));
            throw new RuntimeException();
        }

        String businessCode = context.getCode();
        if (StrUtil.isBlank(businessCode)) {
            context.setResponse(BasicResultVO.fail(RespStatusEnum.BUSINESS_CODE_IS_NULL));
            throw new RuntimeException();
        }

        ProcessTemplate processTemplate = templateConfig.get(businessCode);
        if (processTemplate == null) {
            context.setResponse(BasicResultVO.fail(RespStatusEnum.PROCESS_TEMPLATE_IS_NULL));
            throw new RuntimeException();
        }

        List<BusinessProcess> processList = processTemplate.getProcessList();
        if (CollUtil.isEmpty(processList)){
            context.setResponse(BasicResultVO.fail(RespStatusEnum.PROCESS_LIST_IS_NULL));
            throw new RuntimeException();
        }

        for (BusinessProcess businessProcess : processList) {
            businessProcess.process(context);
            if (context.getNeedBreak()){
                break;
            }
        }
        return context;
    }

}
