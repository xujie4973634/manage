package com.hemai.manage.controller;

import com.hemai.manage.base.service.ServiceException;
import com.hemai.manage.model.User;
import com.hemai.manage.service.UserService;
import com.hemai.manage.utils.Constant;
import com.hemai.manage.utils.JsonResult;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 15:40 2018/8/3
 */
@Controller
public class LoginController {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Resource
    private UserService userService ;

    @RequestMapping("login/loginPage")
    public String loginPage(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("login/ajaxLogin")
    public JsonResult<User> ajaxLogin(User user, HttpServletRequest request){
       try {
           user = userService.ajaxLogin(user) ;
       }catch (ServiceException e){
           return new JsonResult<>(false,e.getMessage());
       }
        request.getSession().setAttribute("sessionUser",user);
       return new JsonResult<>(true,"");
    }

    @ResponseBody
    @RequestMapping("login/updatePwd")
    public JsonResult<User> updatePwd(String newPwd, String oldPwd) {
        try {
            userService.updatePwd(newPwd, oldPwd);
        } catch (ServiceException e) {
            return new JsonResult<>(false, e.getMessage());
        }

        return new JsonResult<>(true, "");
    }

    @RequestMapping("login/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/home";
    }
}
