package com.example.mvp.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.presenter.activity.AbstractActivityPresenter;
import com.example.mvp.presenter.fragment.AbstractFragmentPresenter;
import com.example.mvp.view.IView;
import com.example.mvp.view.fragment.AbstractFragment;

public abstract class AbstractActivity<P extends AbstractActivityPresenter> extends AppCompatActivity implements IView {

    private P presenter;


    {
        init();
    }


    public void init() {
        if (null == presenter) {
            presenter = newInstancePresenter();
            presenter.setView(this);
        }
    }

    /**
     * The callback to create the {@link AbstractActivityPresenter} of this {@link AbstractActivity}.
     *
     * @return
     */
    public abstract P newInstancePresenter();

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(presenter);
    }

    @Override
    protected void onDestroy() {
        getLifecycle().removeObserver(presenter);
        presenter = null;
        super.onDestroy();
    }
}
