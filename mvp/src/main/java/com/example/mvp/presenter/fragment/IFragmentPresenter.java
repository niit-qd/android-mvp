package com.example.mvp.presenter.fragment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.example.mvp.model.IModel;
import com.example.mvp.presenter.IPresenter;
import com.example.mvp.view.IView;

public interface IFragmentPresenter<V extends IView, M extends IModel> extends IPresenter<V, M> {

    void onCreateView(@NonNull LifecycleOwner owner);

    void onDestroyView(@NonNull LifecycleOwner owner);
}
