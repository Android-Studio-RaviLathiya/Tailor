package com.example.mytailor.SettingActivity.MyMap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mytailor.SettingActivity.NewbusinessStart.LoginActivity;
import com.example.mytailor.SettingActivity.NewbusinessStart.SingupActivity;
import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputLayout;

public class MyMapActivity extends AppCompatActivity {

    TextInputLayout bfname, bphone, bsname;
    ImageView back;
    Button go;
    Button bmale, bfemale;
    String gander;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_map);


        bfname = findViewById(R.id.bfname);
        bphone = findViewById(R.id.bphone);
        bsname = findViewById(R.id.bsname);
        go = findViewById(R.id.go);


//        male an female
        bmale = findViewById(R.id.bmale);
        bfemale = findViewById(R.id.bfemale);

        bmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyMapActivity.this, MaleMapActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(bmale, "boy");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MyMapActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }

            }
        });
        bfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyMapActivity.this, FemaleMapActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(bfemale, "girl");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MyMapActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

///status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }


//        keyboard hid
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


    }
}
