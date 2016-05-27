package com.rotation.support;

/**
 * Implements {@link CustomPresenter} interface to react on
 * user actions from UI side and UI state changes.
 */
public class CustomPresenterImpl implements CustomPresenter, CustomTaskInterceptor.OnResultListener {

    private TaskState taskState;
    private PresenterState presenterState;

    private CustomView customView;
    private CustomTaskInterceptor customTaskInterceptor;

    public CustomPresenterImpl(CustomView customView) {
        this.customView = customView;
        customTaskInterceptor = new CustomTaskInterceptorImpl();
        taskState = TaskState.PENDING;
        presenterState = PresenterState.CREATED;
    }

    @Override
    public void onFinished() {
        if (taskState == TaskState.FINISHED
                || taskState == TaskState.CANCELED) {
            return;
        }

        taskState = TaskState.FINISHING;

        if (presenterState == PresenterState.RESUMED) {
            onTaskDone();
        }
    }

    @Override
    public void onResume() {
        presenterState = PresenterState.RESUMED;

        if (taskState == TaskState.IN_PROGRESS) {
            customView.showProgress();
        } else if (taskState == TaskState.FINISHING) {
            onTaskDone();
        }
    }

    private void onTaskDone() {
        taskState = TaskState.FINISHED;
        customView.onTaskDone();
        customView.hideProgress();
    }

    @Override
    public void startTask() {
        taskState = TaskState.IN_PROGRESS;
        customView.showProgress();
        customTaskInterceptor.doSomeTask(this);
    }

    @Override
    public void cancelTask() {
        taskState = TaskState.CANCELED;
    }

    @Override
    public void onStop() {
        presenterState = PresenterState.STOPPED;

        if (taskState == TaskState.IN_PROGRESS) {
            customView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        presenterState = PresenterState.DESTROYED;

        if (taskState == TaskState.IN_PROGRESS) {
            customView.hideProgress();
        }

        customView = null;
    }
}