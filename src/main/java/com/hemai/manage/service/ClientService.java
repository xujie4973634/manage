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
 * @date: Created in 11:00 2018/8/10
 */
public interface ClientService extends BaseService<Client> {
   void update(Client client) ;

    void allSave( Client client);

    List<Client> findUidAndStatus(Client.Status status);

    Page<Client> search(PageParam pageParam, Client.Status status);
}
