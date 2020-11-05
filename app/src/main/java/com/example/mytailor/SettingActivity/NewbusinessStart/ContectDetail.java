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

public class ContectDetail extends AppCompatActivity {
    ImageView back;
    Button go;
    TextInputLayout email, whatsapp, shopphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contect_detail);


        back = findViewById(R.id.back);
        go = findViewById(R.id.go);
        email = findViewById(R.id.email);
        whatsapp = findViewById(R.id.whatsapp);
        shopphone = findViewById(R.id.shopphone);


        if (MyPrefrence.getpasnal()){
            email.getEditText().setText(MyPrefrence.getbemail());
            whatsapp.getEditText().setText(MyPrefrence.getbwhatsno());
            shopphone.getEditText().setText(MyPrefrence.getbshopm());
        }

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String whatsappn = whatsapp.getEditText().getText().toString();
                String mail = email.getEditText().getText().toString();
                String shopp = shopphone.getEditText().getText().toString();

                if (whatsappn.equals("")) {
                    whatsapp.setError("Field Whatsapp Number");
                } else if (whatsappn.length() < 10) {
                    whatsapp.setError("Not Valid Number");
                } else if (shopp.equals("")) {
                    shopphone.setError("Field Phoen Number");
                } else if (shopp.length() < 10) {
                    shopphone.setError("Not Valid Number");
                } else {
                    startActivity(new Intent(ContectDetail.this, ShopDetail.class));

                    MyPrefrence.setbcontec(true);
                    if (MyPrefrence.getbcontect()){
                        MyPrefrence.setbemail(mail);
                        MyPrefrence.setbwhatsno(whatsappn);
                        MyPrefrence.setbshopm(shopp);
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
