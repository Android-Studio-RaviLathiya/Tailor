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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputLayout;

public class EditGirlsMapActivity extends AppCompatActivity {

    //    girls
    RelativeLayout gshirt, gpant, gblazer, gdress, gkurti, gonepiece, gblouse, ggown;
    CheckBox gaddshirt, gaddpant, gadddress, gaddkurti, gaddblazer, gaddblouse, gaddonepiece, gaddgown;
    TextView gcancle, gdone;
    TextInputLayout gfname, gsname, gphone, gheight, gweight;
    SQLiteDatabase db;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_girls_map);

        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);



//        girls
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

        gcancle = findViewById(R.id.gcancle);
        gdone = findViewById(R.id.gdone);

        gfname = findViewById(R.id.gfname);
        gsname = findViewById(R.id.gsname);
        gphone = findViewById(R.id.gphone);
        gheight = findViewById(R.id.gheight);
        gweight = findViewById(R.id.gweight);


        gdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gname = gfname.getEditText().getText().toString();
                String gsurname = gsname.getEditText().getText().toString();
                String phone = gphone.getEditText().getText().toString();
                String height = gheight.getEditText().getText().toString();
                String weight = gweight.getEditText().getText().toString();

                if (gname.equals("")) {
                        gfname.setError("Field Name");
                } else if (phone.equals("")) {
                    gphone.setError("Field Phone Number");
                } else {
                    db.execSQL("insert into girls(gname,gsname,gphone,gheight,gweight,uid) values('" + gname + "','" + gsurname + "','" + phone + "','" + height + "','" + weight + "','" + uid + "')");
                    Intent intent = new Intent(EditGirlsMapActivity.this, AddGirlMap.class);
                    intent.putExtra("girls", uid);
                    startActivity(intent);
                    finish();
                }


            }
        });

        gcancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        chech
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
