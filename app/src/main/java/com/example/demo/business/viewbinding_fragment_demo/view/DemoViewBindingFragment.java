package com.example.demo.business.viewbinding_fragment_demo.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demo.business.viewbinding_fragment_demo.presenter.DemoViewBindingPresenter;
import com.example.demo.databinding.FragmentMvpViewbindDemoBinding;
import com.example.mvp.viewbinding.view.fragment.AbstractViewBindingFragment;

public class DemoViewBindingFragment extends AbstractViewBindingFragment<DemoViewBindingPresenter, FragmentMvpViewbindDemoBinding> {

    public DemoViewBindingFragment() {
        // This is the default and suggested type
        // setLifecycleOwnerType(LifecycleOwnerType.VIEW);
    }

    @Override
    protected FragmentMvpViewbindDemoBinding newInstanceViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return FragmentMvpViewbindDemoBinding.inflate(inflater, container, false);
    }

    @Override
    public DemoViewBindingPresenter newInstancePresenter() {
        return new DemoViewBindingPresenter();
    }

}