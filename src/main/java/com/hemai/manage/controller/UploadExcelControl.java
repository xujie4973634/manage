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
          Map<String,Object> map = format(listob);
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

    /**
     *   分割字符串
     * @param s
     * @param len
     * @return
     */
    public String[] slicer(String s,int len){//len->想要分割获得的子字符串的长度
        int spiltNum;
        int i;
        int cache = len;//存放需要切割的数组长度
        spiltNum = (s.length())/len ;
        String[] subs;//创建可分割数量的数组
        if((s.length()%len)>0){
            subs = new String[spiltNum+1];
        }else{
            subs = new String[spiltNum];
        }
        //可用一个全局变量保存分割的数组的长度
        int total = subs.length;
        int start = 0;
        if(spiltNum>0){
            for (i = 0 ; i < total ; i++){
                if(i==0){
                    subs[0] = s.substring(start, len);
                    start = len;
                }else if(i>0 && i<subs.length-1){
                    len = len + cache ;
                    subs[i] = s.substring(start,len);
                    start = len ;
                }else{
                    subs[i] = s.substring(len,s.length());
                }
            }
        }
        return subs ;
    }

    public Map format(List<List<Object>> lists) throws ParseException {
        List<Object> list = new LinkedList<>();
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < lists.size(); i++) {
            if (i == 15){
                int num = 0 ;
                Extra extra = new Extra() ;
              list = lists.get(i);
              num = output(list) ;
              map.put("小燕子",num);
              extra.setName("小燕子");
              extra.setOvertime(num);
              extra.setCreateBy(2L);
              extra.setCreateTime(new Date());
              extra.setUpdateBy(2L);
              extraService.save(extra);
                continue;
            }
            if (i == 19){
                int num = 0 ;
                Extra extra = new Extra() ;
               list = lists.get(i);
                num = output(list) ;
                map.put("小娟子",num);
                extra.setName("小娟子");
                extra.setOvertime(num);
                extra.setCreateBy(3L);
                extra.setCreateTime(new Date());
                extra.setUpdateBy(3L);
                extraService.save(extra);
                continue;
            }
            if (i==22){
                int num = 0 ;
                Extra extra = new Extra() ;
                list= lists.get(i);
                num = output(list) ;
                map.put("小瓶子",num);
                extra.setName("小瓶子");
                extra.setOvertime(num);
                extra.setCreateBy(4L);
                extra.setCreateTime(new Date());
                extra.setUpdateBy(4L);
                extraService.save(extra);
                continue;
            }
            if (i == 25){
                int num = 0 ;
                Extra extra = new Extra() ;
               list = lists.get(i);
                num = output(list) ;
                map.put("许杰",num);
                extra.setName("许杰");
                extra.setOvertime(num);
                extra.setCreateBy(5L);
                extra.setCreateTime(new Date());
                extra.setUpdateBy(5L);
                extraService.save(extra);
                continue;
            }
        }
        return map ;
    }

    public int output(List<Object> list) throws ParseException {
        String str = String.valueOf(list) ;
        String str1 = "[^\\d]";
        String strA = str.replaceAll(str1,"");
        String[] strB = slicer(strA,4);
        List<Integer> longs = new LinkedList<>() ;
        for (String strC:strB){
            if (Integer.valueOf(strC)>1830){
                longs.add(Integer.valueOf(strC));
            }
        }
        int num = traversal(longs);

       return num;
    }

    /**
     *   计算加班结果
     * @param list
     * @return
     * @throws ParseException
     */
    public int traversal(List<Integer> list) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        double a = 0 ;
        double s = 37800000.0 ;
        List<Double> sr = new ArrayList<>();
        for (double b :list ){
            sr.add((double) sdf.parse(String.valueOf(b)).getTime());
        }
        for (int x = 0 ; x < sr.size(); x++){
            a = sr.get(x)+a;
        }
      double result = (a-s*sr.size())/1000/60/60;
        BigDecimal bd = new BigDecimal(result).setScale(0,BigDecimal.ROUND_HALF_UP);
        int s1 = Integer.parseInt(String.valueOf(bd));

        return s1;
    }

    @RequestMapping("print")
    public String print(){
        return null ;
    }
}


