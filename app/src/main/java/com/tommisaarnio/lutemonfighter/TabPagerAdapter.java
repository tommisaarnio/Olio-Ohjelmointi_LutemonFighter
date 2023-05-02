package com.tommisaarnio.lutemonfighter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tommisaarnio.lutemonfighter.fragments.FragmentDead;
import com.tommisaarnio.lutemonfighter.fragments.FragmentFightning;
import com.tommisaarnio.lutemonfighter.fragments.FragmentHome;
import com.tommisaarnio.lutemonfighter.fragments.FragmentTraining;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new FragmentHome();
            case 1:
                return new FragmentTraining();
            case 2:
                return new FragmentFightning();
            case 3:
                return new FragmentDead();
            default:
                return new FragmentHome();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
