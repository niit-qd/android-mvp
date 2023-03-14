package com.example.mvp.viewbinding.presenter.fragment;

import com.example.mvp.model.IModel;
import com.example.mvp.presenter.fragment.AbstractFragmentPresenter;
import com.example.mvp.viewbinding.view.fragment.AbstractViewBindingFragment;

public abstract class AbstractViewBindingFragmentPresenter<AVBF extends AbstractViewBindingFragment, M extends IModel> extends AbstractFragmentPresenter<AVBF, M> {
}
