package com.example.mvp.presenter;

import androidx.lifecycle.DefaultLifecycleObserver;

import com.example.mvp.model.IModel;
import com.example.mvp.view.IView;

public interface IPresenter<V extends IView, M extends IModel> extends DefaultLifecycleObserver {
    void setView(V view);

    V getView();

    void setModel(M model);

    M getModel();

}
