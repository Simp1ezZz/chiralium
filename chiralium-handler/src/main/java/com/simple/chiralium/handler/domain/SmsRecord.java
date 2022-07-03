package com.simple.chiralium.handler.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 短信发送记录
 *
 * @author SimpleZzz
 * @date 2022/07/02 11:27:27
 */
@Data
@Builder
public class SmsRecord {

    /**
     * 主键
     */
    private Long id;

    /**
     * 模板id
     */
    private Integer templateId;

    /**
     * 手机号码
     */
    private String mobileNumber;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 批次Id
     */
    private String seriesId;

    /**
     * 短信内容
     */
    private String smsContent;

    /**
     * 回执内容
     */
    private String recordContent;

    /**
     * 发送状态
     */
    private Integer sendStatus;

    /**
     * 发送日期
     */
    private LocalDateTime sendDate;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
