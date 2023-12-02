package com.example.fullyminded.Viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fullyminded.R;

public class CustomViewPagerAdapter extends FragmentStateAdapter {
    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return TipFragment.newInstance("Make a life of topics", "First vists can be awkward. having a list of topics to go over can help reduce anxiety.", R.drawable.list);
            case 1: return TipFragment.newInstance("Don't worry about not knowing what to say", "You can never say 'the wrong' thing. It is a safe space to explore you thoughts and feelings", R.drawable.questions);
            case 2: return TipFragment.newInstance("Dress Comfortably", "It is important that you are comfortable during your session. Don't stress about 'looking' a certain way", R.drawable.clothes);
            case 3: return TipFragment.newInstance("Prepare to be Open minded and Honest", "Your therapist/life coach is here to help you, and they can only do so when you are fully open and honest with them", R.drawable.openmind);
            case 4: return TipFragment.newInstance("Understand that it is NOT a quick fix", "This is a journey you are partaking in. Therapy is a process.", R.drawable.time);
            default: return TipFragment.newInstance("404:Error", "Not Found", R.drawable.error);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
