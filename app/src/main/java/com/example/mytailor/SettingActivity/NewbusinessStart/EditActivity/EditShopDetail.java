package com.example.mytailor.SettingActivity.NewbusinessStart.EditActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.NewbusinessStart.BusinessProfile;
import com.example.mytailor.SettingActivity.NewbusinessStart.ShopAddressDetail;
import com.example.mytailor.SettingActivity.NewbusinessStart.ShopDetail;
import com.google.android.material.textfield.TextInputLayout;

public class EditShopDetail extends AppCompatActivity {

    ImageView back;
    TextInputLayout shopname, service, schoolname;
    Button go;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        back = findViewById(R.id.back);
        shopname = findViewById(R.id.shopname);
        service = findViewById(R.id.service);
        go = findViewById(R.id.go);

        if (MyPrefrence.getschollname()) {
            schoolname.setVisibility(View.VISIBLE);
        }


        if (MyPrefrence.getbshopd()) {
            shopname.getEditText().setText(MyPrefrence.getbshopname());
            service.getEditText().setText(MyPrefrence.getbservice());
        }


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shopn = shopname.getEditText().getText().toString();
                String ser = service.getEditText().getText().toString();

                if (shopn.equals("")) {
                    shopname.setError("Field Name");
                } else {
                    startActivity(new Intent(EditShopDetail.this, BusinessProfile.class));
                    finish();
                    Toast.makeText(EditShopDetail.this, "Update", Toast.LENGTH_SHORT).show();
                    MyPrefrence.setbshopd(true);
                    if (MyPrefrence.getbshopd()) {

                        MyPrefrence.setbshopname(shopn);
                        MyPrefrence.setbservice(ser);

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
