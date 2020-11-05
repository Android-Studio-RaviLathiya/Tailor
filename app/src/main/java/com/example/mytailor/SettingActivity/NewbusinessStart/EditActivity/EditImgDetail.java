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

import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.NewbusinessStart.BusinessProfile;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditImage;
import com.example.mytailor.SettingActivity.NewbusinessStart.OtherBranch;

public class EditImgDetail extends AppCompatActivity {

    ImageView back;
    Button go;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);


        back = findViewById(R.id.back);
        go = findViewById(R.id.go);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditImgDetail.this, BusinessProfile.class));
                finish();
                Toast.makeText(EditImgDetail.this, "Update", Toast.LENGTH_SHORT).show();

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
