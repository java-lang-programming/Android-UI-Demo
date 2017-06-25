package com.java_lang_programming.android_ui_demo.pagerview.java.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.java_lang_programming.android_ui_demo.R

class KtViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt_view_pager)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        // Begin the transaction
        val ft = supportFragmentManager.beginTransaction()
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.container, KtViewPagerFragment.newInstance())
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the chang
        ft.commit()
    }

}
