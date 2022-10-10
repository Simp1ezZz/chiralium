package com.simple.chiralium.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 系统状态枚举
 *
 * @author simpleZzz
 * @date 2022/10/08 10:10:04
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespStatusEnum {

    /**
     * 成功
     */
    SUCCESS("0","操作成功"),

    /**
     * 失败
     */
    FAIL("-1","操作失败"),

    /**
     * 客户端错误
     */
    CLIENT_BAD_PARAMETERS("A0001","客户端参数错误"),

    TEMPLATE_NOT_FOUND("A0002","模板未找到或已被删除"),

    /**
     * pipeline
     */
    CONTEXT_IS_NULL("P0001","流程上下文为空"),
    BUSINESS_CODE_IS_NULL("P0002","业务代码为空"),
    PROCESS_TEMPLATE_IS_NULL("P0003","流程模板为空"),
    PROCESS_LIST_IS_NULL("P0004","业务处理器为空");

    private final String code;
    private final String msg;
}
