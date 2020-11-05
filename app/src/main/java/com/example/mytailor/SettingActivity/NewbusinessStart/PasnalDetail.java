package com.example.mytailor.SettingActivity.NewbusinessStart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputLayout;

public class PasnalDetail extends AppCompatActivity {

    ImageView back;
    Button go;
    TextInputLayout firstname, surname, pasnalnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasnal_detail);


        back = findViewById(R.id.back);
        go = findViewById(R.id.go);
        firstname = findViewById(R.id.firstname);
        surname = findViewById(R.id.surname);
        pasnalnumber = findViewById(R.id.pasnalnumber);

        if (MyPrefrence.getpasnal()){
             firstname.getEditText().setText(MyPrefrence.getbfname());
            surname.getEditText().setText(MyPrefrence.getbsname());
            pasnalnumber.getEditText().setText(MyPrefrence.getbpasnalnumber());
        }


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = firstname.getEditText().getText().toString();
                String sname = surname.getEditText().getText().toString();
                String pnumber = pasnalnumber.getEditText().getText().toString();


                if (fname.equals("")) {
                    firstname.setError("Field Name");
                } else if (pnumber.equals("")) {
                    pasnalnumber.setError("Field Number");
                } else if (pnumber.length() < 10) {
                    pasnalnumber.setError("Not Valid Number");
                } else  {
                    startActivity(new Intent(PasnalDetail.this, ContectDetail.class));

                    MyPrefrence.setpasnal(true);
                    if (MyPrefrence.getpasnal()){
                        MyPrefrence.setbfname(fname);
                        MyPrefrence.setbsname(sname);
                        MyPrefrence.setbpasnalnumber(pnumber);
                    }



                }


            }
        });


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
