package com.hemai.manage.controller;



import com.hemai.manage.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 9:39 2018/7/26
 */
@Controller
public class MainController {
    @Autowired
    private TestService testService;


    @RequestMapping("calculate")
    public String calculate(){
        return "adminUser/calculate";
    }

    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping("page")
    public String page(){
        return "adminUser/page";
    }

}
