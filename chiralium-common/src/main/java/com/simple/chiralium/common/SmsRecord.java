package com.simple.chiralium.common;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * 短信记录
 *
 * @author 魑魅魍魉
 * @date 2024/07/02 16:52:47
 */
@Data
@Builder
public class SmsRecord {

    /**
     * 主键
     */
    private Long id;

    /**
     * 消息模板 ID
     */
    private Long messageTemplateId;

    /**
     * 发送号码
     */
    private String phone;

    /**
     * 短信内容
     */
    private String msgContent;

    /**
     * 计费数量
     */
    private Integer chargingNum;

    /**
     * 发送时间
     */
    private LocalDateTime sendTime;

    /**
     * 发送状态
     */
    private Integer sendStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
