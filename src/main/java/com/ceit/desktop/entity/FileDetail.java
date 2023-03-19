package com.ceit.desktop.entity;

public class FileDetail {
    private String filename;
    private String desc;
    private String size;
    private String url;
    private String hash;

    public FileDetail(String filename, String desc, String size, String url, String hash) {
        this.filename = filename;
        this.desc = desc;
        this.size = size;
        this.url = url;
        this.hash = hash;
    }
}
