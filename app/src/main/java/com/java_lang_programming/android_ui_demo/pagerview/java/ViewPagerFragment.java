package com.java_lang_programming.android_ui_demo.pagerview.java;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.java_lang_programming.android_ui_demo.R;
import com.rd.PageIndicatorView;

/**
 * Fragment for ViewPager.
 */
public class ViewPagerFragment extends Fragment {

    public static final String TAG = "ViewPagerFragment";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ViewPagerFragment.
     */
    public static ViewPagerFragment newInstance() {
        return new ViewPagerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(getResources().getConfiguration().orientation);
        viewPager.setAdapter(pagerAdapter);
        PageIndicatorView pageIndicatorView = view.findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(viewPager);
        return view;
    }

    /**
     * https://techbooster.org/android/ui/9079/
     */
    private static class CustomPagerAdapter extends PagerAdapter {
        private int orientation;

        private CustomPagerAdapter(int orientation) {
            this.orientation = orientation;
        }

        public Object instantiateItem(ViewGroup container, int position) {
            final View view = LayoutInflater.from(container.getContext()).inflate(R.layout.view_page, container, false);

            TextView title = view.findViewById(R.id.title);
            title.setText(" page title : " + (position + 1));

            TextView summary = view.findViewById(R.id.summary);
            summary.setText(" page summary : This is page  " + (position + 1));

            TextView orientation = view.findViewById(R.id.orientation);
            orientation.setText(Configuration.ORIENTATION_PORTRAIT == this.orientation ? "PORTRAIT" : "LANDSCAPE");

            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            int pageCount = 0;
            if (this.orientation == Configuration.ORIENTATION_PORTRAIT) {
                pageCount = 3;
            } else if (this.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                pageCount = 5;
            }
            return pageCount;
        }

        // ページを構成するViewの判定
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        // ページの破棄を行う
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_UNCHANGED;
        }
    }
}
