package com.simple.chiralium.support.dao;

import com.simple.chiralium.support.domain.MessageTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 消息模板Dao
 *
 * @author simpleZzz
 * @date 2022/10/10 14:39:20
 */
public interface MessageTemplateDao extends JpaRepository<MessageTemplate,Long> {
}
