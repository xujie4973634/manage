package com.hemai.manage.controller;

import com.hemai.manage.base.service.ServiceException;
import com.hemai.manage.model.User;
import com.hemai.manage.service.UserService;
import com.hemai.manage.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 15:35 2018/8/3
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService ;

    @RequestMapping(value = "nin")
    public String nin(){
        return "adminUser/warning";
    }

    @RequestMapping(value = "index")
    public String index(){
        return "adminUser/index";
    }


    @RequestMapping(value = "updatePwd")
    public String updatePwd(){ return "adminUser/updatePwd"; }

    @ResponseBody
    @RequestMapping(value = "save")
    public String save() {
        userService.save();
        return "good";
    }


}
