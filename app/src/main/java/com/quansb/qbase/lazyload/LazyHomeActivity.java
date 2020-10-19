package com.quansb.qbase.lazyload;

import android.os.Bundle;

import com.quansb.qbase.R;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class LazyHomeActivity extends FragmentActivity {
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_home);
        viewPager=findViewById(R.id.vp_home);
        viewPager.setOffscreenPageLimit(1);
    }
}