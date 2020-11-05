package com.example.mytailor;

import android.app.Application;
import android.content.SharedPreferences;

public class MyPrefrence extends Application {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;


    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = getSharedPreferences("my", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    //    user name phone email pass buss login
    public static void setname(String name) {
        editor.putString("name", name).commit();
    }

    public static String getname() {
        return sharedPreferences.getString("name", "");
    }


    public static void setphone(String phone) {
        editor.putString("phone", phone).commit();
    }

    public static String getphone() {
        return sharedPreferences.getString("phone", "");
    }


    public static void setemail(String email) {
        editor.putString("email", email).commit();
    }

    public static String getemail() {
        return sharedPreferences.getString("email", "");
    }


    public static void setpass(String pass) {
        editor.putString("pass", pass).commit();
    }

    public static String getpass() {
        return sharedPreferences.getString("pass", "");
    }

    //    btn and status login page new buss login
    public static void setStatus(boolean status) {
        editor.putBoolean("status", status).commit();
    }

    public static boolean getStatus() {
        boolean b = sharedPreferences.getBoolean("status", false);
        return b;
    }

    public static void setLogin(boolean login) {
        editor.putBoolean("home", login).commit();
    }

    public static boolean getLogin() {
        return sharedPreferences.getBoolean("home", false);

    }

    //    uid in user
    public static void setuid(String uid) {
        editor.putString("uid", uid).commit();
    }

    public static String getuid() {
        return sharedPreferences.getString("uid", "");
    }


    //new user login mobile user
    public static void setulogin(boolean ulogin) {
        editor.putBoolean("ulogin", ulogin).commit();
    }

    public static boolean getulogin() {
        return sharedPreferences.getBoolean("ulogin", false);
    }

    public static void setuedit(boolean uedit) {
        editor.putBoolean("uedit", uedit).commit();
    }

    public static boolean getuedit() {
        return sharedPreferences.getBoolean("uedit", false);
    }


    public static void setuname(String uname) {
        editor.putString("uname", uname).commit();
    }

    public static String getuname() {
        return sharedPreferences.getString("uname", "");
    }

    public static void setuEmail(String uEmail) {
        editor.putString("uEmail", uEmail).commit();
    }

    public static String getuEmail() {
        return sharedPreferences.getString("uEmail", "");
    }

    public static void setuphone(String uphone) {
        editor.putString("uphone", uphone).commit();
    }

    public static String getuphone() {
        return sharedPreferences.getString("uphone", "");
    }


//new busness start all
//    pasnal details

    public static void setpasnal(boolean bpasnal) {
        editor.putBoolean("bpasnal", bpasnal).commit();
    }

    public static boolean getpasnal() {
        return sharedPreferences.getBoolean("bpasnal", false);
    }


    public static void setbfname(String bfname) {
        editor.putString("bfname", bfname).commit();
    }

    public static String getbfname() {
        return sharedPreferences.getString("bfname", "");
    }


    public static void setbsname(String bsname) {
        editor.putString("bsname", bsname).commit();
    }

    public static String getbsname() {
        return sharedPreferences.getString("bsname", "");
    }

    public static void setbpasnalnumber(String bpasnalnumber) {
        editor.putString("bpasnalnumber", bpasnalnumber).commit();
    }

    public static String getbpasnalnumber() {
        return sharedPreferences.getString("bpasnalnumber", "");
    }

    //new buss start contect details
    public static void setbcontec(boolean bcontect) {
        editor.putBoolean("bcontect", bcontect).commit();
    }

    public static boolean getbcontect() {
        return sharedPreferences.getBoolean("bcontect", false);
    }


    public static void setbemail(String bemail) {
        editor.putString("bemail", bemail).commit();
    }

    public static String getbemail() {
        return sharedPreferences.getString("bemail", "");
    }


    public static void setbwhatsno(String bwhatsno) {
        editor.putString("bwhatsno", bwhatsno).commit();
    }

    public static String getbwhatsno() {
        return sharedPreferences.getString("bwhatsno", "");
    }

    public static void setbshopm(String bshopm) {
        editor.putString("bshopm", bshopm).commit();
    }

    public static String getbshopm() {
        return sharedPreferences.getString("bshopm", "");

    }
//    new buss shop details

    public static void setbshopd(boolean bshopd) {
        editor.putBoolean("bshopd", bshopd).commit();
    }

    public static boolean getbshopd() {
        return sharedPreferences.getBoolean("bshopd", false);
    }

    public static void setbshopname(String bshopname) {
        editor.putString("bshopname", bshopname).commit();
    }

    public static String getbshopname() {
        return sharedPreferences.getString("bshopname", "");
    }



    public static void setbservice(String bservice) {
        editor.putString("bservice", bservice).commit();
    }

    public static String getbservice() {
        return sharedPreferences.getString("bservice", "");
    }

//new buss start shopadrees

    public static void setbshopaddress(boolean bshopadsress) {
        editor.putBoolean("bshopadsress", bshopadsress).commit();
    }

    public static boolean getbshopaddres() {
        return sharedPreferences.getBoolean("bshopadsress", false);
    }

    public static void setbshopnumber(String bshopnumber) {
        editor.putString("bshopnumber", bshopnumber).commit();
    }

    public static String getbshopnumber() {
        return sharedPreferences.getString("bshopnumber", "");
    }


    public static void setbshopadd(String bshopadd) {
        editor.putString("bshopadd", bshopadd).commit();
    }

    public static String getbshopadd() {
        return sharedPreferences.getString("bshopadd", "");
    }


//    new buss other branch

    public static void setbother(boolean bother) {
        editor.putBoolean("bother", bother).commit();
    }

    public static boolean getbother() {
        return sharedPreferences.getBoolean("bother", false);
    }

    public static void setobshopname(String obshopname) {
        editor.putString("obshopname", obshopname).commit();
    }

    public static String getobshopname() {
        return sharedPreferences.getString("obshopname", "");
    }

    public static void setobshopphone(String obshopphone) {
        editor.putString("obshopphone", obshopphone).commit();
    }

    public static String getobshopphone() {
        return sharedPreferences.getString("obshopphone", "");
    }

    public static void setobshopnumber(String obshopnumber) {
        editor.putString("obshopnumber", obshopnumber).commit();
    }

    public static String getobshopnumber() {
        return sharedPreferences.getString("obshopnumber", "");
    }

    public static void setobshopadd(String obshopadd) {
        editor.putString("obshopadd", obshopadd).commit();
    }

    public static String getobshopadd() {
        return sharedPreferences.getString("obshopadd", "");
    }

    public static void setobshopopp(String obshopopp) {
        editor.putString("obshopopp", obshopopp).commit();
    }

    public static String getobshopopp() {
        return sharedPreferences.getString("obshopopp", "");
    }

    public static void setobshoparea(String obshoparea) {
        editor.putString("obshoparea", obshoparea).commit();
    }

    public static String getobshoparea() {
        return sharedPreferences.getString("obshoparea", "");
    }

    public static void setobshopcity(String obshopcity) {
        editor.putString("obshopcity", obshopcity).commit();
    }

    public static String getobshopcity() {
        return sharedPreferences.getString("obshopcity", "");
    }

    public static void setobshopstate(String obshopstate) {
        editor.putString("obshopstate", obshopstate).commit();
    }

    public static String getobshopstate() {
        return sharedPreferences.getString("obshopstate", "");
    }

    public static void setobshoppincode(String obshoppincode) {
        editor.putString("obshoppincode", obshoppincode).commit();
    }

    public static String getobshoppincode() {
        return sharedPreferences.getString("obshoppincode", "");
    }

    //        new buss start and button visible add btn
    public static void setaddbtn(boolean addbtn) {
        editor.putBoolean("addbtn", addbtn).commit();
    }

    public static boolean getaddbtn() {
        return sharedPreferences.getBoolean("addbtn", false);

    }


    //    Tailor type in school name activie
    public static void setschollname(boolean schollname) {
        editor.putBoolean("busname", schollname).commit();
    }

    public static boolean getschollname() {
        return sharedPreferences.getBoolean("schollname", false);

    }

    /*Tailor typr*/

    public static void setboytailor(boolean boytailor) {
        editor.putBoolean("boytailor", boytailor).commit();
    }

    public static boolean getboytailor() {
        return sharedPreferences.getBoolean("boytailor", false);
    }

    public static void setgirltailor(boolean girltailor) {
        editor.putBoolean("girltailor", girltailor).commit();
    }

    public static boolean getgirltailor() {
        return sharedPreferences.getBoolean("girltailor", false);
    }

    public static void setbrant(boolean brant) {
        editor.putBoolean("brant", brant).commit();
    }

    public static boolean getbrant() {
        return sharedPreferences.getBoolean("brant", false);
    }

    public static void setgrant(boolean grant) {
        editor.putBoolean("grant", grant).commit();
    }

    public static boolean getgrant() {
        return sharedPreferences.getBoolean("grant", false);
    }

    public static void setschoolshop(boolean schoolshop) {
        editor.putBoolean("schoolshop", schoolshop).commit();
    }

    public static boolean getschoolshop() {
        return sharedPreferences.getBoolean("schoolshop", false);
    }

    public static void setdramashop(boolean dramashop) {
        editor.putBoolean("dramashop", dramashop).commit();
    }

    public static boolean getdramashop() {
        return sharedPreferences.getBoolean("dramashop", false);
    }


}