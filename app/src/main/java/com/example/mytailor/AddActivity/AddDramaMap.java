package com.example.mytailor.AddActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
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
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mytailor.Adepter.CustmorAdepter;
import com.example.mytailor.Adepter.DramaAdepter;
import com.example.mytailor.Adepter.DramaItem;
import com.example.mytailor.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddDramaMap extends AppCompatActivity {

    FloatingActionButton fb;
    SQLiteDatabase db;
    RecyclerView rv;
    SearchView sv;
    ArrayList<DramaItem> dramaItems = new ArrayList<>();
    DramaAdepter dramaadepter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drama_map);


//        sv = findViewById(R.id.sv);

        rv = findViewById(R.id.rv);
        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        fb = findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddDramaMap.this, EditDramaMapActivity.class));
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
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

/*search view method*/

//        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                dramaadepter.filter(newText);
//                rv.invalidate();
//                return false;
//            }
//        });


        mydata();
    }


    private void mydata() {

        dramaItems.clear();

        Cursor c = db.rawQuery("select * from drama", null);

        if (c != null) {

            while (c.moveToNext()) {

                DramaItem dramaItem = new DramaItem(c.getString(0), c.getString(1), c.getString(2));
                dramaItems.add(dramaItem);
            }

            if (dramaItems.size() > 0) {
                DramaAdepter dramaadepter = new DramaAdepter(dramaItems, AddDramaMap.this);
                rv.setAdapter(dramaadepter);
            } else {

                Toast toast = Toast.makeText(this, "No Data", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }

        }
    }

    /*search view method*/
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search, menu);
//
//        MenuItem search = menu.findItem(R.id.search);
//        androidx.appcompat.widget.SearchView sv = (androidx.appcompat.widget.SearchView) search.getActionView();
//
//        sv.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                dramaadepter.filter(newText);
//                rv.invalidate();
//                return false;
//            }
//        });
//
//        return super.onCreateOptionsMenu(menu);
//
//    }


}