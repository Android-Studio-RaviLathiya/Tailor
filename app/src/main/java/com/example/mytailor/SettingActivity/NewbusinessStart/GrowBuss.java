package com.example.mytailor.SettingActivity.NewbusinessStart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;


public class GrowBuss extends AppCompatActivity {

    TextView text;
    Animation bottomanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_buss);

        if (MyPrefrence.getLogin()) {
            Intent intent = new Intent(GrowBuss.this, BusinessProfile.class);
            startActivity(intent);
            finish();
        }

//Animation
        text = findViewById(R.id.text);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        text.setAnimation(bottomanim);

        ///status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.white));
        }


    }

    public void login(View view) {
        Intent intent = new Intent(GrowBuss.this, LoginActivity.class);

        Pair[] pair = new Pair[1];
        pair[0] = new Pair<View, String>(findViewById(R.id.login), "login");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(GrowBuss.this, pair);
            startActivity(intent, activityOptions.toBundle());
        }
    }
}