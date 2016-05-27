package com.rotation.support;

/**
 * This interface implementation should
 * react on user actions from UI side and on screen
 * state changes.
 */
public interface CustomPresenter {

    void onResume();

    void onStop();

    void startTask();

    void cancelTask();

    void onDestroy();

    enum TaskState {
        PENDING,
        IN_PROGRESS,
        CANCELED,
        FINISHING,
        FINISHED
    }

    enum PresenterState {
        CREATED,
        STOPPED,
        RESUMED,
        DESTROYED
    }
}
