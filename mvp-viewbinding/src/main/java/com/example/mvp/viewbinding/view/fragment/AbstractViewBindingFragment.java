package com.example.mvp.viewbinding.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.example.mvp.view.fragment.AbstractFragment;
import com.example.mvp.viewbinding.presenter.fragment.AbstractViewBindingFragmentPresenter;

public abstract class AbstractViewBindingFragment<AVBFP extends AbstractViewBindingFragmentPresenter, VB extends ViewBinding> extends AbstractFragment<AVBFP> {

    private VB binding;

    public VB getViewBinding() {
        return binding;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }

    @Override
    public View createRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = newInstanceViewBinding(inflater, container, savedInstanceState);
        if (null == binding) {
            return super.createRootView(inflater, container, savedInstanceState);
        } else {
            return binding.getRoot();
        }
    }

    /**
     * The callback to create the {@link ViewBinding} of this {@link AbstractViewBindingFragment}.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    protected abstract VB newInstanceViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}
