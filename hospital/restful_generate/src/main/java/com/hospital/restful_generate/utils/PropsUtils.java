package com.hospital.restful_generate.utils;

import cn.hutool.setting.dialect.Props;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PropsUtils {
    public static Props getProps(String fileName) {
        Props props = new Props();
        // 使用当前类的类加载器加载资源，注意前面的 "/" 表示从 classpath 根目录开始
        try (InputStream inputStream = PropsUtils.class.getResourceAsStream("/" + fileName)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found: " + fileName);
            }
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
