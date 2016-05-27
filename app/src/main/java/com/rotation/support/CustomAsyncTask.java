package com.rotation.support;

import android.os.AsyncTask;

/**
 * Custom async task to demonstrate some background task which takes some time.
 */
public class CustomAsyncTask extends AsyncTask<Void, Void, Void> {

    private CustomTaskInterceptor.OnResultListener listener;

    public CustomAsyncTask(CustomTaskInterceptor.OnResultListener onResultListener) {
        this.listener = onResultListener;
    }

    @Override
    protected Void doInBackground(Void... params) {

        //Does not matter you do here. We wait for some time.
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        listener.onFinished();
    }
}
