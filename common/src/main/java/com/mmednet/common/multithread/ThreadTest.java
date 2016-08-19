package com.mmednet.common.multithread;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mmednet.common.R;

public class ThreadTest extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ThreadTest.class.getSimpleName();
    private Button mBtnHandlerthread;
    private Handler mThreadHandler;

    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_test);
        mBtnHandlerthread = (Button) findViewById(R.id.btn_thread);
        mBtnHandlerthread.setOnClickListener(this);

        HandlerThread ht = new HandlerThread("refresh_ui");
        ht.start();
        mThreadHandler = new Handler(ht.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                Log.d(TAG, "handleMessage:" + Thread.currentThread().getName());
            }
        };


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_thread:
                mThreadHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "POST:" + Thread.currentThread().getName());

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            Log.e(TAG, Log.getStackTraceString(e));
                        }

                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mBtnHandlerthread.setText("更新UI");
                            }
                        });
                    }
                });
                break;
        }

    }
}
