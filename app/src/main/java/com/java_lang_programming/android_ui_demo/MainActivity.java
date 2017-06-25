package com.java_lang_programming.android_ui_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.java_lang_programming.android_ui_demo.pagerview.java.ViewPagerActivity;
import com.java_lang_programming.android_ui_demo.pagerview.java.kotlin.KtViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnJavaViewPager = (Button) findViewById(R.id.btn_java_view_pager);
        btnJavaViewPager.setOnClickListener(view -> moveViewPagerActivity());

        Button btnKtViewViewPager = (Button) findViewById(R.id.btn_kt_view_pager);
        btnKtViewViewPager.setOnClickListener(view -> moveKtViewPagerActivity());
    }

    private void moveViewPagerActivity() {
        Intent intent = new Intent(this, ViewPagerActivity.class);
        startActivity(intent);
    }

    private void moveKtViewPagerActivity() {
        Intent intent = new Intent(this, KtViewPagerActivity.class);
        startActivity(intent);
    }
}
