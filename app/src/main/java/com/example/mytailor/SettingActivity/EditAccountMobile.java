package com.example.mytailor.SettingActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mytailor.Activity.MainActivity;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditImage;
import com.example.mytailor.SettingActivity.NewbusinessStart.OtherBranch;
import com.google.android.material.textfield.TextInputLayout;

public class EditAccountMobile extends AppCompatActivity {

    ImageView back;
    Button go;
    TextInputLayout uname, email, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account_mobile);


        back = findViewById(R.id.back);
        go = findViewById(R.id.go);
        uname = findViewById(R.id.uname);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);

        if (MyPrefrence.getuedit()) {

            uname.getEditText().setText(MyPrefrence.getuname());
            email.getEditText().setText(MyPrefrence.getuEmail());
            mobile.getEditText().setText(MyPrefrence.getuphone());

        }


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = uname.getEditText().getText().toString().trim();
                String em = email.getEditText().getText().toString().trim();
                String mo = mobile.getEditText().getText().toString().trim();


                MyPrefrence.setuedit(true);
                if (MyPrefrence.getuedit()) {

                    MyPrefrence.setuname(name);
                    MyPrefrence.setuEmail(em);
                    MyPrefrence.setuphone(mo);
                }
                startActivity(new Intent(EditAccountMobile.this, MainActivity.class));


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
