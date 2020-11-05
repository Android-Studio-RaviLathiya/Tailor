package com.example.mytailor.SettingActivity.NewbusinessStart;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SingupActivity extends AppCompatActivity {

    TextInputLayout fullname, password, conpassword, phone, email;
    Button go;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String phonepaten = "(0/91)?[7-9][0-9]{9}";
    CheckBox check;
    SQLiteDatabase db;
    RadioButton male, female;
    String gender;
    TextView text;
    Animation bottomanim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

//        find by id
        go = findViewById(R.id.go);
        fullname = findViewById(R.id.fullname);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        check = findViewById(R.id.check);
        conpassword = findViewById(R.id.conpassword);
        email = findViewById(R.id.email);

        db = openOrCreateDatabase("ndg.db", MODE_PRIVATE, null);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String un = fullname.getEditText().getText().toString();
                String em = email.getEditText().getText().toString();
                String ph = phone.getEditText().getText().toString();
                String pa = password.getEditText().getText().toString();
                String con = conpassword.getEditText().getText().toString();


                if (un.equals("")) {
                    fullname.setError("Field Name");
                } else if (em.equals("")) {
                    email.setError("Field Email");
                } else if (ph.equals("")) {
                    phone.setError("Field Phone Number");
                } else if (!ph.matches(phonepaten)) {
                    Toast.makeText(SingupActivity.this, "Not Valid Phone No.", Toast.LENGTH_SHORT).show();
                } else if (pa.equals("")) {
                    password.setError("Field Password");
                } else if (con.equals("")) {
                    conpassword.setError("Field Password");
                } else if (!con.equals(pa)) {
                    conpassword.setError("Not Match Pass");
                } else if (!check.isChecked()) {
                    Toast.makeText(SingupActivity.this, "Accept Terms and Conditions", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor c = db.rawQuery("select * from user where ph='" + ph + "'", null);

                    if (c != null) {
                        if (c.moveToNext()) {

                            Toast.makeText(SingupActivity.this, "Alredy", Toast.LENGTH_SHORT).show();

                        } else {
                            db.execSQL("INSERT INTO user(fn, em, ph, pa,conp,gender) values('" + un + "','" + em + "','" + ph + "','" + pa + "','" + con + "','" + gender + "')");

                            Toast.makeText(SingupActivity.this, "Success fully", Toast.LENGTH_SHORT).show();
                            onBackPressed();




                        }

                    }

                }

            }
        });


//        keyboard hid
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


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


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1213 && resultCode == Activity.RESULT_OK) {
//            String filePath = data.getStringExtra(ImageSelectActivity.RESULT_FILE_PATH);
//
//            Uri uri = Uri.parse(filePath);
//            camera.setImageURI(uri);
//        }
//
//    }
}



