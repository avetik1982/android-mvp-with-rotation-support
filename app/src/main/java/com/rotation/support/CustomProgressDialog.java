package com.rotation.support;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Custom progress dialog. Here we can add our implementation.
 */
public class CustomProgressDialog extends ProgressDialog {

    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

}
