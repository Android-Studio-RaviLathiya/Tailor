package com.example.mytailor.SettingActivity.NewbusinessStart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mytailor.Activity.MainActivity;
import com.example.mytailor.Activity.WelcomeActivity;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;

public class TailorType extends AppCompatActivity {
    ImageView back;
    CheckBox boyt, girlt, schoolt, rboyt, rgirlt, rant, drama;
    CardView cboy, cgirl;
    Button go;
    String boy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tailor_type);

        boyt = findViewById(R.id.boyt);
        girlt = findViewById(R.id.girlt);
        schoolt = findViewById(R.id.schoolt);
        rboyt = findViewById(R.id.sboyt);
        rgirlt = findViewById(R.id.sgirlt);

        drama = findViewById(R.id.drama);

        cboy = findViewById(R.id.cboy);
        cgirl = findViewById(R.id.cgirl);
        go = findViewById(R.id.go);
        back = findViewById(R.id.back);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (boyt.isChecked()) {
                    MyPrefrence.setboytailor(true);

                    startActivity(new Intent(TailorType.this, PasnalDetail.class));
                } else if (girlt.isChecked()) {
                    MyPrefrence.setgirltailor(true);

                    startActivity(new Intent(TailorType.this, PasnalDetail.class));

                } else if (rboyt.isChecked()) {
                    MyPrefrence.setbrant(true);

                    startActivity(new Intent(TailorType.this, PasnalDetail.class));

                } else if (rgirlt.isChecked()) {
                    MyPrefrence.setgrant(true);

                    startActivity(new Intent(TailorType.this, PasnalDetail.class));

                } else if (schoolt.isChecked()) {
                    MyPrefrence.setschoolshop(true);

                    startActivity(new Intent(TailorType.this, EnterSchoolName.class));

                } else if (drama.isChecked()) {
                    MyPrefrence.setdramashop(true);

                    startActivity(new Intent(TailorType.this, PasnalDetail.class));
                } else {

                    Toast toast = Toast.makeText(TailorType.this, "Select Your Tailor", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

            }
        });

        schoolt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (schoolt.isChecked()) {
                    MyPrefrence.setschollname(true);
                } else {
                    MyPrefrence.setschollname(false);
                }
            }
        });


//        boyt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (boyt.isChecked()){
//                    MyPrefrence.setaddbtn(true);
//                }else {
//
//                }
//            }
//        });


//             rant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//                if (rant.isChecked()) {
//                    cboy.setVisibility(View.VISIBLE);
//                    cgirl.setVisibility(View.VISIBLE);
//                } else if (!rant.isChecked()) {
//                    cboy.setVisibility(View.GONE);
//                    cgirl.setVisibility(View.GONE);
//                }
//            }
//        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        //        status bar colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.appcolor));
        }

    }
}
