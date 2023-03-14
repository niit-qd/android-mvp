package com.example.mvp.presenter.activity;

import com.example.mvp.model.IModel;
import com.example.mvp.presenter.IPresenter;
import com.example.mvp.view.activity.AbstractActivity;

public abstract class AbstractActivityPresenter<AA extends AbstractActivity, M extends IModel> implements IPresenter<AA, M> {

    private AA view;
    private M model;

    @Override
    public void setView(AA view) {
        this.view = view;
    }

    @Override
    public AA getView() {
        return this.view;
    }

    @Override
    public void setModel(M model) {
        this.model = model;
    }

    @Override
    public M getModel() {
        return this.model;
    }

}
