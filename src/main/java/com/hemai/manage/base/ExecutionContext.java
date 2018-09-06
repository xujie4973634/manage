package com.hemai.manage.base;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于在应用内及应用间保存、传递执行上下文信息。
 *
 * @author LiYanCheng@HF
 * @version 1.0.0
 * @since 2016年8月19日12:49:41
 */
public class ExecutionContext {
    /**
     * 用于保存线程相关信息
     */
    transient static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<Map<String, String>>();

    /**
     * 用户id 键
     */
    public static final String USER_ID = "user_id";

    /**
     * openid 键
     */
    public static final String OPEN_ID = "open_id";

    /**
     * 上下文名称
     */
    public static final String CONTEXT_PATH = "context_path";

    /**
     * 服务器名称
     */
    public static final String SERVER_NAME = "server_name";

    /**
     * 服务器名称
     */
    public static final String CLIENT_IP = "client_ip";

    /**
     * 门店ID
     */
    public static final String STORE_ID = "store_id";

    /**
     * 角色类型
     */
    public static final String ROLE_TYPE = "role_type";

    /**
     * 角色类型
     */
    public static final String PROJECT_PATH = "project_path";



    /**
     * 构造函数
     */
    public ExecutionContext() {
        // For Spring initialization.
    }

    /**
     * 从 ThreadLocal中获取名值Map(不包含appCode)
     *
     * @return 名值Map
     */
    public static Map<String, String> getContextMap() {
        return threadLocal.get();
    }

    /**
     * 从 ThreadLocal 获取名值Map
     *
     * @param contextMap 名值Map
     */
    public static void setContextMap(Map<String, String> contextMap) {
        threadLocal.set(contextMap);
    }

    /**
     * （获取键下的值.如果不存在，返回null；如果名值Map未初始化，也返回null） Get the value of key. Would
     * return null if context map hasn't been initialized.
     *
     * @param key 键
     * @return 键下的值
     */
    public static String get(String key) {
        Map<String, String> contextMap = getContextMap();
        if (contextMap == null) {
            return null;
        }

        return contextMap.get(key);
    }

    /**
     * （设置名值对。如果Map之前为null，则会被初始化） Put the key-value into the context map;
     * <p>
     * Initialize the map if the it doesn't exist.
     *
     * @param key   键
     * @param value 值
     * @return 之前的值
     */
    public static String put(String key, String value) {
        Map<String, String> contextMap = getContextMap();
        if (contextMap == null) {
            contextMap = new HashMap<>();
            setContextMap(contextMap);
        }

        return contextMap.put(key, value);
    }

    public static Long getUserId() {
        String id = get(USER_ID);
        if (StringUtils.isEmpty(id)) {
            return null;
        }

        return Long.valueOf(id);
    }

    public static void setUserId(Long userId) {
        put(USER_ID, String.valueOf(userId));
    }

    public static String getOpenId() {
        return get(OPEN_ID);
    }

    public static void setOpenId(String openId) {
        put(OPEN_ID, openId);
    }

    public static String getRoleType() {
        return get(ROLE_TYPE);
    }

    public static void setRoleType(String roleType) {
        put(ROLE_TYPE, roleType);
    }

    public static void clear() {
        getContextMap().clear();
    }

    public static String getServerName() {
        return get(SERVER_NAME);
    }

    public static void setServerName(String serverName) {
        put(SERVER_NAME, serverName);
    }

    public static String getClientIp() {
        return get(CLIENT_IP);
    }

    public static void setClientIp(String clientIp) {
        put(CLIENT_IP, clientIp);
    }

    public static String getStoreId() {
        return get(STORE_ID);
    }

    public static void setStoreId(String storeId) {
        put(STORE_ID, storeId);
    }

    public static String getProjectPath() {
        return get(PROJECT_PATH);
    }

    public static void setProjectPath(String projectPath) {
        put(PROJECT_PATH, projectPath);
    }

    public static String getContextPath() {
        return get(CONTEXT_PATH);
    }

    public static void setContextPath(String contextPath) {
        put(CONTEXT_PATH, contextPath);
    }

}
