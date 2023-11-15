package io.github.cuilan.tom.network;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 多文件下载并压缩成zip文件
 *
 * @author zhangyan
 * @since 2023/3/8
 */
public class FileDownloadZipUtils {

    public static byte[] downloadAndZip(List<String> urls) throws IOException {
        // 缓冲区大小
        int bufferSize = 4096;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);

        for (String url : urls) {
            HttpResponse response = HttpRequest.get(url).execute();
            if (response.getStatus() != HttpStatus.HTTP_OK) {
                continue;
            }

            // 从 url 中切割出文件名
            String fileName = url.substring(url.lastIndexOf("/") + 1);

            // 创建 ZipEntry 名称对象
            ZipEntry ze = new ZipEntry(fileName);
            zos.putNextEntry(ze);

            // 将文件写入zip
            InputStream is = response.bodyStream();
            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                zos.write(buffer, 0, bytesRead);
            }
            zos.closeEntry();
            is.close();
        }
        zos.close();
        return baos.toByteArray();
    }

}
