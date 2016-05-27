package com.rotation.support;

import android.app.Fragment;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class CustomActivityFragment extends Fragment implements CustomView {

    private CustomProgressDialog customProgressDialog;
    private CustomDialogFragment customDialogFragment;
    private CustomPresenter presenter;
    private TextView textView;
    private Button button;

    public CustomActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This is used because we use async task to do our custom task.
        setRetainInstance(true);

        customDialogFragment = new CustomDialogFragment();
        customDialogFragment.setParams(getString(R.string.custom_dialog_title), getString(R.string.custom_dialog_message));

        presenter = new CustomPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        textView = (TextView) rootView.findViewById(R.id.main_text);
        button = (Button) rootView.findViewById(R.id.main_button);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startTask();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();

        presenter.onStop();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        customProgressDialog = null;
        customDialogFragment = null;
        presenter = null;
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        customProgressDialog = new CustomProgressDialog(getActivity());
        customProgressDialog.setTitle(null);
        customProgressDialog.setMessage(getString(R.string.custom_progress_message));
        customProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                presenter.cancelTask();
            }
        });
        customProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (customProgressDialog != null) {
            customProgressDialog.hide();
            customProgressDialog.dismiss();
            customProgressDialog = null;
        }
    }

    @Override
    public void onTaskDone() {
        textView.setText(getString(R.string.text_after_action));
        customDialogFragment.show(getFragmentManager());
    }
}
