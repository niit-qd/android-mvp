package com.example.mvp.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleObserver;

import com.example.mvp.presenter.fragment.AbstractFragmentPresenter;
import com.example.mvp.view.IView;
import com.example.mvp.presenter.fragment.IFragmentPresenter;

public abstract class AbstractFragment<P extends AbstractFragmentPresenter> extends Fragment implements IView {

    private static final String TAG = AbstractFragment.class.getSimpleName();

    /**
     * type for when to add and remove the {@link LifecycleObserver}.
     */
    public static enum LifecycleOwnerType {
        /**
         * {@link AbstractFragment} will add and remove {@link LifecycleObserver} follow the lifecycle of {@link Fragment}.
         * <br/>
         * The proper callback method in {@link AbstractFragmentPresenter} to initiate is {@link IFragmentPresenter#onCreateView(LifecycleOwner)},
         * the proper callback method in {@link AbstractFragmentPresenter} to release is {@link IFragmentPresenter#onDestroyView(LifecycleOwner)}.
         */
        FRAGMENT,
        /**
         * {@link AbstractFragment} will add and remove {@link LifecycleObserver} follow the lifecycle of {@link Fragment#getView()}.
         * <br/>
         * The proper callback method in {@link AbstractFragmentPresenter} to initiate is {@link IFragmentPresenter#onCreate(LifecycleOwner)},
         * the proper callback method in {@link AbstractFragmentPresenter} to release is {@link IFragmentPresenter#onDestroy(LifecycleOwner)} .
         * <br/>
         * This is the default type.
         */
        VIEW,
    }

    private boolean canChangeLifecycleOwnerType = true;
    public static final LifecycleOwnerType LIFE_CYCLE_OWNER_TYPE_DEFAULT = LifecycleOwnerType.VIEW;
    private LifecycleOwnerType lifecycleOwnerType = LIFE_CYCLE_OWNER_TYPE_DEFAULT;

    private P presenter;

    {
        init();
    }

    public LifecycleOwnerType getLifecycleOwnerType() {
        return lifecycleOwnerType;
    }

    /**
     * This method should be called before any lifecycle of the {@link Fragment}.
     *
     * @param lifecycleOwnerType if null, will use {@link LifecycleOwnerType#VIEW}
     */
    public void setLifecycleOwnerType(@Nullable LifecycleOwnerType lifecycleOwnerType) {
        if (!canChangeLifecycleOwnerType) {
            Log.w(TAG, "setLifecycleOwnerType: canChangeLifecycleOwnerType is false,"
                    + " please call this method before any lifecycle callback of Fragment");
            return;
        }
        if (null == lifecycleOwnerType) {
            lifecycleOwnerType = LIFE_CYCLE_OWNER_TYPE_DEFAULT;
            Log.i(TAG, "setLifecycleOwnerType: lifecycleOwnerType is null, so set it as default value: "
                    + LIFE_CYCLE_OWNER_TYPE_DEFAULT);
        }
        this.lifecycleOwnerType = lifecycleOwnerType;
    }

    public P getPresenter() {
        return presenter;
    }

    public void init() {
        if (null == presenter) {
            presenter = newInstancePresenter();
            presenter.setView(this);
        }
    }

    /**
     * The callback to create the {@link AbstractFragmentPresenter} of this {@link AbstractFragment}.
     *
     * @return
     */
    public abstract P newInstancePresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        canChangeLifecycleOwnerType = false;
        super.onCreate(savedInstanceState);
        if (lifecycleOwnerType == LifecycleOwnerType.FRAGMENT) {
            getLifecycle().addObserver(presenter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (lifecycleOwnerType == LifecycleOwnerType.FRAGMENT) {
            getLifecycle().removeObserver(presenter);
        }
        canChangeLifecycleOwnerType = true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // attention: The first method where it is safe to access the view lifecycle is onCreateView
        // under the condition that you must return a non-null view (an IllegalStateException will
        // be thrown if you access the view lifecycle but don't return a non-null view).
        if (lifecycleOwnerType == LifecycleOwnerType.VIEW) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            if (null != viewLifecycleOwner) {
                viewLifecycleOwner.getLifecycle().addObserver(presenter);
            }
        }
        View rootView = createRootView(inflater, container, savedInstanceState);
        if (null != presenter) {
            presenter.onCreateView(this);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        if (null != presenter) {
            presenter.onDestroyView(this);
        }
        super.onDestroyView();
        // attention: although in `Fragment` the `mViewLifecycleOwner` hasn't been reset to null,
        // but in `FragmentManager#destroyFragmentView`, it call `fragment.performDestroyView()`,
        // then call `onDestroyView()`, then call `fragment.mViewLifecycleOwner = null` in `FragmentManager`.
        // so remove observer here.
        if (lifecycleOwnerType == LifecycleOwnerType.VIEW) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            if (null != viewLifecycleOwner) {
                viewLifecycleOwner.getLifecycle().removeObserver(presenter);
            }
        }
    }

    /**
     * the callback to create the root view for {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View createRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
