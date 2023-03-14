package com.example.mvp.view;

import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;

/**
 * It is designed as a renderer.
 * It can be any class or sub-class of {@link ComponentActivity}, {@link Fragment}
 */
public interface IView extends LifecycleObserver {
}
