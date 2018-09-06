package com.hemai.manage.service;

import com.hemai.manage.base.service.BaseService;
import com.hemai.manage.model.Client;
import com.hemai.manage.model.History;
import com.hemai.manage.utils.Page;
import com.hemai.manage.utils.PageParam;

import java.util.List;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 10:53 2018/8/17
 */
public interface HistoryService extends BaseService<History> {



    Page<History> search(Long id,PageParam pageParam);

}
