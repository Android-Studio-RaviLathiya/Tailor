package com.example.mytailor.Adepter;

public class CusmorItem {

    public String id,fname, sname, phone, height, weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


    public CusmorItem(String id, String fname, String sname, String phone, String height, String weight) {
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.phone = phone;
        this.height = height;
        this.weight = weight;
    }
}
