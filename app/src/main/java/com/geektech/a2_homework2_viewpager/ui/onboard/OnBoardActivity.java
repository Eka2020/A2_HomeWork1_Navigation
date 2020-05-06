package com.geektech.a2_homework2_viewpager.ui.onboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.geektech.a2_homework2_viewpager.FormActivity;
import com.geektech.a2_homework2_viewpager.MainActivity;
import com.geektech.a2_homework2_viewpager.R;
import com.google.android.material.tabs.TabLayout;

public class OnBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));
         TabLayout tabLayout = findViewById(R.id.tab_layout);
         tabLayout.setupWithViewPager(viewPager, true);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putInt("pos", position);
            BoardFragment fragment = new BoardFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    }



