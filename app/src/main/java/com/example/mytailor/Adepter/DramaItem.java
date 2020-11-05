package com.example.mytailor.Adepter;

public class DramaItem {

    public String id,fname,sname;

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

    public DramaItem(String id, String fname, String sname) {
        this.id = id;
        this.fname = fname;
        this.sname = sname;
    }
}
