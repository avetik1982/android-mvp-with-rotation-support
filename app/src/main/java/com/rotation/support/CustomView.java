package com.rotation.support;

/**
 * This interface implementation should
 * react on tasks results and change UI behaviour.
 */
public interface CustomView {

    void showProgress();

    void hideProgress();

    void onTaskDone();
}
