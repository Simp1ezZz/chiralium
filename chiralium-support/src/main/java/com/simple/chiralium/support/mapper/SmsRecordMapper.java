package com.simple.chiralium.support.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simple.chiralium.support.domain.SmsRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信记录Mapper
 *
 * @author simpleZzz
 * @date 2022/07/04 21:54:02
 */
@Mapper
public interface SmsRecordMapper extends BaseMapper<SmsRecord> {


}
