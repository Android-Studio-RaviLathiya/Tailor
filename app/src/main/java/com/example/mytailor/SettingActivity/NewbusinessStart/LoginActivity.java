package com.example.mytailor.SettingActivity.NewbusinessStart;

import android.app.ActivityOptions;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout username, password;
    Button go, singup;
    ImageView logo_img;
    TextView logo_text, welcome_text;
    SQLiteDatabase db;
    CheckBox cb;
    TextView text;
    Animation bottomanim;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists user(id integer primary key autoincrement,fn text,em text,ph text,pa text,conp text,gender text)");
        db.execSQL("create table if not exists boys(id integer primary key autoincrement,bname text,bsname text,bphone text,bheight text,bweight text,uid text)");
        db.execSQL("create table if not exists girls(id integer primary key autoincrement,gname text,gsname text,gphone text,gheight text,gweight text,uid text)");
        db.execSQL("create table if not exists user(id integer primary key autoincrement,fn text,em text,ph text,pa text,conp text,gender text)");
        db.execSQL("create table if not exists boys(id integer primary key autoincrement,bname text,bsname text,bphone text,bheight text,bweight text,uid text)");
        db.execSQL("create table if not exists girls(id integer primary key autoincrement,gname text,gsname text,gphone text,gheight text,gweight text,uid text)");
        db.execSQL("create table if not exists drama(id integer primary key  autoincrement,fname text,sname text,uid text)");
        db.execSQL("create table if not exists addschoolname(id integer primary key  autoincrement,addschoolname text)");


        go = findViewById(R.id.go);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        singup = findViewById(R.id.singup);
        logo_text = findViewById(R.id.logo_text);
        welcome_text = findViewById(R.id.welcome_text);
        cb = findViewById(R.id.cb);

        cb.setChecked(MyPrefrence.getStatus());

        if (MyPrefrence.getStatus()) {
            username.getEditText().setText(MyPrefrence.getphone());
            password.getEditText().setText(MyPrefrence.getpass());
        }

        if (MyPrefrence.getLogin()) {
            Intent intent = new Intent(LoginActivity.this, BusinessProfile.class);
            startActivity(intent);
            finish();
        }
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MyPrefrence.setStatus(true);
                    Toast.makeText(LoginActivity.this, "Remember", Toast.LENGTH_SHORT).show();
                } else {
                    MyPrefrence.setStatus(false);
                    Toast.makeText(LoginActivity.this, "Not Remember", Toast.LENGTH_SHORT).show();
                }
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String ph = username.getEditText().getText().toString();
                    String pa = password.getEditText().getText().toString();

                    if (ph.equals("")) {
                        username.setError("Field Email");
                    } else if (ph.length() < 10) {
                        username.setError("Not Valid Number");
                    } else if (pa.equals("")) {
                        password.setError("Field Password");
                    } else {
                        Cursor c = db.rawQuery("select * from user where ph = '" + ph + "' and pa = '" + pa + "'", null);

                        if (c != null) {
                            if (c.moveToNext()) {

                                MyPrefrence.setLogin(true);

                                if (MyPrefrence.getStatus()) {
                                    MyPrefrence.setphone(ph);
                                    MyPrefrence.setpass(pa);
                                }

                                String uid = c.getString(0);
                                Intent intent = new Intent(LoginActivity.this, TailorType.class);
                                MyPrefrence.setuid(uid);
                                startActivity(intent);
                                finish();

//                                Log.e("Login", "Name" + c.getString(1));
//                                Log.e("Login", "Email" + c.getString(2));
//                                Log.e("Login", "Phone" + c.getString(3));
//                                Log.e("Login", "pass" + c.getString(4));

                            } else {
                                MyPrefrence.setLogin(false);
                                Toast.makeText(LoginActivity.this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }


                } catch (Exception r) {
                    r.printStackTrace();
                }
            }
        });

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SingupActivity.class);

                Pair[] pairs = new Pair[5];
                pairs[0] = new Pair<View, String>(go, "go");
                pairs[1] = new Pair<View, String>(username, "username");
                pairs[2] = new Pair<View, String>(password, "password");
                pairs[3] = new Pair<View, String>(welcome_text, "welcome_text");
                pairs[4] = new Pair<View, String>(cb, "check");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        });

//Animation
        text = findViewById(R.id.text);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        text.setAnimation(bottomanim);
///status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.appcolor));
        }
    }

}