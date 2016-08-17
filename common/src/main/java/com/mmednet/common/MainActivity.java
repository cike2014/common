package com.mmednet.common;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mmednet.common.multithread.MultiThreadActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonThread = (Button) findViewById(R.id.button_thread);
        mButtonThread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_thread:
                startActivity(new Intent(MainActivity.this, MultiThreadActivity.class));
                break;
        }
    }
}
