package com.simple.chiralium.support.pipeline;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 责任链模板(将多个责任链串起来)
 *
 * @author simpleZzz
 * @date 2022/09/30 15:53:26
 */
@Getter
@Setter
public class ProcessTemplate {

    private List<BusinessProcess> processList;
}
