package com.zhiyuan3g.linkman.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhiyuan3g.linkman.R;
import com.zhiyuan3g.linkman.entity.LinkMans;

import java.util.List;

/**
 * Created by Administrator on 2016/7/3.
 */
public class LinkManAdapter extends BaseAdapter {
    private List<LinkMans> linkManses;
    private Context context;

    public LinkManAdapter(List<LinkMans> linkManses, Context context) {
        this.linkManses = linkManses;
        this.context = context;
    }

    @Override
    public int getCount() {
        return linkManses.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.info, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.phone = (TextView) convertView.findViewById(R.id.phone);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        LinkMans linkMans = linkManses.get(position);
        holder.phone.setText(linkMans.getPhone());
        holder.name.setText(linkMans.getName());
        return convertView;
    }

    private class Holder {
        TextView name, phone;
    }
}
