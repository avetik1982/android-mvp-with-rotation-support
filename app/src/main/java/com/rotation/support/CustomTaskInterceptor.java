package com.rotation.support;

/**
 * This interface implementation should react on user actions and to execute
 * corresponding operations.
 */
public interface CustomTaskInterceptor {

    /**
     * This interface implementation should
     * provide results of operations mentioned above.
     */
    interface OnResultListener {
        void onFinished();
    }

    void doSomeTask(OnResultListener listener);
}
