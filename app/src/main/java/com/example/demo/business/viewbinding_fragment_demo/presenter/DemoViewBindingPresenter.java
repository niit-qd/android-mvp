package com.example.demo.business.viewbinding_fragment_demo.presenter;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.example.demo.business.viewbinding_fragment_demo.model.DemoModel;
import com.example.demo.business.viewbinding_fragment_demo.view.DemoViewBindingFragment;
import com.example.demo.databinding.FragmentMvpViewbindDemoBinding;
import com.example.mvp.viewbinding.presenter.fragment.AbstractViewBindingFragmentPresenter;

public class DemoViewBindingPresenter extends AbstractViewBindingFragmentPresenter<DemoViewBindingFragment, DemoModel> {

    private static final String TAG = DemoViewBindingPresenter.class.getSimpleName();
    private DemoModel model;
    private DemoViewBindingFragment fragment;
    private FragmentMvpViewbindDemoBinding binding;

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        initBase();
        initData();
        initViewListeners();
    }

    private void initBase() {
        model = new DemoModel();
        setModel(model);
        fragment = getView();
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
