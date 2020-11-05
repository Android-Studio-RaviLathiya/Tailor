package com.example.mytailor.SettingActivity.NewbusinessStart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mytailor.Activity.MainActivity;
import com.example.mytailor.MyPrefrence;
import com.example.mytailor.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;
import java.util.Locale;

public class ShopAddressDetail extends AppCompatActivity implements LocationListener {
    ImageView back;
    CheckBox addshop;
    RelativeLayout shopdetail;
    Button go;
    TextInputLayout shopnumber, shopaddress;
    LocationManager locationManager;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_address_detail);


        /*Auto time*/
        time = findViewById(R.id.time);
        new CountDownTimer(40000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("00:" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("Time Finish! Try Again");
            }
        }.start();


        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationEnabled();
        getLocation();


        back = findViewById(R.id.back);
        go = findViewById(R.id.go);
        shopnumber = findViewById(R.id.shopnumber);
        shopaddress = findViewById(R.id.shopaddress);


        if (MyPrefrence.getbshopaddres()) {
            shopnumber.getEditText().setText(MyPrefrence.getbshopnumber());
            shopaddress.getEditText().setText(MyPrefrence.getbshopadd());

        }


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String shopno = shopnumber.getEditText().getText().toString();
                String address = shopaddress.getEditText().getText().toString();


                if (shopno.equals("")) {
                    shopnumber.setError("Field Shop Number");
                } else if (address.equals("")) {
                    shopaddress.setError("Field Address");
                } else {

                    startActivity(new Intent(ShopAddressDetail.this, EditImage.class));

                    MyPrefrence.setbshopaddress(true);
                    if (MyPrefrence.getbshopaddres()) {
                        MyPrefrence.setbshopnumber(shopno);
                        MyPrefrence.setbshopadd(address);
                    }

                }


            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        addshop = findViewById(R.id.addshop);
        shopdetail = findViewById(R.id.shopdetail);

        addshop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (addshop.isChecked()) {
                    shopdetail.setVisibility(View.VISIBLE);
                } else {
                    shopdetail.setVisibility(View.GONE);
                }
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

    private void locationEnabled() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(ShopAddressDetail.this)
                    .setTitle("Enable GPS Service")
                    .setMessage("We need your GPS location to show Near Places around you.")
                    .setCancelable(false)
                    .setPositiveButton("Enable", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                }
                            })
                    .setNegativeButton("Cancel", null)
                    .show();
        }
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 5, (LocationListener) this);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        try {
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

//            cityname.getEditText().setText(addresses.get(0).getLocality());
//            statename.getEditText().setText(addresses.get(0).getAdminArea());
//            lcountry.setText(addresses.get(0).getCountryName());
//            pincode.getEditText().setText(addresses.get(0).getPostalCode());
            shopaddress.getEditText().setText(addresses.get(0).getAddressLine(0));

        } catch (Exception e) {
        }

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
