package com.example.mytailor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.mytailor.Activity.MainActivity;
import com.example.mytailor.OtpLoging.LoginWithMobileNoActivity;
import com.github.appintro.AppIntroBaseFragment;
import com.github.appintro.AppIntroFragment;

public class AppIntro extends com.github.appintro.AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_app_intro);

        addSlide(AppIntroFragment.newInstance("f v", " fvvcw", R.drawable.acc, ContextCompat.getColor(getApplicationContext(), R.color.white)));
        addSlide(AppIntroFragment.newInstance("f v", " fvvcw", R.drawable.ic_notifications_black_24dp, ContextCompat.getColor(getApplicationContext(), R.color.appcolor)));
        addSlide(AppIntroFragment.newInstance("f v", " fvvcw", R.drawable.boy, ContextCompat.getColor(getApplicationContext(), R.color.black)));
    }


    @Override
    protected void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        startActivity(new Intent(getApplicationContext(), LoginWithMobileNoActivity.class));
        finish();
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        startActivity(new Intent(getApplicationContext(), LoginWithMobileNoActivity.class));
        finish();
    }


}
