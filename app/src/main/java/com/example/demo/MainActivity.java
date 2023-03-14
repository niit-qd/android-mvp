package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.business.viewbinding_activity_demo.view.DemoViewBindingActivity;
import com.example.demo.business.viewbinding_fragment_demo.DemoViewBindingFragmentActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_demo_mvp_viewbinding_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), DemoViewBindingActivity.class));
            }
        });
        findViewById(R.id.btn_demo_mvp_viewbinding_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), DemoViewBindingFragmentActivity.class));
            }
        });
    }
}