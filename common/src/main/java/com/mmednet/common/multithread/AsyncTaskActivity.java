package com.mmednet.common.multithread;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mmednet.common.R;

public class AsyncTaskActivity extends AppCompatActivity {

    private static final String TAG = AsyncTaskActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        new MyAsyncTask().execute();
    }

    public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            Log.d(TAG, "onPreExecute");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.d(TAG, "doInBackground");
            publishProgress();//在pushlistProgress方法中调用onProcessUpdate()方法
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d(TAG, "onPostExecute");
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.d(TAG, "onProgressUpdate");
            super.onProgressUpdate(values);
        }
    }
}
