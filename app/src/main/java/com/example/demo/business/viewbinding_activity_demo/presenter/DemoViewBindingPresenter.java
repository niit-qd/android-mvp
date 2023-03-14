package com.example.demo.business.viewbinding_activity_demo.presenter;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.example.demo.business.viewbinding_activity_demo.model.DemoModel;
import com.example.demo.business.viewbinding_activity_demo.view.DemoViewBindingActivity;
import com.example.demo.databinding.ActivityMvpViewbindDemoBinding;
import com.example.mvp.viewbinding.presenter.activity.AbstractViewBindingActivityPresenter;

public class DemoViewBindingPresenter extends AbstractViewBindingActivityPresenter<DemoViewBindingActivity, DemoModel> {

    private static final String TAG = DemoViewBindingPresenter.class.getSimpleName();
    private DemoModel model;
    private DemoViewBindingActivity activity;
    private ActivityMvpViewbindDemoBinding binding;

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);

        initBase();
        initData();
        initViewListeners();
    }

    private void initBase() {
        model = new DemoModel();
        setModel(model);
        activity = getView();
        binding = getView().getViewBinding();
    }

    private void initData() {
    }

    private void initViewListeners() {
        binding.btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = model.getCurrentDateTimeString();
                binding.tvDate.setText(str);
                Log.i(TAG, "onClick: str = " + str);
            }
        });
    }
}
