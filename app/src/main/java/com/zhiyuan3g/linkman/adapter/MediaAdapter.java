package com.zhiyuan3g.linkman.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhiyuan3g.linkman.R;
import com.zhiyuan3g.linkman.entity.MediaEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public class MediaAdapter extends BaseAdapter {

    List<MediaEntity> entities;
    Context context;

    public MediaAdapter(List<MediaEntity> entities, Context context) {
        this.entities = entities;
        this.context = context;
    }

    @Override
    public int getCount() {
        return entities.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.head, null);
            holder.Mname = (TextView) convertView.findViewById(R.id.Mname);
            holder.Msinger = (TextView) convertView.findViewById(R.id.Msinger);
            holder.Msize = (TextView) convertView.findViewById(R.id.Msize);
            holder.Mtimer = (TextView) convertView.findViewById(R.id.Mtimer);
//            holder.Mpic = (ImageView) convertView.findViewById(R.id.Mpic);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        MediaEntity entity = entities.get(position);
        holder.Mname.setText(entity.getMName());
        holder.Msinger.setText(entity.getMSinger());
        holder.Msize.setText(entity.getMSize());
        holder.Mtimer.setText(entity.getMtimer());
//        holder.Mpic.setImageResource(R.drawable.ly);
        return convertView;
    }

    private class Holder {
        TextView Mname, Msinger, Msize, Mtimer;
//        ImageView Mpic;
    }
}
