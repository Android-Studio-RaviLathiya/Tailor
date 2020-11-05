package com.example.mytailor.SettingActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UpdatePassActivity extends AppCompatActivity {

    TextInputLayout oldpass, newpass, conpass;
    ImageView back;
    Button go;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pass);

        oldpass = findViewById(R.id.oldpass);
        newpass = findViewById(R.id.newpass);
        conpass = findViewById(R.id.conpass);
        back = findViewById(R.id.back);;
         go = findViewById(R.id.go);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String op = oldpass.getEditText().getText().toString();
                String np = newpass.getEditText().getText().toString();
                String cp = conpass.getEditText().getText().toString();

                if (op.equals("")) {
                    oldpass.setError("Field Old Password");
                } else if (np.equals("")) {
                    newpass.setError("Field New Password");
                } else if (cp.equals("")) {
                    conpass.setError("Field Confome Password");
                } else if (!cp.equals(np)) {
                    Toast.makeText(UpdatePassActivity.this, "New & Confome Password not matches", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor c = db.rawQuery("select * from user where pa= '" + op + "'and id ='" + MyPrefrence.getuid() + "'", null);

                    if (c != null) {

                        if (c.moveToNext()) {

                            db.execSQL("update user set pa = '" + np + "'where id = '" + MyPrefrence.getuid() + "'");

                            Toast.makeText(UpdatePassActivity.this, "Update PassWord", Toast.LENGTH_SHORT).show();
                            onBackPressed();
                        } else
                            Toast.makeText(UpdatePassActivity.this, "Password Wrong", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });



///status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

    }
}
