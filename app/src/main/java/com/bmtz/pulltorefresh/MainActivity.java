package com.bmtz.pulltorefresh;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PullToRefreshLayout mPull;
    private ListView mLv;
    private List<String> datas;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mPull = (PullToRefreshLayout) findViewById(R.id.pull);
        mLv = (ListView) findViewById(R.id.list);
        datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            datas.add("我是item" + i);
        }
        final MyAdapter myAdapter = new MyAdapter(mContext, datas);
        mLv.setAdapter(myAdapter);

        mPull.autoRefresh();
        mPull.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            datas.add("PullToRefreshLayout2222" + i);
                        }
                        myAdapter.notifyDataSetChanged();
                        mPull.finishRefresh();
                    }
                }, 2000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 5; i++) {
                            datas.add("你好世界" + i);
                        }
                        myAdapter.notifyDataSetChanged();
                        mPull.finishLoadMore();
                    }
                }, 2000);
            }
        });

    }
}
