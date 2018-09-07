package com.hemai.manage.service;

import com.hemai.manage.base.service.BaseService;
import com.hemai.manage.model.Extra;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 11:34 2018/8/24
 */
public interface ExtraService extends BaseService<Extra> {
    Map format(List<List<Object>> lists) throws ParseException;
}
