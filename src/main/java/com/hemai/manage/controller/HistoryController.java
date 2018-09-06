package com.hemai.manage.controller;

import com.hemai.manage.base.service.ServiceException;
import com.hemai.manage.model.Client;
import com.hemai.manage.model.History;
import com.hemai.manage.service.ClientService;
import com.hemai.manage.service.HistoryService;
import com.hemai.manage.utils.JsonResult;
import com.hemai.manage.utils.Page;
import com.hemai.manage.utils.PageParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 8:36 2018/8/17
 */
@Controller
@RequestMapping("details")
public class HistoryController {

    @Resource
    private ClientService clientService ;

    @Resource
    private HistoryService historyService ;

    @RequestMapping("client")
    public String details(Client client ,Model model){
        Client clients = clientService.get(client.getId());
        model.addAttribute("clients",clients) ;
        return "adminUser/details" ;
    }

    @RequestMapping("history")
    public String history(Long id ,Model model){
        model.addAttribute("id",id);
        return "adminUser/history";
    }

    @ResponseBody
    @RequestMapping("ajax/history")
    public Page<History> ajaxHistory(Long id,PageParam pageParam){
        return historyService.search(id,pageParam) ;
    }
}
