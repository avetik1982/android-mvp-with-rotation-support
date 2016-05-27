package com.rotation.support;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Custom dialog fragment which has title and shows some message.
 */
public class CustomDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    private static final String DIALOG_TITLE = "title";
    private static final String DIALOG_MESSAGE = "message";

    public CustomDialogFragment() {

    }

    /**
     * Sets specified title and message of dialog as a arguments.
     * @param title
     * @param message
     */
    public void setParams(String title, String message) {
        Bundle params = new Bundle();

        params.putString(DIALOG_TITLE, title);
        params.putString(DIALOG_MESSAGE, message);

        setArguments(params);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString(DIALOG_TITLE);
        String message = getArguments().getString(DIALOG_MESSAGE);

        return new AlertDialog.Builder(this.getActivity())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
    }

    /**
     * Shows this dialog fragment.
     * @param fragmentManager The instance of fragment manager.
     */
    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, CustomDialogFragment.class.getName());
    }
}
