package com.simple.chiralium.support.pipeline;

import com.simple.chiralium.common.vo.BasicResultVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 责任链内容
 *
 * @author simpleZzz
 * @date 2022/09/30 15:41:20
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class ProcessContext<T extends ProcessModel> {

    /**
     * 责任链标识值
     */
    private String code;

    /**
     * 责任链是否需要终止
     */
    private Boolean needBreak;

    /**
     * 责任链存储内容
     */
    private T processModel;

    /**
     * 流程处理结果
     */
    private BasicResultVO response;
}
