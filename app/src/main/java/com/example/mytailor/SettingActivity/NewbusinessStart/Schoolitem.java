package com.example.mytailor.SettingActivity.NewbusinessStart;

public class Schoolitem {

    public String id,Name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Schoolitem(String id, String name) {
        this.id = id;
        Name = name;
    }
}
