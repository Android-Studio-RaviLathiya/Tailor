package com.example.mytailor.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytailor.AddActivity.AddMainActivity;
import com.example.mytailor.FragmentActivity.BoyFragmentActivity;
import com.example.mytailor.FragmentActivity.DramaFragmentActivity;
import com.example.mytailor.FragmentActivity.GirlFragmentActivity;
import com.example.mytailor.FragmentActivity.SchoolFragmentActivity;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.SettingActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Animation bottomanim;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ActionBar actionBar;
    ImageView add;


    //    icone tabview
//    int[] tabIcons = {
//            R.drawable.boy,
//            R.drawable.girl,
//            R.drawable.school,
//            R.drawable.boy
//    };
//
//    private void setupTabIcons() {
//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
//        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
//    }
//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        add button visible with buss acount
        add = findViewById(R.id.add);

        if (MyPrefrence.getLogin()) {
            add.setVisibility(View.VISIBLE);
        } else {
            add.setVisibility(View.GONE);
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddMainActivity.class));
            }
        });


//Animation
        text = findViewById(R.id.text);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        text.setAnimation(bottomanim);

//status bar
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.appcolor));
        }

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
//        setupTabIcons();


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BoyFragmentActivity(), "Boy");
        adapter.addFragment(new GirlFragmentActivity(), "Girl");
        adapter.addFragment(new SchoolFragmentActivity(), "School");
        adapter.addFragment(new DramaFragmentActivity(), "Rant and drama");
        viewPager.setAdapter(adapter);
    }

    public void setting(View view) {
        startActivity(new Intent(MainActivity.this, SettingActivity.class));
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
