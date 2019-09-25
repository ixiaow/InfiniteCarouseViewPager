package com.gigamole.sample.screens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gigamole.infinitecycleviewpager.InfiniteCycleViewPager;
import com.gigamole.sample.R;
import com.gigamole.sample.adapters.HorizontalPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InfiniteCycleViewPager viewPager = findViewById(R.id.hicvp);
        viewPager.setAdapter(new HorizontalPagerAdapter(this));

    }
}
