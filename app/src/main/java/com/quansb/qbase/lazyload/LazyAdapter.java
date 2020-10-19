package com.quansb.qbase.lazyload;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * @author quanshibao
 * @description
 * @date 2020/10/19
 */
public class LazyAdapter extends FragmentPagerAdapter {

    public LazyAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public LazyAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
