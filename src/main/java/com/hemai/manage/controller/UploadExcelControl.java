package com.hemai.manage.controller;

import java.io.InputStream;

import com.hemai.manage.model.Extra;
import com.hemai.manage.service.ExtraService;
import com.hemai.manage.utils.ImportExcelUtil;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 15:30 2018/8/21
 */
@Controller
@RequestMapping("uploadExcel")
public class UploadExcelControl {

    @Resource
    private ExtraService extraService;

    @ResponseBody
    @RequestMapping("ajaxUpload")
    public  Map  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");
        InputStream in =null;
        List<List<Object>> listob = null;
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }
        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
          Map<String,Object> map = extraService.format(listob);
          if (map != null){
              return map ;
          }else {
              PrintWriter out = null;
              response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
              out = response.getWriter();
              out.print("文件导入成功！");
              out.flush();
              out.close();
          }

   return map ;

    }

}


