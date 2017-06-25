package com.java_lang_programming.android_ui_demo.pagerview.java.kotlin

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.java_lang_programming.android_ui_demo.R
import com.rd.PageIndicatorView

/**
 * Fragment for ViewPager.
 */
class KtViewPagerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_kt_view_pager, container, false)
        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        val pagerAdapter = CustomPagerAdapter(resources.configuration.orientation)
        viewPager.adapter = pagerAdapter
        val pageIndicatorView = view.findViewById<PageIndicatorView>(R.id.pageIndicatorView)
        pageIndicatorView.setViewPager(viewPager)
        return view
    }

    private class CustomPagerAdapter(private val orientation: Int) : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(container.context).inflate(R.layout.view_page, container, false)

            val title = view.findViewById<TextView>(R.id.title)
            title.text = " page title : $position"

            val summary = view.findViewById<TextView>(R.id.summary)
            summary.text = " page summary : This is page $position"

            val orientation = view.findViewById<TextView>(R.id.orientation)
            orientation.text = if (Configuration.ORIENTATION_PORTRAIT == this.orientation) "PORTRAIT" else "LANDSCAPE"

            container.addView(view)

            return view
        }

        override fun getCount(): Int {
            return when {
                this.orientation == Configuration.ORIENTATION_PORTRAIT -> 3
                this.orientation == Configuration.ORIENTATION_LANDSCAPE -> 5
                else -> 0
            }
        }

        // ページを構成するViewの判定
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            // Object 内に View が存在するか判定する
            return view == `object`
        }

        // ページの破棄を行う。
        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun getItemPosition(`object`: Any?): Int {
            return PagerAdapter.POSITION_UNCHANGED
        }
    }

    companion object {
        fun newInstance(): KtViewPagerFragment {
            return KtViewPagerFragment()
        }
    }
}
