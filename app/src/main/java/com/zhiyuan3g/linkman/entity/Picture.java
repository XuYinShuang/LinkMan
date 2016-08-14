package com.zhiyuan3g.linkman.entity;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Picture {
    private Bitmap thumbnail;
    private String size;
    private String name;

    public Picture(Bitmap thumbnail,String  size,String name) {
        this.thumbnail = thumbnail;
        this.size = size;
        this.name=name;
    }



    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }
//
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
