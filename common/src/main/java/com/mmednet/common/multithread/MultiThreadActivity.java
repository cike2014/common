package com.mmednet.common.multithread;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mmednet.common.R;

public class MultiThreadActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_thread);
        mBtnAsyncTask = (Button) findViewById(R.id.button_asynctask);
        mBtnAsyncTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_asynctask:

                startActivity(new Intent(MultiThreadActivity.this,AsyncTaskActivity.class));

                break;
        }
    }
}
