package com.blackcj.designsupportexample.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.blackcj.designsupportexample.PageFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chris.black on 6/11/15.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {
    private Map<Integer, PageFragment> mPageReferenceMap = new HashMap<>();

    private static final String[] TITLES = new String[] {
            "Page 1",
            "Page 2",
            "Page 3",
            "Page 4",
            "Page 5"
    };

    public static final int NUM_TITLES = TITLES.length;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_TITLES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        PageFragment myFragment = PageFragment.create(position + 1);
        mPageReferenceMap.put(position, myFragment);
        return myFragment;
    }

    public void destroy() {
        mPageReferenceMap.clear();
    }

    public PageFragment getFragment(int key) {
        //Log.d(TAG, "GET: " + key);
        return mPageReferenceMap.get(key);
    }
}
