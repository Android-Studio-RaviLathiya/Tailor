package com.example.mytailor.AddActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputLayout;

import java.text.BreakIterator;
import java.util.Calendar;
import java.util.Date;

public class EditDramaMapActivity extends AppCompatActivity {

    TextView add;
    TextInputLayout fname, sname, billno, sms, phonenumber, relative, item, totalamount, diposit, leftamount;
    TextView showtime, showdate, datepicker, timep;
    int d, m, y;
    int H, M;
    ImageView datebtn, timebtn;
    Calendar calendar = Calendar.getInstance();
    CheckBox ck;
    String uid;
    SQLiteDatabase db;
    TextView cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_drama_map);

        //        database
        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);

        billno = findViewById(R.id.billno);
        fname = findViewById(R.id.fname);
        sname = findViewById(R.id.sname);
        sms = findViewById(R.id.sms);
        phonenumber = findViewById(R.id.phonenumber);
        relative = findViewById(R.id.relative);
        item = findViewById(R.id.item);

        timebtn = findViewById(R.id.timebtn);
        datebtn = findViewById(R.id.datebtn);
        cancle = findViewById(R.id.cancle);

        add = findViewById(R.id.add);
        totalamount = findViewById(R.id.totalamount);
        diposit = findViewById(R.id.diposit);
        leftamount = findViewById(R.id.leftamount);

        ck = findViewById(R.id.ck);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bn = billno.getEditText().getText().toString().trim();
                String fn = fname.getEditText().getText().toString().trim();
                String sn = sname.getEditText().getText().toString().trim();
                String sm = sms.getEditText().getText().toString().trim();
                String ph = phonenumber.getEditText().getText().toString().trim();
                String re = relative.getEditText().getText().toString().trim();
                String it = item.getEditText().getText().toString().trim();
                String to = totalamount.getEditText().getText().toString().trim();
                String di = diposit.getEditText().getText().toString().trim();
                String le = leftamount.getEditText().getText().toString().trim();

                if (fn.equals("")) {
                    fname.setError("Field Name");

                } else if (sm.equals("")) {
                    sms.setError("Field SMS Number");

                } else if (sm.length() < 10) {
                    sms.setError("NOt Valid Number");
                } else if (it.equals("")) {
                    item.setError("Field Item");

                } else if (to.equals("")) {
                    totalamount.setError("Field Total Amount");

                } else if (di.equals("")) {
                    diposit.setError("Field Diposit");

                } else {
                    db.execSQL("insert into drama(fname,sname,uid) values('" + fn + "','" + sn + "','" + uid + "') ");
                    Intent intent = new Intent(EditDramaMapActivity.this, AddDramaMap.class);
                    intent.putExtra("drama", uid);
                    startActivity(intent);
                    finish();
                }

            }
        });

//        time and date

        showtime = findViewById(R.id.showtime);
        showdate = findViewById(R.id.showdate);
        datepicker = findViewById(R.id.datepicker);
        timep = findViewById(R.id.timep);


//date
        String date = java.text.DateFormat.getDateInstance().format(new Date());
        showdate.setText(date);
//time
        String time = java.text.DateFormat.getTimeInstance().format(new Date());
        showtime.setText(time);

        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = calendar.get(Calendar.YEAR);
                m = calendar.get(Calendar.MONTH);
                d = calendar.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(EditDramaMapActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        datepicker.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                    }
                }, y, m, d);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() -1000);
                datePickerDialog.show();


            }
        });

        timebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                H = calendar.get(Calendar.HOUR_OF_DAY);
                M = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(EditDramaMapActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timep.setText(hourOfDay + ":" + minute);
                    }
                }, H, M, true);
                timePickerDialog.show();

            }
        });


//        status bar colour
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //sum
        TextWatcher text = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!diposit.getEditText().getText().toString().equals("") && !totalamount.getEditText().getText().toString().equals("")) {
                    leftamount.getEditText().setText(String.valueOf(Integer.valueOf(totalamount.getEditText().getText().toString()) - Integer.valueOf(diposit.getEditText().getText().toString())));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        totalamount.getEditText().addTextChangedListener(text);
        diposit.getEditText().addTextChangedListener(text);


    }
}
