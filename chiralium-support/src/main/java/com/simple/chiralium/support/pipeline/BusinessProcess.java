package com.simple.chiralium.support.pipeline;

/**
 * 责任链执行接口
 *
 * @author simpleZzz
 * @date 2022/09/30 15:39:59
 */
public interface BusinessProcess<T extends ProcessModel> {

    /**
     * 执行器
     *
     * @param processContext 责任链内容
     */
    void process(ProcessContext<T> processContext);
}
