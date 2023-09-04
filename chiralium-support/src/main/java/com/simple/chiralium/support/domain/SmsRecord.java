package com.simple.chiralium.support.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

/**
 * 短信发送记录
 *
 * @author SimpleZzz
 * @date 2022/07/02 11:27:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class SmsRecord {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @CreatedDate
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @LastModifiedDate
    private LocalDateTime updateTime;
}
