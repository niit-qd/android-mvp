package com.example.mvp.viewbinding.presenter.activity;

import com.example.mvp.model.IModel;
import com.example.mvp.presenter.activity.AbstractActivityPresenter;
import com.example.mvp.viewbinding.view.activity.AbstractViewBindingActivity;

public abstract class AbstractViewBindingActivityPresenter<AVBA extends AbstractViewBindingActivity, M extends IModel> extends AbstractActivityPresenter<AVBA, M> {
}
