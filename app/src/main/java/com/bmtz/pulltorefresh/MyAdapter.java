package com.bmtz.pulltorefresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

public class MyAdapter extends BaseAdapter {
    private List<String> str;
    private Context mContext2;

    public MyAdapter(Context mContext, List<String> datas) {
        this.str = datas;
        this.mContext2 = mContext;
    }

    @Override
    public int getCount() {
        return str.size();
    }

    @Override
    public Object getItem(int i) {
        return str.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext2).inflate(R.layout.listview_layout, null);
            holder = new ViewHolder();
            holder.mTv = view.findViewById(R.id.tv_list);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mTv.setText(str.get(i));
        return view;
    }

    class ViewHolder {
        private TextView mTv;
    }
}
