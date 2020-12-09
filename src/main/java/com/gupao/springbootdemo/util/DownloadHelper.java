package com.gupao.springbootdemo.util;

import com.gupao.springbootdemo.bean.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Description:下载预览帮助类
 * <p>
 * 功能预览:
 * 1.在线预览pdf.....
 * 2.压缩多个文件成zip包,下载
 * 3.直接下载文件
 * </p>
 * version: 1.0.1
 * User: zhouzhou
 * Date: 2018-10-30
 * Time: 14:08
 */
public class DownloadHelper {
    private static final Logger logger = LoggerFactory.getLogger(DownloadHelper.class);

    /**
     * 预览pdf
     *
     * @param fileInfo 标准文件类
     */
    public static void previewFile(FileInfo fileInfo) {
        try {

            // 进行预览流
            HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            httpServletResponse.setContentType("application/" + fileInfo.getFileType());
            OutputStream toClient = new BufferedOutputStream(httpServletResponse.getOutputStream());
            toClient.write(fileInfo.getContent());
            toClient.flush();
            toClient.close();
        } catch (Exception e) {
            logger.warn(String.format("预览文件{%s}发生异常{%s}", fileInfo.getFileName(), e.getMessage()), e);
            throw new RuntimeException(String.format("预览文件{%s}发生异常{%s}", fileInfo.getFileName(), e.getMessage()));
        }
    }

    /**
     * 压缩文件
     *
     * @param zipFileName     压缩文件名
     * @param fileInfos 标准文档集合
     * @throws IOException 抛出IO异常
     */
    public static void zipFile(String zipFileName, List<FileInfo> fileInfos) throws IOException {
        if (!CollectionUtils.isEmpty(fileInfos)) {
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

            OutputStream outputStream = httpServletResponse.getOutputStream();

            //得请求头中的User-Agent
            httpServletResponse.setContentType("application/zip");
            // 告诉客户端该文件不是直接解析，而是以附件形式打开（下载）
            httpServletResponse.setHeader("Content-Disposition", "attachment"
                    + ";filename=" + URLEncoder.encode(zipFileName, "UTF-8"));

            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
            // 打包中
            for (FileInfo fileInfo : fileInfos) {
                ZipEntry entry = new ZipEntry(fileInfo.getFileName());
                zipOutputStream.putNextEntry(entry);
                zipOutputStream.write(fileInfo.getContent());
                zipOutputStream.closeEntry();
            }

            zipOutputStream.flush();
            zipOutputStream.close();

            outputStream.flush();
            outputStream.close();
        }
    }

    /**
     * 下载指定单个文件
     *
     * @param fileInfo 标准文档类
     */
    public static void downloadFile(FileInfo fileInfo) throws Exception {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        OutputStream outputStream = httpServletResponse.getOutputStream();
        String type = fileInfo.getFileType();
        String fileName = fileInfo.getFileName();
        //得请求头中的User-Agent
        httpServletResponse.setContentType("application/" + type);
        // 告诉客户端该文件不是直接解析，而是以附件形式打开（下载）
        httpServletResponse.setHeader("Content-Disposition", "attachment"
                + ";filename=" + URLEncoder.encode(fileName, "UTF-8"));
        outputStream.write(fileInfo.getContent());

        // 关闭流
        outputStream.flush();
        outputStream.close();
    }

}
