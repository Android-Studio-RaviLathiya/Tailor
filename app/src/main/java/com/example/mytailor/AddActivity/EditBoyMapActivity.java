package com.example.mytailor.AddActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputLayout;

public class EditBoyMapActivity extends AppCompatActivity {

    SQLiteDatabase db;
    String uid;
    ImageView addmap;


    //    boy
    RelativeLayout ashirt, apant, akurta, apayjama, ablazer, akoti;
    CheckBox addshirt, addpant, addkurta, addpayjama, addblazer, addkoti;
    TextView bcancle, bdone;
    TextInputLayout bfname, bsname, bphone, bheight, bweight;
    TextInputLayout bneak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_boy_map);

//        database
        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);

        bcancle = findViewById(R.id.bcancle);
        bdone = findViewById(R.id.bdone);
//        addmap = findViewById(R.id.addmap);

        bfname = findViewById(R.id.bfname);
        bsname = findViewById(R.id.bsname);
        bphone = findViewById(R.id.bphone);
        bheight = findViewById(R.id.bheight);
        bweight = findViewById(R.id.bweight);



//Done
        bdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bf = bfname.getEditText().getText().toString();
                String bs = bsname.getEditText().getText().toString();
                String bp = bphone.getEditText().getText().toString();
                String bh = bheight.getEditText().getText().toString();
                String bw = bweight.getEditText().getText().toString();

                if (bf.equals("")) {
                    bfname.setError("Field Name");
                } else if (bp.equals("")) {
                    bphone.setError("Field Phone Number");
                } else {
                    db.execSQL("insert into boys(bname,bsname,bphone,bheight,bweight,uid) values('" + bf + "','" + bs + "','" + bp + "','" + bh + "','" + bw + "','" + uid + "')");
                    Intent intent = new Intent(EditBoyMapActivity.this, AddBoyMap.class);
                    intent.putExtra("boys", uid);
                    startActivity(intent);
                    finish();
                }
            }
        });


        bcancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


//        check
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



    }
}
