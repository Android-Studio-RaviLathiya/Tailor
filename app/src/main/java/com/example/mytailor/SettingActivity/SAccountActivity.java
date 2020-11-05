package com.example.mytailor.SettingActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mytailor.OtpLoging.LoginWithMobileNoActivity;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;

public class SAccountActivity extends AppCompatActivity {

    TextView name, phone, email, names;
    RelativeLayout logout;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_account);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        back = findViewById(R.id.back);
        logout = findViewById(R.id.logout);
        names = findViewById(R.id.names);



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPrefrence.setulogin(false);
                startActivity(new Intent(SAccountActivity.this, LoginWithMobileNoActivity.class));
                finish();
            }
        });

        name.setText(MyPrefrence.getuname());
        names.setText(MyPrefrence.getuname());
        phone.setText(MyPrefrence.getuphone());
        email.setText(MyPrefrence.getuEmail());


        //status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void edit(View view) {
        startActivity(new Intent(SAccountActivity.this,EditAccountMobile.class));

    }
}
