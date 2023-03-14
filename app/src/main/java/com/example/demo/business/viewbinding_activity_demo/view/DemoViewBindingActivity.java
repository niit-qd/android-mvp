package com.example.demo.business.viewbinding_activity_demo.view;

import com.example.demo.business.viewbinding_activity_demo.presenter.DemoViewBindingPresenter;
import com.example.demo.databinding.ActivityMvpViewbindDemoBinding;
import com.example.mvp.viewbinding.view.activity.AbstractViewBindingActivity;

public class DemoViewBindingActivity extends AbstractViewBindingActivity<DemoViewBindingPresenter, ActivityMvpViewbindDemoBinding> {

    @Override
    public DemoViewBindingPresenter newInstancePresenter() {
        return new DemoViewBindingPresenter();
    }

    @Override
    protected ActivityMvpViewbindDemoBinding newInstanceViewBinding() {
        return ActivityMvpViewbindDemoBinding.inflate(getLayoutInflater());
    }
}