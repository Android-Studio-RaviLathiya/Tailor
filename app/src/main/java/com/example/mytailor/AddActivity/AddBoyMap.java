package com.example.mytailor.AddActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mytailor.Adepter.CusmorItem;
import com.example.mytailor.Adepter.CustmorAdepter;
import com.example.mytailor.Adepter.DramaAdepter;
import com.example.mytailor.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddBoyMap extends AppCompatActivity {

    RecyclerView rv;
    FloatingActionButton fb;
    String uid;
    SQLiteDatabase db;
    SearchView sv;
    CustmorAdepter custmorAdepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_boy_map);

        rv = findViewById(R.id.rv);
        fb = findViewById(R.id.fb);
        sv = findViewById(R.id.sv);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);

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

            uid = bundle.getString("boys");
        }

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddBoyMap.this, EditBoyMapActivity.class));
                finish();
            }
        });


        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                custmorAdepter.filter(newText);
                rv.invalidate();
                return false;
            }


        });


        mydata();
    }

    ArrayList<CusmorItem> cusmorItems = new ArrayList<>();

    private void mydata() {

        cusmorItems.clear();

        Cursor c = db.rawQuery("select * from boys", null);

        if (c != null) {

            while (c.moveToNext()) {

                CusmorItem cusmorItem = new CusmorItem(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                cusmorItems.add(cusmorItem);

//                Log.e("customr", "id" + c.getString(0));
            }
            if (cusmorItems.size() > 0) {
                CustmorAdepter custmorAdepter = new CustmorAdepter(cusmorItems, AddBoyMap.this);
                rv.setAdapter(custmorAdepter);
            } else {

                Toast toast = Toast.makeText(this, "No Data", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);

        MenuItem search = menu.findItem(R.id.search);
        androidx.appcompat.widget.SearchView sv = (androidx.appcompat.widget.SearchView) search.getActionView();

        sv.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                custmorAdepter.filter(newText);
                rv.invalidate();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }

}
