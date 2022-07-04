package com.simple.chiralium.support.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 模板id
     */
    private Long templateId;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 批次Id
     */
    private String serialNo;

    /**
     * 请求id
     */
    private String requestId;

    /**
     * 计费条数
     */
    private Long chargingNum;

    /**
     * 短信内容
     */
    private String smsContent;

    /**
     * 回执内容
     */
    private String recordMessage;

    /**
     * 回执码
     */
    private String recordCode;

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
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
