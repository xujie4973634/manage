package com.hemai.manage.service.impl;

import com.hemai.manage.base.service.BaseServiceImpl;
import com.hemai.manage.model.Client;
import com.hemai.manage.model.History;
import com.hemai.manage.service.ClientService;
import com.hemai.manage.service.HistoryService;
import com.hemai.manage.utils.Page;
import com.hemai.manage.utils.PageParam;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 10:53 2018/8/17
 */
@Service("historyService")
public class HistoryServiceImpl extends BaseServiceImpl<History> implements HistoryService {

    @Qualifier("historyService")
    @Resource
    private HistoryService historyService ;


    @Override
    public Long save(History history) {

        return super.save(history);
    }

    @Override
    @Transactional
    public Page<History> search( Long id,PageParam pageParam) {
        Conjunction conjunction = getConjunction();
        conjunction.add(Restrictions.eq(History._client,id));
        return search(pageParam,conjunction,new Order[]{Order.desc(History._createTime)});
    }


}
