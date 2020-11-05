package com.example.mytailor.SettingActivity.NewbusinessStart.EditActivity;

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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.NewbusinessStart.BusinessProfile;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditImage;
import com.example.mytailor.SettingActivity.NewbusinessStart.ShopAddressDetail;
import com.google.android.material.textfield.TextInputLayout;

public class EditShopAddDetail extends AppCompatActivity {

    ImageView back;
    CheckBox addshop;
    RelativeLayout shopdetail;
    Button go;
    TextInputLayout shopnumber, shopaddress, areaname, cityname, statename, pincode, opp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_address_detail);


        back = findViewById(R.id.back);
        go = findViewById(R.id.go);
        shopnumber = findViewById(R.id.shopnumber);
        shopaddress = findViewById(R.id.shopaddress);


        if (MyPrefrence.getbshopaddres()) {
            shopnumber.getEditText().setText(MyPrefrence.getbshopnumber());
            shopaddress.getEditText().setText(MyPrefrence.getbshopadd());

        }


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String shopno = shopnumber.getEditText().getText().toString();
                String address = shopaddress.getEditText().getText().toString();


                if (shopno.equals("")) {
                    shopnumber.setError("Field Shop Number");
                } else if (address.equals("")) {
                    shopaddress.setError("Field Address");
                } else {

                    startActivity(new Intent(EditShopAddDetail.this, BusinessProfile.class));
                    finish();
                    Toast.makeText(EditShopAddDetail.this, "Update", Toast.LENGTH_SHORT).show();

                    MyPrefrence.setbshopaddress(true);

                    if (MyPrefrence.getbshopaddres()) {
                        MyPrefrence.setbshopnumber(shopno);
                        MyPrefrence.setbshopadd(address);
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


        addshop = findViewById(R.id.addshop);
        shopdetail = findViewById(R.id.shopdetail);

        addshop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (addshop.isChecked()) {
                    shopdetail.setVisibility(View.VISIBLE);
                } else {
                    shopdetail.setVisibility(View.GONE);
                }
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
