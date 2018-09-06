package com.hemai.manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 18:07 2018/8/22
 */
public class test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        String str = "205519401940194019401940194019401940194019401940194020352020";
        String[] strA = stringSpilt(str,4);
        List<Integer> longs = new LinkedList<>() ;
        for (String strE:strA){
            longs.add(Integer.valueOf(strE));

            }
            List<Integer> integers =new LinkedList<>();
            for (int ss:longs){
            if (ss > 1940){
                integers.add((int) sdf.parse(String.valueOf(ss)).getTime());
            }
            }
            int a = 0 ;
            for (int x = 0 ; x < integers.size() ; x++ ){
                 a = integers.get(x)+a;
            }

            System.out.println(a);


        String strC = "1830";
        Long date1 = sdf.parse(strC).getTime();
        Long date3 = (a - date1*3)/1000/60;
//        System.out.println(strD);
        System.out.println(date1);
//        System.out.println(date1*3);
//        System.out.println(date3);

    }


    //将字符串按照一定长度分割
    public static String[] stringSpilt(String s, int len){
        int spiltNum;//len->想要分割获得的子字符串的长度
        int i;
        int cache = len;//存放需要切割的数组长度
        spiltNum = (s.length())/len;
        String[] subs;//创建可分割数量的数组
        if((s.length()%len)>0){
            subs = new String[spiltNum+1];
        }else{
            subs = new String[spiltNum];
        }

//可用一个全局变量保存分割的数组的长度
//System.out.println(subs.length);
        int start = 0;
        if(spiltNum>0){
            for(i=0;i<subs.length;i++){
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
   public static String[] traversal(String str){

        return null ;
   }
}
