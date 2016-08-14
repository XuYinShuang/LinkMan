package com.zhiyuan3g.linkman.entity;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Audios {

    private String name;
    private String size;
    private Bitmap thumbnail;

    public Audios(String name, String size,Bitmap thumbnail) {
        this.name = name;
        this.size = size;
        this.thumbnail=thumbnail;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
