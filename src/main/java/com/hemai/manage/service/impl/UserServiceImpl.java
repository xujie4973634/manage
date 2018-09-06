package com.hemai.manage.service.impl;


import com.hemai.manage.base.service.BaseService;
import com.hemai.manage.base.service.BaseServiceImpl;
import com.hemai.manage.base.service.ServiceException;
import com.hemai.manage.model.User;
import com.hemai.manage.service.UserService;
import com.hmaikj.applet.utils.MD5Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 14:13 2018/8/3
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;


    @Autowired
    @Qualifier("userService")
    private BaseService baseService ;
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public User ajaxLogin(User user) {
        if (user == null || StringUtils.isEmpty(user.getLoginName()) ||
                StringUtils.isEmpty(user.getLoginPass())){
            throw new ServiceException("用户名或密码为空！");
        }
        String password = MD5Utils.getHexMD5(user.getLoginPass());
        User dataUser = getByFieldNameAndValue(User._loginName,user.getLoginName(),User._loginPass,
                                    User._id,User._loginName);
        if (dataUser == null || !dataUser.getLoginPass().equalsIgnoreCase(password)){
            throw new ServiceException("用户名或密码错误！");
        }
        return dataUser;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public int updatePwd(String newPwd, String oldPwd) {
        if (StringUtils.isEmpty(newPwd) || StringUtils.isEmpty(oldPwd)) {
            throw new ServiceException("新密码或者旧密码为空");
        }
        User user = (User) request.getSession().getAttribute("sessionUser");
        String password = getFieldValueById(user.getId(), User._loginPass);
        String oldMd5Pwd = MD5Utils.getHexMD5(oldPwd);
        if (!password.equalsIgnoreCase(oldMd5Pwd)) {
            throw new ServiceException("旧密码不正确");
        }
        return update(user.getId(), User._loginPass, MD5Utils.getHexMD5(newPwd));
    }


    public Long save() {
        User user = new User();
        String password = MD5Utils.getHexMD5("111111");
        user.setName("加贺");
        user.setLoginName("xujie");
        user.setLoginPass(password);
        user.setCreateBy(12L);
        user.setUpdateBy(1L);
        return baseService.save(user);
    }
}
