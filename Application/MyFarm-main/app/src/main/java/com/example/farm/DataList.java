package com.example.farm;

public class DataList {

    private String[] mData;

    public DataList(String[] data)
    {
        mData = data;
    }

    public DataList(String potID, float potGHUM, float potATEMP, float potAHUM, boolean potWCON, boolean potVCON, String userID)
    {
        mData = new String[7];
        mData[0] = potID;
        mData[1] = potGHUM + "";
        mData[2] = potATEMP + "";
        mData[3] = potAHUM + "";
        mData[4] = potWCON + "";
        mData[5] = potVCON + "";
        mData[6] = userID;
    }

    public String[] getData()
    {
        return mData;
    }

    public String getData(int index)
    {
        return mData[index];
    }

    public void setData(String[] data)
    {
        mData = data;
    }
}