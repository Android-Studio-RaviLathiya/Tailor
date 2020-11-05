package com.example.mytailor.SettingActivity.NewbusinessStart;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.SettingActivity;
import com.google.android.material.textfield.TextInputLayout;

public class OtherBranch extends AppCompatActivity {

    TextView skip;
    ImageView back;
    RelativeLayout other;
    CheckBox cb;
    Button go;
    TextInputLayout shopnameone, phoneone, shopnumberone, shopaddressone, oppone, areaone, cityone, stateone, pincodeone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_branch);

        back = findViewById(R.id.back);
        cb = findViewById(R.id.cb);
        other = findViewById(R.id.other);
        go = findViewById(R.id.go);
        shopnameone = findViewById(R.id.shopnameone);
        phoneone = findViewById(R.id.phoneone);
        shopnumberone = findViewById(R.id.shopnumberone);
        shopaddressone = findViewById(R.id.shopaddressone);
        oppone = findViewById(R.id.oppone);
        areaone = findViewById(R.id.areaone);
        cityone = findViewById(R.id.cityone);
        stateone = findViewById(R.id.stateone);
        pincodeone = findViewById(R.id.pincodeone);
        skip = findViewById(R.id.skip);

        if (MyPrefrence.getbother()) {
            shopnameone.getEditText().setText(MyPrefrence.getobshopname());
            phoneone.getEditText().setText(MyPrefrence.getobshopphone());
            shopnumberone.getEditText().setText(MyPrefrence.getobshopnumber());
            shopaddressone.getEditText().setText(MyPrefrence.getobshopadd());
            oppone.getEditText().setText(MyPrefrence.getobshopopp());
            areaone.getEditText().setText(MyPrefrence.getobshoparea());
            cityone.getEditText().setText(MyPrefrence.getobshopcity());
            stateone.getEditText().setText(MyPrefrence.getobshopstate());
            pincodeone.getEditText().setText(MyPrefrence.getobshoppincode());

        }

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String shopname = shopnameone.getEditText().getText().toString();
                String phone = phoneone.getEditText().getText().toString();
                String shopnumber = shopnumberone.getEditText().getText().toString();
                String shopaddres = shopaddressone.getEditText().getText().toString();
                String opp = oppone.getEditText().getText().toString();
                String area = areaone.getEditText().getText().toString();
                String city = cityone.getEditText().getText().toString();
                String state = stateone.getEditText().getText().toString();
                String pincode = pincodeone.getEditText().getText().toString();

                if (shopname.equals("")) {
                    shopnameone.setError("Field Shop Name");
                } else if (phone.equals("")) {
                    phoneone.setError("Field Phone Number");
                } else if (phone.length()<10){
                    phoneone.setError("Not Valid Number");
                } else if (shopnumber.equals("")) {
                    shopnumberone.setError("Field Shop Number");
                } else if (shopaddres.equals("")) {
                    shopaddressone.setError("Field Shop Address");
                } else if (opp.equals("")) {
                    oppone.setError("Field Opp");
                } else if (area.equals("")) {
                    areaone.setError("Field Area Name");
                } else if (city.equals("")) {
                    cityone.setError("Field City Name");
                } else if (state.equals("")) {
                    stateone.setError("Field State Name");
                } else if (pincode.equals("")) {
                    pincodeone.setError("Field Pincode");
                } else {
                    startActivity(new Intent(OtherBranch.this, BusinessProfile.class));
                    Toast.makeText(OtherBranch.this, "Creat Your Account", Toast.LENGTH_SHORT).show();
                    MyPrefrence.setbother(true);
                    if (MyPrefrence.getbother()) {
                        MyPrefrence.setobshopname(shopname);
                        MyPrefrence.setobshopphone(phone);
                        MyPrefrence.setobshopnumber(shopnumber);
                        MyPrefrence.setobshopadd(shopaddres);
                        MyPrefrence.setobshopopp(opp);
                        MyPrefrence.setobshoparea(area);
                        MyPrefrence.setobshopcity(city);
                        MyPrefrence.setobshopstate(state);
                        MyPrefrence.setobshoppincode(pincode);


                    }
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


        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb.isChecked()) {
                    other.setVisibility(View.VISIBLE);
                } else {
                    other.setVisibility(View.GONE);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OtherBranch.this, "Creat Your Account", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(OtherBranch.this, SettingActivity.class));
            }
        });

//        keyboard hid
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }
}
