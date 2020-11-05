package com.example.mytailor.AddActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.SettingActivity;

public class AddMainActivity extends AppCompatActivity {

    RelativeLayout boymap, girlmap, rantmap;
    TextView bm, gm, rm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_main);


        boymap = findViewById(R.id.boymap);
        girlmap = findViewById(R.id.girlmap);
        rantmap = findViewById(R.id.rantmap);

        bm = findViewById(R.id.bm);
        gm = findViewById(R.id.gm);
        rm = findViewById(R.id.rm);

        boymap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMainActivity.this, AddBoyMap.class);


                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(bm, "bm");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(AddMainActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }

            }
        });

        girlmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMainActivity.this, AddGirlMap.class);


                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(gm, "gm");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(AddMainActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }

            }
        });

        rantmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMainActivity.this, AddDramaMap.class);


                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(rm, "rm");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(AddMainActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }

            }
        });


//        status bar colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.appcolor));
        }

        //back button
        ImageView back;
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}
