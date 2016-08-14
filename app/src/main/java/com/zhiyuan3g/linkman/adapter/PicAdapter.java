package com.zhiyuan3g.linkman.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyuan3g.linkman.R;
import com.zhiyuan3g.linkman.entity.Picture;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public class PicAdapter extends BaseAdapter {
    private List<Picture> pictures;
    private Context context;

    public PicAdapter(List<Picture> pictures, Context context) {
        this.pictures = pictures;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pictures.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.picinfo, null);
            holder.sizes = (TextView) convertView.findViewById(R.id.size);
            holder.gridImage = (ImageView) convertView.findViewById(R.id.gridImage);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        Picture picture = pictures.get(position);
        holder.sizes.setText(picture.getSize());
        holder.gridImage.setImageBitmap(picture.getThumbnail());

        return convertView;
    }

    private class Holder {
        TextView sizes;
        ImageView gridImage;
    }

}
