package com.bmtz.pulltorefresh;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private PullToRefreshLayout mPrl;
    private RecyclerView mRv;
    private List<String> list;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Boolean flag = true;
    private TextView mTv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
    }

    private void initView() {
        mTv_show = (TextView) findViewById(R.id.tv_show);
        mPrl = (PullToRefreshLayout) findViewById(R.id.prl);
        mRv = (RecyclerView) findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("我是下拉刷新" + i);
        }
        recyclerViewAdapter = new RecyclerViewAdapter(list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(manager);
        mRv.setAdapter(recyclerViewAdapter);
        mPrl.autoRefresh();
        mPrl.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            list.add("我希望平凡的生活" + i);
                        }
                        recyclerViewAdapter.notifyDataSetChanged();
                        mPrl.finishRefresh();
                    }
                }, 2000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mTv_show.setVisibility(View.GONE);
                        if(flag){
                            mTv_show.setVisibility(View.VISIBLE);
                            Toast.makeText(RecyclerViewActivity.this,"沒有更多数据了",Toast.LENGTH_SHORT).show();
                        }else {
                            for (int i = 0; i < 10; i++) {
                                list.add("世界你好" + i);
                            }
                        }
                        recyclerViewAdapter.notifyDataSetChanged();
                        mPrl.finishLoadMore();
                    }
                }, 2000);
            }
        });
    }
}
