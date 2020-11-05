package com.example.mytailor.OtpLoging;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mytailor.Activity.MainActivity;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class LoginWithMobileNoActivity extends AppCompatActivity {

    TextView text, maybelater;
    Animation bottomanim;
    FloatingActionButton ok;
    TextInputLayout name, phone;
    SQLiteDatabase db;
    LinearLayout box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_mobile_no);

        ok = findViewById(R.id.ok);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        box = findViewById(R.id.box);

        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists newuser(id integer primary key autoincrement,uname text,uphone text)");


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = name.getEditText().getText().toString();
                String uphone = phone.getEditText().getText().toString();


                if (uname.equals("")) {
                    name.setError("Field Name");
                } else if (uphone.equals("")) {
                    phone.setError("Field Phone Number");
                } else if (uphone.length() < 10) {
                    phone.setError("Not Valid Number");
                } else {

                    db.execSQL("insert into newuser(uname,uphone) values('" + uname + "','" + uphone + "')");
                    MyPrefrence.setuname(uname);
                    MyPrefrence.setuphone(uphone);
                    MyPrefrence.setulogin(true);
                    Intent intent = new Intent(LoginWithMobileNoActivity.this, OtpSendActivity.class);

                    Pair[] pairs = new Pair[2];
                    pairs[0] = new Pair<View, String>(box, "box");
                    pairs[1] = new Pair<View, String>(ok, "ok");

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginWithMobileNoActivity.this, pairs);
                        startActivity(intent, activityOptions.toBundle());
                    }

                }

            }
        });




//Login ok
        if (MyPrefrence.getulogin()) {
            Intent intent = new Intent(LoginWithMobileNoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
//Animation
        text = findViewById(R.id.text);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        text.setAnimation(bottomanim);
//status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.appcolor));
        }

    }
}
