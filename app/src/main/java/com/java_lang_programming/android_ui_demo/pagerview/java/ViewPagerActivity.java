package com.java_lang_programming.android_ui_demo.pagerview.java;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.java_lang_programming.android_ui_demo.R;

/**
 * Fragment for Activity.
 */
public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.container, ViewPagerFragment.newInstance());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the chang
        ft.commit();
    }
}
