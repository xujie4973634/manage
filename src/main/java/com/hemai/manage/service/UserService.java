package com.hemai.manage.service;

import com.hemai.manage.base.service.BaseService;
import com.hemai.manage.model.User;
import org.springframework.stereotype.Service;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 9:36 2018/8/3
 */
public interface UserService extends BaseService<User> {

    User ajaxLogin(User user);
    int updatePwd(String newPwd, String oldPwd);
    Long save() ;
}
