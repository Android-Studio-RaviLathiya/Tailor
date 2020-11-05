package com.example.mytailor.SettingActivity;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.SettingActivity.NewbusinessStart.GrowBuss;
import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.MyMap.MyMapActivity;

public class SettingActivity extends AppCompatActivity {

    RelativeLayout business, account, mymap, notification, vesone, share, privetpolice;
    TextView up, username, mymapa, nbs, vs, pp, pn, bp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        business = findViewById(R.id.business);
        account = findViewById(R.id.account);
        mymap = findViewById(R.id.mymap);
        notification = findViewById(R.id.notification);
        vesone = findViewById(R.id.vesone);
        username = findViewById(R.id.username);
        privetpolice = findViewById(R.id.privetpolice);

//        animasion
        up = findViewById(R.id.up);
        mymapa = findViewById(R.id.mymapa);
        nbs = findViewById(R.id.nbs);
        vs = findViewById(R.id.vs);
        pp = findViewById(R.id.pp);
        pn = findViewById(R.id.pn);

        username.setText(MyPrefrence.getuname());

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, GrowBuss.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(nbs, "nbs");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SettingActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }

            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(SettingActivity.this, SAccountActivity.class));


                Intent intent = new Intent(SettingActivity.this, SAccountActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(username, "name");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SettingActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        });

        mymap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(SettingActivity.this, MyMapActivity.class));

                Intent intent = new Intent(SettingActivity.this, MyMapActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(mymapa, "mymap");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SettingActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());

                }

            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, PushNotificationActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(pn, "pn");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SettingActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());

                }
            }
        });


        privetpolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, PrivetPoliceActivity.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(pp, "pp");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SettingActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());

                }
            }
        });


        vesone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, VesoneActivity.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(vs, "vs");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SettingActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());

                }
            }
        });

//share app
        share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareBody = "https://play.google.com/store/apps/details?id=" + getPackageName();
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.app_name)));
            }
        });
///status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
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

        /*animation logo*/
        TextView text;
        Animation bottomanim;
        text = findViewById(R.id.text);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        text.setAnimation(bottomanim);
    }
}
