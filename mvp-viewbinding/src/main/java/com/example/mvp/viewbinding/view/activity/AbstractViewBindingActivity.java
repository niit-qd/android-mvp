package com.example.mvp.viewbinding.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.example.mvp.presenter.activity.AbstractActivityPresenter;
import com.example.mvp.view.activity.AbstractActivity;
import com.example.mvp.viewbinding.presenter.activity.AbstractViewBindingActivityPresenter;

public abstract class AbstractViewBindingActivity<AVBFP extends AbstractViewBindingActivityPresenter, VB extends ViewBinding> extends AbstractActivity<AVBFP> {

    private VB binding;

    public VB getViewBinding() {
        return binding;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = newInstanceViewBinding();
        setContentView(binding.getRoot());
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }

    /**
     * The callback to create the {@link ViewBinding} of this {@link AbstractViewBindingActivity}.
     *
     * @return
     */
    protected abstract VB newInstanceViewBinding();
}
