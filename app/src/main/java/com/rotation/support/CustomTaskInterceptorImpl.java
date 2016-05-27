package com.rotation.support;

/**
 * Implements {@link CustomTaskInterceptor} interface to provide
 * functionality for execution of several tasks.
 */
public class CustomTaskInterceptorImpl implements CustomTaskInterceptor {

    @Override
    public void doSomeTask(OnResultListener listener) {
        CustomAsyncTask customAsyncTask = new CustomAsyncTask(listener);
        customAsyncTask.execute();
    }
}
