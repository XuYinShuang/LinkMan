package com.zhiyuan3g.linkman.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.zhiyuan3g.linkman.R;
import com.zhiyuan3g.linkman.adapter.AudioAdapter;
import com.zhiyuan3g.linkman.entity.Audios;

import java.util.ArrayList;
import java.util.List;

public class AudioActivity extends AppCompatActivity {
    GridView gridView;
    List<Audios> audioses=new ArrayList<>();
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        gridView = (GridView) findViewById(R.id.gridView);

        audioses=getAudioData();


        //绑定适配器
        AudioAdapter audioAdapter=new AudioAdapter(context,audioses);
        gridView.setAdapter(audioAdapter);


    }
    //得到SD卡中的视频信息
    private List<Audios>getAudioData(){

        ContentResolver resolver=this.getContentResolver();

        Cursor cursor=resolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,null,null,null, MediaStore.Video.Media.DEFAULT_SORT_ORDER);
        if (cursor!=null){
            while (cursor.moveToNext()){
                String name=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME));
                long sizes=cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE));
                String path =  cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
                Bitmap thumbnail= ThumbnailUtils.createVideoThumbnail(path, MediaStore.Images.Thumbnails.MINI_KIND);

//
//                //将时长转换00:00：00制
//                //获取时间格式
//                SimpleDateFormat format = new SimpleDateFormat();
//                //转换时区
//                format.setTimeZone(TimeZone.getTimeZone("GTM+00:00"));
//                //时长已准备完毕
//                String time = format.format(sizes);


                String size=getSize(sizes);
                Audios audios=new Audios(name,size,thumbnail);
                audioses.add(audios);
            }
            cursor.close();
        }
        return audioses;

    }
    private static String getSize(float length) {
        float kb = 1024;
        float mb = 1024 * kb;
        float gb = 1024 * mb;
        if (length < kb) {
            return String.format("%d B", (int) length);
        } else if (length < mb) {
            return String.format("%.2f KB", length / kb);
        } else if (length < gb) {
            return String.format("% .2f MB", length / mb);
        } else {
            return String.format("%.2f GB", length / gb);
        }
    }

}
