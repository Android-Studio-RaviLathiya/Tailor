package com.example.mytailor.SettingActivity.MyMap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mytailor.R;

public class MaleMapActivity extends AppCompatActivity {

    RelativeLayout ashirt, apant, akurta, apayjama, ablazer, akoti;
    CheckBox addshirt, addpant, addkurta, addpayjama, addblazer, addkoti;
    Button go;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_map);


        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaleMapActivity.this, ShowMapActivity.class));
            }
        });

//        chek
        ashirt = findViewById(R.id.ashirt);
        apant = findViewById(R.id.apant);
        akurta = findViewById(R.id.akurta);
        apayjama = findViewById(R.id.apayjama);
        ablazer = findViewById(R.id.ablazer);
        akoti = findViewById(R.id.akoti);

        addshirt = findViewById(R.id.addshirt);
        addpant = findViewById(R.id.addpant);
        addkurta = findViewById(R.id.addkurta);
        addpayjama = findViewById(R.id.addpayjama);
        addblazer = findViewById(R.id.addblazer);
        addkoti = findViewById(R.id.addkoti);

//        check
        addshirt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (addshirt.isChecked()) {
                    ashirt.setVisibility(View.VISIBLE);
                } else {
                    ashirt.setVisibility(View.GONE);
                }
            }
        });

        addpant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (addpant.isChecked()) {
                    apant.setVisibility(View.VISIBLE);
                } else {
                    apant.setVisibility(View.GONE);
                }
            }
        });


        addkurta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (addkurta.isChecked()) {
                    akurta.setVisibility(View.VISIBLE);
                } else {
                    akurta.setVisibility(View.GONE);
                }
            }
        });

        addpayjama.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (addpayjama.isChecked()) {
                    apayjama.setVisibility(View.VISIBLE);
                } else {
                    apayjama.setVisibility(View.GONE);
                }
            }
        });

        addblazer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (addblazer.isChecked()) {
                    ablazer.setVisibility(View.VISIBLE);
                } else {
                    ablazer.setVisibility(View.GONE);
                }
            }
        });

        addkoti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (addkoti.isChecked()) {
                    akoti.setVisibility(View.VISIBLE);
                } else {
                    akoti.setVisibility(View.GONE);
                }
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

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
