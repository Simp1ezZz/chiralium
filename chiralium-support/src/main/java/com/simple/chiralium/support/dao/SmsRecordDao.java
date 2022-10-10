package com.simple.chiralium.support.dao;

import com.simple.chiralium.support.domain.SmsRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * 短信记录Mapper
 *
 * @author simpleZzz
 * @date 2022/07/04 21:54:02
 */
public interface SmsRecordDao extends CrudRepository<SmsRecord,Long> {

}
