package com.zhiyuan3g.linkman.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyuan3g.linkman.R;
import com.zhiyuan3g.linkman.entity.Audios;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public class AudioAdapter extends BaseAdapter {
    Context context;
    List<Audios> audioses;

    public AudioAdapter(Context context, List<Audios> audioses) {
        this.context = context;
        this.audioses = audioses;
    }

    @Override
    public int getCount() {
        return audioses.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.audioinfo, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.sizes = (TextView) convertView.findViewById(R.id.size);
            holder.gridImage = (ImageView) convertView.findViewById(R.id.gridImage);
            convertView.setTag(holder);
        } else {
            holder= (Holder) convertView.getTag();
        }
        Audios audios = audioses.get(position);
        holder.sizes.setText(audios.getSize());
        holder.gridImage.setImageBitmap(audios.getThumbnail());
        holder.name.setText(audios.getName());
        return convertView;
    }

    private class Holder {
        TextView name, sizes;
        ImageView gridImage;
    }
}
