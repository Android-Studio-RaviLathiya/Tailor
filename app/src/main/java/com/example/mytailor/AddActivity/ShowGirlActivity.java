package com.example.mytailor.AddActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mytailor.R;

public class ShowGirlActivity extends AppCompatActivity {

    TextView name, phone, surname, weight, height;
    String uid, uid1, uid2, uid3, uid4, uid5;
    RelativeLayout gshirt, gpant, gblazer, gdress, gkurti, gonepiece, gblouse, ggown;
    CheckBox gaddshirt, gaddpant, gadddress, gaddkurti, gaddblazer, gaddblouse, gaddonepiece, gaddgown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_girl);


        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        surname = findViewById(R.id.surname);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            uid = bundle.getString("gname");
            uid1 = bundle.getString("gsname");
            uid2 = bundle.getString("gphone");
            uid3 = bundle.getString("gheight");
            uid4 = bundle.getString("gweight");
            uid5 = bundle.getString("girl");
        }

        name.setText(uid);
        surname.setText(uid1);
        phone.setText(uid2);
        height.setText(uid3);
        weight.setText(uid4);


//        check
        gshirt = findViewById(R.id.gshirt);
        gpant = findViewById(R.id.gpant);
        gdress = findViewById(R.id.gdress);
        gkurti = findViewById(R.id.gkurti);
        gonepiece = findViewById(R.id.gonepiece);
        ggown = findViewById(R.id.ggown);
        gblouse = findViewById(R.id.gblouse);
        gblazer = findViewById(R.id.gblazer);

        gaddshirt = findViewById(R.id.gaddshirt);
        gaddpant = findViewById(R.id.gaddpant);
        gadddress = findViewById(R.id.gadddress);
        gaddkurti = findViewById(R.id.gaddkurti);
        gaddonepiece = findViewById(R.id.gaddonepiece);
        gaddgown = findViewById(R.id.gaddgown);
        gaddblouse = findViewById(R.id.gaddblouse);
        gaddblazer = findViewById(R.id.gaddblazer);

        gaddshirt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gaddshirt.isChecked()) {
                    gshirt.setVisibility(View.VISIBLE);
                } else {
                    gshirt.setVisibility(View.GONE);
                }
            }
        });
        gaddpant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gaddpant.isChecked()) {
                    gpant.setVisibility(View.VISIBLE);
                } else {
                    gpant.setVisibility(View.GONE);
                }
            }
        });
        gadddress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gadddress.isChecked()) {
                    gdress.setVisibility(View.VISIBLE);
                } else {
                    gdress.setVisibility(View.GONE);
                }
            }
        });
        gaddkurti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gaddkurti.isChecked()) {
                    gkurti.setVisibility(View.VISIBLE);
                } else {
                    gkurti.setVisibility(View.GONE);
                }
            }
        });
        gaddonepiece.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gaddonepiece.isChecked()) {
                    gonepiece.setVisibility(View.VISIBLE);
                } else {
                    gonepiece.setVisibility(View.GONE);
                }
            }
        });
        gaddgown.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gaddgown.isChecked()) {
                    ggown.setVisibility(View.VISIBLE);
                } else {
                    ggown.setVisibility(View.GONE);
                }
            }
        });
        gaddblouse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gaddblouse.isChecked()) {
                    gblouse.setVisibility(View.VISIBLE);
                } else {
                    gblouse.setVisibility(View.GONE);
                }
            }
        });
        gaddblazer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gaddblazer.isChecked()) {
                    gblazer.setVisibility(View.VISIBLE);
                } else {
                    gblazer.setVisibility(View.GONE);
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




    }
}
