package com.zhiyuan3g.linkman.entity;

/**
 * Created by Administrator on 2016/7/4.
 */
public class MediaEntity {
    private String MName;
    private String MSinger;
    private String MSize;

    private String Mtimer;

    public MediaEntity(String MName, String MSinger, String MSize, String Mtimer) {
        this.MName = MName;
        this.MSinger = MSinger;
        this.MSize = MSize;

        this.Mtimer=Mtimer;
    }

    public String getMtimer() {
        return Mtimer;
    }

    public void setMtimer(String mtimer) {
        Mtimer = mtimer;
    }


    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public String getMSinger() {
        return MSinger;
    }

    public void setMSinger(String MSinger) {
        this.MSinger = MSinger;
    }

    public String getMSize() {
        return MSize;
    }

    public void setMSize(String MSize) {
        this.MSize = MSize;
    }

}
