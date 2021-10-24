package com.example.farm;


public class ListViewItem {
    private String potID;
    private String nameStr;

    public void setNameStr(String name) {
        nameStr = name;
    }
    public void setIdStr(String id) {
        potID = id;
    }

    public String getNameStr() {
        return this.nameStr;
    }
    public String getIdStr() {
        return this.potID;
    }
}
