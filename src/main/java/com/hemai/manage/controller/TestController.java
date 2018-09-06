package com.hemai.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 17:25 2018/8/7
 */
@Controller
@RequestMapping("test")
public class  TestController {

    @RequestMapping("test")
    public String test(){

        return "test" ;
    }

    @RequestMapping("home")
    public String index(){
        return "home";
    }


}
