package com.hemai.manage.utils;

import com.hemai.manage.base.framework.RequestContext;

import java.util.HashSet;
import java.util.Set;

public class RequestUri {
    static Set<String> sessionNotRequiredSet = new HashSet<>();

    static {
        sessionNotRequiredSet.add("/client/");
        sessionNotRequiredSet.add("login/loginPage");
        sessionNotRequiredSet.add("applet/user/appletLogin");
        sessionNotRequiredSet.add("login/ajaxLogin");
        sessionNotRequiredSet.add("file/upload");
    }

    public static boolean isSessionNotRequired(RequestContext requestContext) {
        String channel = requestContext.getChannel();
        String actionName = requestContext.getAction();

        return channel == null || processRequestUrl(channel, actionName);
    }

    private static boolean processRequestUrl(String channel, String actionName) {
        String requestUrl = channel + Constant.BACKSLASH + actionName;
        for (String notRequiredUrl : sessionNotRequiredSet) {
            if (requestUrl.contains(notRequiredUrl)) {
                return true;
            }
        }

        return false;
    }

}
