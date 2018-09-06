package com.hemai.manage.controller;

import com.hemai.manage.base.service.ServiceException;
import com.hemai.manage.model.Client;
import com.hemai.manage.model.History;
import com.hemai.manage.service.ClientService;
import com.hemai.manage.service.HistoryService;
import com.hemai.manage.utils.JsonResult;
import com.hemai.manage.utils.Page;
import com.hemai.manage.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 10:59 2018/8/10
 */
@Controller
@RequestMapping("client")
public class ClientController {

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    @Resource
    private ClientService clientService ;

    @Resource
    private HistoryService historyService ;

    @RequestMapping("save")
    public String save(Client client){

        clientService.allSave(client);
            return "adminUser/type";
    }

    @RequestMapping("update/client")
    public String updateClient(Client client){

        clientService.update(client);

        return "adminUser/type";



    }

    @RequestMapping("type")
   public String findUidAndUnderway() {
        return "adminUser/type";
   }

    @ResponseBody
    @RequestMapping("ajax/type")
    public Page<Client> ajaxUnderway(PageParam pageParam) {
       return clientService.search(pageParam,Client.Status.UNDERWAY);
    }

    @RequestMapping("nStart")
    public String findUidAndNotStart() {
        return "adminUser/nStart" ;
    }

    @ResponseBody
    @RequestMapping("ajax/nStart")
    public Page<Client> ajaxStart(PageParam pageParam) {
        return clientService.search(pageParam,Client.Status.NOT_START);
    }


    @RequestMapping("win")
    public String findUidAndWin() {
        return "adminUser/win" ;
    }

    @ResponseBody
    @RequestMapping("ajax/win")
    public Page<Client> ajaxWin(PageParam pageParam) {
        return clientService.search(pageParam,Client.Status.WIN);
    }

    @RequestMapping("failed")
    public String findUidAndFailed(Model model) {
        return "adminUser/failed" ;
    }

    @ResponseBody
    @RequestMapping("ajax/failed")
    public Page<Client> ajaxFailed(PageParam pageParam) {
        return clientService.search(pageParam,Client.Status.FAILED);
    }

}
