package com.example.mytailor.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.mytailor.AddActivity.AddBoyMap;
import com.example.mytailor.AddActivity.AddDramaMap;
import com.example.mytailor.AddActivity.AddGirlMap;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;

public class WelcomeActivity extends AppCompatActivity {

    ImageView add, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        add = findViewById(R.id.add);
        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            }
        });


        if (MyPrefrence.getaddbtn()){
            add.setVisibility(View.VISIBLE);
        }else if (MyPrefrence.getaddbtn()){
            add.setVisibility(View.GONE);
        }





    }


}
