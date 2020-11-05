package com.example.mytailor.AddActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytailor.R;

public class ShowBoyActivity extends AppCompatActivity {

    RelativeLayout ashirt, apant, akurta, apayjama, ablazer, akoti;
    CheckBox addshirt, addpant, addkurta, addpayjama, addblazer, addkoti;

    TextView name, phone, surname,weight,height;
    String uid,uid1,uid2,uid3,uid4,uid5;

    TextView edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_boy);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        surname = findViewById(R.id.surname);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            uid = bundle.getString("Boy");
            uid1 = bundle.getString("fname");
            uid2 = bundle.getString("sname");
            uid3 = bundle.getString("bphone");
            uid4 = bundle.getString("bheight");
            uid5 = bundle.getString("bweight");
        }

        name.setText(uid1);
        surname.setText(uid2);
        phone.setText(uid3);
        weight.setText(uid5);
        height.setText(uid4);


        edit = findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



//        boy
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



//        status bar colour
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


    }
}


