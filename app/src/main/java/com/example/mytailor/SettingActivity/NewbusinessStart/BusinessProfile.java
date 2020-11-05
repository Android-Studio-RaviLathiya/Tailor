package com.example.mytailor.SettingActivity.NewbusinessStart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditActivity.EditContectDetail;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditActivity.EditImgDetail;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditActivity.EditOtherBranchDetail;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditActivity.EditPasnalDetail;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditActivity.EditShopAddDetail;
import com.example.mytailor.SettingActivity.NewbusinessStart.EditActivity.EditShopDetail;
import com.example.mytailor.SettingActivity.UpdatePassActivity;

public class BusinessProfile extends AppCompatActivity {

    TextView name, surname, pasnalnumber, email, whatsapp, shopphone, shopname, service, shopadd, shopnumber, shopopp, area, city, state, pincode;

    //other branch
    TextView oshopname, oshopphone, oshopnumber, oshopadd, oshopopp, oarea, ocity, ostate, opincode;

    //    edit btn
    TextView pasnaledit, contecedit, shopdedit, shopaddedit, imgedit, otheredit;
    ImageView more;

    LinearLayout tailorboy, tailorgirl, brant, grant, school, drama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_profile);


        tailorboy = findViewById(R.id.tailorboy);
        tailorgirl = findViewById(R.id.tailorgirl);
        brant = findViewById(R.id.brant);
        grant = findViewById(R.id.grant);
        school = findViewById(R.id.school);
        drama = findViewById(R.id.drama);

        if (MyPrefrence.getboytailor()) {
            tailorboy.setVisibility(View.VISIBLE);
        }

        if (MyPrefrence.getgirltailor()) {
            tailorgirl.setVisibility(View.VISIBLE);
        }

        if (MyPrefrence.getbrant()) {
            brant.setVisibility(View.VISIBLE);
        }
        if (MyPrefrence.getgrant()) {
            grant.setVisibility(View.VISIBLE);
        }

        if (MyPrefrence.getschoolshop()) {
            school.setVisibility(View.VISIBLE);
        }

        if (MyPrefrence.getdramashop()) {
            drama.setVisibility(View.VISIBLE);
        }


//        other branch
        oshopname = findViewById(R.id.oshopname);
        oshopphone = findViewById(R.id.oshopphone);
        oshopnumber = findViewById(R.id.oshopnumber);
        oshopadd = findViewById(R.id.oshopadd);
        oshopopp = findViewById(R.id.oshopopp);
        oarea = findViewById(R.id.oarea);
        ocity = findViewById(R.id.ocity);
        ostate = findViewById(R.id.ostate);
        opincode = findViewById(R.id.opincode);

        oshopname.setText(MyPrefrence.getobshopname());
        oshopphone.setText(MyPrefrence.getobshopphone());
        oshopnumber.setText(MyPrefrence.getobshopnumber());
        oshopadd.setText(MyPrefrence.getobshopadd());
        oshopopp.setText(MyPrefrence.getobshopopp());
        oarea.setText(MyPrefrence.getobshoparea());
        ocity.setText(MyPrefrence.getobshopcity());
        ostate.setText(MyPrefrence.getobshopstate());
        opincode.setText(MyPrefrence.getobshoppincode());


//            pasnal detail
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        pasnalnumber = findViewById(R.id.pasnalnumber);


        name.setText(MyPrefrence.getbfname());
        surname.setText(MyPrefrence.getbsname());
        pasnalnumber.setText(MyPrefrence.getbpasnalnumber());


//        contect detail
        email = findViewById(R.id.email);
        whatsapp = findViewById(R.id.whatsapp);
        shopphone = findViewById(R.id.shopphone);

        email.setText(MyPrefrence.getbemail());
        whatsapp.setText(MyPrefrence.getbwhatsno());
        shopphone.setText(MyPrefrence.getbshopm());


//        shop detail
        shopname = findViewById(R.id.shopname);
        service = findViewById(R.id.service);

        shopname.setText(MyPrefrence.getbshopname());
        service.setText(MyPrefrence.getbservice());


//        shop address
        shopnumber = findViewById(R.id.shopnumber);
        shopadd = findViewById(R.id.shopadd);


        shopnumber.setText(MyPrefrence.getbshopnumber());
        shopadd.setText(MyPrefrence.getbshopadd());


//        button
        pasnaledit = findViewById(R.id.pasnaledit);
        contecedit = findViewById(R.id.contecedit);
        shopdedit = findViewById(R.id.shopdedit);
        shopaddedit = findViewById(R.id.shopaddedit);
        imgedit = findViewById(R.id.imgedit);
        otheredit = findViewById(R.id.otheredit);

        more = findViewById(R.id.more);



        pasnaledit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusinessProfile.this, EditPasnalDetail.class));
                finish();
            }
        });

        contecedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusinessProfile.this, EditContectDetail.class));
                finish();

            }
        });

        shopdedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusinessProfile.this, EditShopDetail.class));
                finish();

            }
        });

        shopaddedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusinessProfile.this, EditShopAddDetail.class));
                finish();

            }
        });

        imgedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusinessProfile.this, EditImgDetail.class));
                finish();

            }
        });

        otheredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BusinessProfile.this, EditOtherBranchDetail.class));
                finish();
            }
        });


        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(BusinessProfile.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.logout_update, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {


                        if (item.getItemId() == R.id.updatepass) {
                            startActivity(new Intent(BusinessProfile.this, UpdatePassActivity.class));
                        }
                        if (item.getItemId() == R.id.logout) {

                            MyPrefrence.setLogin(false);
                            startActivity(new Intent(BusinessProfile.this, LoginActivity.class));
                            finish();
                        }
                        return false;
                    }
                });


                popupMenu.show();

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


    }
}
