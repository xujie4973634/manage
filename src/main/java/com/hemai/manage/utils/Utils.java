package com.hemai.manage.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hmaikj.applet.utils.HttpUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 项目常用工具类
 *
 * @author LiYanCheng
 * @since 2018-03-16 19:33:02
 */
public final class Utils {

    /**
     * 获取地标信息
     *
     * @param address 地址信息
     * @return 0：经度 1 纬度
     */
    public static String[] getLocation(String address) {
        String ak = PropertiesUtils.getConfigProp().getProperty("tencent.map.ak");
        String url = "http://apis.map.qq.com/ws/geocoder/v1/?address=" + address + "&key=" + ak;
        String coordinate = HttpUtils.doGet(url, String.class);
        if (StringUtils.isEmpty(coordinate)) {
            return new String[0];
        }

        Map<String, String> resultMap = JSON.parseObject(coordinate, new TypeReference<Map<String, String>>() {
        });

        if (!"0".equalsIgnoreCase(resultMap.get("status"))) {
            return new String[0];
        }

        Map<String, String> map = JSON.parseObject(resultMap.get("result"), new TypeReference<Map<String, String>>() {
        });
        Map<String, String> locationMap = JSON.parseObject(map.get("location"), new TypeReference<Map<String, String>>() {
        });
        return new String[]{locationMap.get("lng"), locationMap.get("lat")};
    }

    /**
     * list分页
     *
     * @param pageParam 分页参数
     * @param list      数据集合
     * @param <T>       类型
     * @return 数据
     */
    public static <T> Page<T> findPage(PageParam pageParam, List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new Page<>();
        }

        Page<T> page = new Page<>();
        page.setTotal(list.size());
        int endIndex = pageParam.getPage() * pageParam.getPageSize();
        if (endIndex > list.size()) {
            endIndex = list.size();
        }

        List<T> rows = list.subList(pageParam.getStart(), endIndex);
        page.setRows(rows);
        return page;
    }

    public static double getDistance(String location1, String location2) {
        Double lng1 = Double.valueOf(location1.split(Constant.COMMA)[0]) * Math.PI / 180.0;
        Double lng2 = Double.valueOf(location2.split(Constant.COMMA)[0]) * Math.PI / 180.0;
        Double lat1 = Double.valueOf(location1.split(Constant.COMMA)[1]) * Math.PI / 180.0;
        Double lat2 = Double.valueOf(location2.split(Constant.COMMA)[1]) * Math.PI / 180.0;
        double a = lat1 - lat2;
        double b = lng1 - lng2;
        return 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(lat1)
                * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2))) * 6378.137;
    }

    /**
     * html 转换为图片
     *
     * @param htmlPath  html路径
     * @param imagePath 图片路径
     * @param width     宽度
     * @param height    高度
     */
    public static boolean html2Image(String htmlPath, String imagePath, int width, int height) {
        String command = "wkhtmltoimage --width " + width + " --height " + height + " " + htmlPath + " " + imagePath;
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
