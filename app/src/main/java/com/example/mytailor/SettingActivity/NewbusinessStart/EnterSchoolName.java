package com.example.mytailor.SettingActivity.NewbusinessStart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class EnterSchoolName extends AppCompatActivity {

    TextInputLayout name;
    Button add, go;
    RecyclerView rv;
    ArrayList<Schoolitem> schoolitems = new ArrayList<>();
    SchoolAdepter schoolAdepter;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_school_name);

        name = findViewById(R.id.name);
        add = findViewById(R.id.add);
        go = findViewById(R.id.go);
        rv = findViewById(R.id.rv);

        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(EnterSchoolName.this, PasnalDetail.class));
                finish();

            }
        });


//back button
        ImageView back;
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
///status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.appcolor));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String sn = name.getEditText().getText().toString().trim();

                if (!name.equals("")) {

                    db.execSQL("insert into addschoolname(addschoolname) values('" + sn + "')");

                    dataload();
                } else {

                    name.setError("Enter Scool Name");
                    Toast.makeText(EnterSchoolName.this, "Enter School Name", Toast.LENGTH_SHORT).show();


                }

            }


        });
    }

    private void dataload() {

        schoolitems.clear();

        Cursor c = db.rawQuery("select * from addschoolname", null);

        if (c != null) {
            while (c.moveToNext()) {


                Schoolitem schoolitem = new Schoolitem(c.getString(0), c.getString(1));
                schoolitems.add(schoolitem);
            }
            schoolAdepter = new SchoolAdepter(schoolitems, EnterSchoolName.this);
            rv.setAdapter(schoolAdepter);


        }
    }
}



