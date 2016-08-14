package com.zhiyuan3g.linkman.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.zhiyuan3g.linkman.R;
import com.zhiyuan3g.linkman.adapter.MediaAdapter;
import com.zhiyuan3g.linkman.entity.MediaEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class MediaActivity extends AppCompatActivity {
    ListView listView;
    Context context = this;
    List<MediaEntity> entities = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        listView = (ListView) findViewById(R.id.listView);


        entities = getMediaData();
        bindAdapter();



    }


    private List<MediaEntity> getMediaData() {

        ContentResolver resolver = this.getContentResolver();

        Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        //遍历媒体数据库
        if (cursor != null) {
            while (cursor.moveToNext()) {
                //获取媒体的歌手名
                String singer = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                //获取文件路径
                String path = cursor.getColumnName(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                //获取的文件总播时长
                int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                //获取歌曲的大侠
                Long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                //获取歌曲的名字
                String name = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));

                //将时长转换00:00：00制
                //获取时间格式
                SimpleDateFormat format = new SimpleDateFormat();
                //转换时区
                format.setTimeZone(TimeZone.getTimeZone("GTM+00:00"));
                //时长已准备完毕
                String time = format.format(duration);

                String sizes = getSize(size);
                MediaEntity entity = new MediaEntity(name, singer, sizes, time);
                entities.add(entity);

            }
            cursor.close();
        }
        return entities;
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
private void bindAdapter(){
    MediaAdapter adapter = new MediaAdapter(entities, context);
    listView.setAdapter(adapter);
}
}
