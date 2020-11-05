package com.example.mytailor.SettingActivity.NewbusinessStart;

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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditActivity.EditPasnalDetail;

public class NewBussStart extends AppCompatActivity {

    TextView text, names;
    Animation bottomanim;
    Button go;
    ImageView back;
    ImageView one;


    TextView pasnala, contecta, shopa, shopaddressa, editimga, otherbrancha, tailortype;
    CardView pasnald, contectd, shopd, shopaddressd, editimgd, otherbranchd, tailor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_buss_start);

        pasnald = findViewById(R.id.pasnald);
        contectd = findViewById(R.id.contectd);
        shopd = findViewById(R.id.shopd);
        editimgd = findViewById(R.id.editimgd);
        otherbranchd = findViewById(R.id.otherbranchd);
        shopaddressd = findViewById(R.id.shopaddressd);
        go = findViewById(R.id.go);


//        go.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(NewBussStart.this, Showbussdetail.class));
//            }
//        });


        pasnald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewBussStart.this, EditPasnalDetail.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(pasnala, "pasnala");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(NewBussStart.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        });

        contectd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewBussStart.this, ContectDetail.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(contecta, "contecta");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(NewBussStart.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        });

        shopd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewBussStart.this, ShopDetail.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(shopa, "shopa");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(NewBussStart.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }

            }
        });

        shopaddressd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewBussStart.this, ShopAddressDetail.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(shopaddressa, "shopaddressa");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(NewBussStart.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        });


        editimgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewBussStart.this, EditImage.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(editimga, "editimga");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(NewBussStart.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        });

        otherbranchd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewBussStart.this, OtherBranch.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(otherbrancha, "otherbrancha");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(NewBussStart.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        });

        pasnala = findViewById(R.id.pasnala);
        contecta = findViewById(R.id.contecta);
        shopa = findViewById(R.id.shopa);
        shopaddressa = findViewById(R.id.shopaddressa);
        editimga = findViewById(R.id.editimga);
        otherbrancha = findViewById(R.id.otherbrancha);


        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//Animation
        text = findViewById(R.id.text);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        text.setAnimation(bottomanim);
///status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

    }
}
