package io.github.cuilan.tom.network;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;

/**
 * 下载工具
 *
 * @author zhangyan
 * @since 2021/12/1
 */
public class DownloadUtils {

    /**
     * 文件下载
     *
     * @param fileUrl      文件url地址
     * @param downloadPath 文件保存全路径
     * @return size 返回文件大小
     */
    public static long download(String fileUrl, String downloadPath) {
        return HttpUtil.downloadFile(fileUrl, FileUtil.file(downloadPath));
    }

}
