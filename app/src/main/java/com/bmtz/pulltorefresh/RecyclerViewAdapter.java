package com.bmtz.pulltorefresh;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<String> data;

    public RecyclerViewAdapter(List<String> list) {
        this.data = list;
    }

    @Override //创建Holder
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclre_layout, null);
        return new MyViewHolder(v);
    }

    @Override //绑定Holder
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.mTv_rv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTv_rv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTv_rv = itemView.findViewById(R.id.tv_rv);
        }
    }
}
