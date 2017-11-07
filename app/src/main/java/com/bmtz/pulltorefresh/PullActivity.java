package com.bmtz.pulltorefresh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PullActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBt1, mBt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
        initView();
    }

    private void initView() {
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt2 = (Button) findViewById(R.id.bt2);
        mBt1.setOnClickListener(this);
        mBt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                startActivity(new Intent(PullActivity.this, MainActivity.class));
                break;
            case R.id.bt2:
                startActivity(new Intent(PullActivity.this,RecyclerViewActivity.class));
                break;
        }
    }
}
