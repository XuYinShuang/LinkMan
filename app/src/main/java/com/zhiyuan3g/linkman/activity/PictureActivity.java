package com.zhiyuan3g.linkman.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.zhiyuan3g.linkman.R;
import com.zhiyuan3g.linkman.adapter.PicAdapter;
import com.zhiyuan3g.linkman.entity.Picture;

import java.util.ArrayList;
import java.util.List;

public class PictureActivity extends AppCompatActivity {
    GridView gridView;
    List<Picture> pictures = new ArrayList<>();
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        gridView = (GridView) findViewById(R.id.gridView);
        pictures = getPicData();

        PicAdapter adapter = new PicAdapter(pictures, context);
        gridView.setAdapter(adapter);


    }

    private List<Picture> getPicData() {
        ContentResolver resolver = this.getContentResolver();
        Cursor cursor = resolver.query(Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {

                long  size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE));

                String path=cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                String name=cursor.getString(cursor.getColumnIndexOrThrow(Images.Media.DISPLAY_NAME));
                try {


                    BitmapFactory.Options options=new BitmapFactory.Options();
                    options.inSampleSize=14;
                    Bitmap bitmap=BitmapFactory.decodeFile(path,options);

                    String sizes=getSize(size);
                    Picture picture =new Picture(bitmap,sizes,name);
                    pictures.add(picture);

                }catch (Exception e){
                    e.printStackTrace();
                }


            }

            cursor.close();
        }

        return pictures;

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
