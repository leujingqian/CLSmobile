package com.example.myapplication1.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList=new ArrayList<>();
    private List<String>titleList=new ArrayList<>();

    public SectionPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       return titleList.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    public void addFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
