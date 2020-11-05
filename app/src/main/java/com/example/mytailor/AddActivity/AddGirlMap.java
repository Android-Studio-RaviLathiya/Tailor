package com.example.mytailor.AddActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mytailor.Adepter.CusmorItem;
import com.example.mytailor.Adepter.GirlsAdepter;
import com.example.mytailor.Adepter.GirlsItem;
import com.example.mytailor.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddGirlMap extends AppCompatActivity {

    RecyclerView rv;
    FloatingActionButton fb;
    String uid;
    SQLiteDatabase db;
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_girl_map);

        rv = findViewById(R.id.rv);
        fb = findViewById(R.id.fb);
        sv = findViewById(R.id.sv1);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddGirlMap.this, EditGirlsMapActivity.class));
                finish();
            }
        });

        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        //        status bar colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
//back button
        ImageView back;
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            uid = bundle.getString("girls");
        }


        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                girlsAdepter.filter(newText);
                rv.invalidate();
                return false;
            }
        });
        mydata();
    }

    ArrayList<GirlsItem> girlsItems = new ArrayList<>();

    private void mydata() {

        girlsItems.clear();

        Cursor c = db.rawQuery("select * from girls", null);

        if (c != null) {

            while (c.moveToNext()) {

                GirlsItem girlsItem = new GirlsItem(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                girlsItems.add(girlsItem);

            }
            if (girlsItems.size() > 0) {
                GirlsAdepter girlsAdepter = new GirlsAdepter(girlsItems, AddGirlMap.this);
                rv.setAdapter(girlsAdepter);
            } else {

                Toast toast = Toast.makeText(this, "No Data", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }


        }


    }

    GirlsAdepter girlsAdepter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.girlsearch, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView sv = (SearchView) search.getActionView();

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                girlsAdepter.filter(newText);
                rv.invalidate();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }
}


