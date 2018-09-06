package com.hemai.manage.service.impl;

import com.hemai.manage.base.service.BaseService;
import com.hemai.manage.base.service.BaseServiceImpl;
import com.hemai.manage.base.service.ServiceException;
import com.hemai.manage.model.Client;
import com.hemai.manage.model.History;
import com.hemai.manage.model.User;
import com.hemai.manage.service.ClientService;
import com.hemai.manage.service.HistoryService;
import com.hemai.manage.utils.Page;
import com.hemai.manage.utils.PageParam;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.invoke.empty.Empty;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 11:03 2018/8/10
 */
@Service("clientService")
public class ClientServiceImpl extends BaseServiceImpl<Client> implements ClientService {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Qualifier("clientService")
    @Autowired
    private BaseService baseService;

    @Autowired
    private ClientService clientService;

    @Resource
    private HistoryService historyService ;


    @Override
    @Transactional()
    public Long save(Client client) {
        User user = (User) session.getAttribute("sessionUser");
        if (user == null) {
            throw new ServiceException("您还未登录");
        } else {
            client.setUser(user);
            client.setCreateBy(user.getId());
            client.setUpdateBy(user.getId());

        }
        return super.save(client);
    }


    @Override
    @Transactional
    public List<Client> findUidAndStatus(Client.Status status) {
        User user = (User) session.getAttribute("sessionUser");
        if (user != null) {
            Criteria criteria = createCriteria(Client.class);
            criteria.add(Restrictions.eq(Client._user, user.getId()));
            criteria.add(Restrictions.eq("status", status));
            List<Client> underway = criteria.list();
            return underway;
        } else {
            throw new ServiceException("您还未登录");
        }
    }

    @Override
    @Transactional
    public Page<Client> search(PageParam pageParam, Client.Status status) {
        User user = (User) session.getAttribute("sessionUser");
        Conjunction conjunction = getConjunction();
        conjunction.add(Restrictions.eq(Client._user, user.getId()));
        conjunction.add(Restrictions.eq("status", status));
        return search(pageParam, conjunction, new Order[]{Order.desc(Client._createTime)});
    }


    @Transactional(readOnly = false)
    public Client get(Long id) {
        Client client = clientService.get(id);
        return client;
    }

    @Transactional(readOnly = false)
    public void allSave( Client client){
        save(client) ;
        Long clientId = client.getId() ;
        Client client1 = new Client() ;
        client1.setId(clientId);
        String status = String.valueOf(client.getStatus());
        History history = new History() ;
        history.setClientName(client.getName());
        history.setClientStatus(status);
        history.setClientDetails(client.getDetails());
        history.setClient(client1);
        history.setCreateBy(client.getCreateBy());
        history.setUpdateBy(client.getUpdateBy());
        historyService.save(history) ;

    }

    @Transactional(readOnly = false)
    public void update(Client client){
        clientService.update(client,Client._name,Client._company,Client._demand,Client._details,Client._phone,
                Client._source,Client._status);
        Client clients = clientService.get(client.getId()) ;
        Client client1 = new Client();
        client1.setId(client.getId());
        History history = new History() ;
        history.setClientName(clients.getName());
        history.setClientStatus(String.valueOf(clients.getStatus()));
        history.setClientDetails(clients.getDetails());
        history.setClient(client1);
        history.setCreateBy(clients.getCreateBy());
        history.setUpdateBy(clients.getUpdateBy());
        historyService.save(history);
    }
}
