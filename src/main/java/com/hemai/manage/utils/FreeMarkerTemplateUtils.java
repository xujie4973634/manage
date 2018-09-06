package com.hemai.manage.utils;


import com.hemai.manage.base.ExecutionContext;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Map;

/**
 * 模板工具类
 *
 * @author LiYanCheng
 * @since 2018-04-04 10:57:23
 */
public class FreeMarkerTemplateUtils {

    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    static {
        //这里比较重要，用来指定加载模板所在的路径
        try {
            CONFIGURATION.setTemplateLoader(new FileTemplateLoader(new File(ExecutionContext.getProjectPath() + "/pages/template")));
        } catch (IOException e) {

        }

        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }


    public static Template getTemplate(String templateName) throws IOException {
        return CONFIGURATION.getTemplate(templateName);
    }

    public static void process(Map<String, Object> modelData, String templateName, String targetFile) {
        FileOutputStream outputStream = null;
        Writer out = null;
        try {
            outputStream = new FileOutputStream(targetFile);
            Template template = getTemplate(templateName);
            out = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"), 10240);
            template.process(modelData, out);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(outputStream);
        }
    }
}
