package com.gupao.springbootdemo.bean;

import lombok.Data;

/**
 * 文件公共类
 */
@Data
public class FileInfo {


    private String fileName;

    private String fileType;

    private byte[] content;


}