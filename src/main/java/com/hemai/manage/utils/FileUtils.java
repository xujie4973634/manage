package com.hemai.manage.utils;

import com.mchange.lang.ByteUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * file utils
 *
 * @author LiYanCheng@HF
 * @version 1.0.0
 * @since 2016年10月10日17:36:20
 */
public class FileUtils extends org.apache.commons.io.FileUtils {

    private static final Log LOG = LogFactory.getLog(FileUtils.class);

    /**
     * 获取文件后缀名
     *
     * @param fileName 文件名称
     * @return 后缀名
     * @since 2016年10月10日18:23:34
     */
    public static String getFileSuffix(String fileName) {
        int lastIndex = fileName.lastIndexOf(Constant.POINT);
        return fileName.substring(lastIndex + 1);
    }

    /**
     * 字符串压缩
     *
     * @param paramString 字符串
     * @return 压缩后的 ascii 字符串
     * @since 2016年8月30日18:02:22
     */
    public static String compress(String paramString) {
        if (StringUtils.isBlank(paramString)) {
            return null;
        }

        ByteArrayOutputStream byteArrayOutputStream = null;
        ZipOutputStream zipOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            zipOutputStream.putNextEntry(new ZipEntry("0"));
            zipOutputStream.write(paramString.getBytes());
            zipOutputStream.closeEntry();
            byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
            return ByteUtils.toHexAscii(arrayOfByte);
        } catch (IOException e) {
            LOG.error(e);
            return null;
        } finally {
            try {
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            } catch (IOException ex) {
                LOG.error(ex);
            }
        }
    }

    /**
     * 字符串解压
     *
     * @param paramString 字符串
     * @return 解压后的字符串
     * @since 2016年8月30日18:02:22
     */
    public static String decompress(String paramString) {
        if (StringUtils.isBlank(paramString)) {
            return null;
        }

        ByteArrayOutputStream byteArrayOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ZipInputStream zipInputStream = null;
        try {
            byte[] data = ByteUtils.fromHexAscii(paramString);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayInputStream = new ByteArrayInputStream(data);
            zipInputStream = new ZipInputStream(byteArrayInputStream);
            zipInputStream.getNextEntry();
            byte[] arrayOfByte = new byte[1024];
            int index;
            while ((index = zipInputStream.read(arrayOfByte)) > 0) {
                byteArrayOutputStream.write(arrayOfByte, 0, index);
            }

            return byteArrayOutputStream.toString();
        } catch (IOException e) {
            LOG.error(e);
            return null;
        } finally {
            try {
                if (zipInputStream != null) {
                    zipInputStream.close();
                }

                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }

                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            } catch (IOException ex) {
                LOG.error(ex);
            }
        }
    }


    /**
     * 将多张二维码图片合到一张A4图(必须是宽度 高度一致的图片)
     *
     * @param filePaths 图片路径
     * @return 生成的图片路径
     */
    public static List<String> buildImg(List<String> filePaths) throws Exception {
        if (CollectionUtils.isEmpty(filePaths)) {
            return new ArrayList<>(0);
        }
        File _file = new File(filePaths.get(0));

        Image _src = ImageIO.read(_file);

        //获取图片的宽度
        int width = _src.getWidth(null);
        //获取图像的高度
        int height = _src.getHeight(null);

        List<String> qrCodePaths = new ArrayList<>(filePaths.size() / 6 + 1);

        String qrCodePath = PropertiesUtils.getEnvProp().getProperty("file.qrCode.address");
        long timeStamp = System.currentTimeMillis();
        int fileSize = filePaths.size();
        for (int i = 0; i < fileSize; i = i + 6) {
            String filePath = qrCodePath + timeStamp + i + ".jpg";
            FileOutputStream out = new FileOutputStream(filePath);
            BufferedImage tag = new BufferedImage(width * 2 + 30, height * 3 + 40, BufferedImage.TYPE_INT_RGB);
            Graphics2D gd = tag.createGraphics();
            gd.setColor(Color.WHITE);
            gd.fillRect(0, 0, width * 2 + 30, height * 3 + 40);//填充整个屏幕
            Graphics g = tag.createGraphics();
            g.setColor(Color.WHITE);
            //第一行第一张
            if (fileSize - i > 0) {
                g.drawImage(ImageIO.read(new File(filePaths.get(i))), 10, 10, width, height, null);
            }
            //第一行第二张
            if (fileSize - i > 1) {
                g.drawImage(ImageIO.read(new File(filePaths.get(i + 1))), width + 20, 10, width, height, null);
            }
            //第二行第一张
            if (fileSize - i > 2) {
                g.drawImage(ImageIO.read(new File(filePaths.get(i + 2))), 10, height + 20, width, height, null);
            }
            //第二行第二张
            if (fileSize - i > 3) {
                g.drawImage(ImageIO.read(new File(filePaths.get(i + 3))), width + 20, height + 20, width, height, null);
            }
            //第三行第一张
            if (fileSize - i > 4) {
                g.drawImage(ImageIO.read(new File(filePaths.get(i + 4))), 10, height * 2 + 30, width, height, null);
            }
            //第三行第er张
            if (fileSize - i > 5) {
                g.drawImage(ImageIO.read(new File(filePaths.get(i + 5))), width + 20, height * 2 + 30, width, height, null);
            }
            g.dispose();
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            out.close();
            qrCodePaths.add(filePath);
        }

        return qrCodePaths;
    }
}
