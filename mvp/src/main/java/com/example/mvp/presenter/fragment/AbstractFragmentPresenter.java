package com.example.mvp.presenter.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.example.mvp.model.IModel;
import com.example.mvp.view.fragment.AbstractFragment;

public abstract class AbstractFragmentPresenter<AF extends AbstractFragment, M extends IModel> implements IFragmentPresenter<AF, M> {

    private AF view;
    private M model;

    @Override
    public void setView(AF view) {
        this.view = view;
    }

    @Override
    public AF getView() {
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

    @Override
    public void onCreateView(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroyView(@NonNull LifecycleOwner owner) {

    }
}
