package com.example.kidsgametimer;

public class ActivityItem {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public ActivityItem(int imageDeleteResource, String text1, String text2) {
        mImageResource = imageDeleteResource;
        mText1 = text1;
        mText2 = text2;
    }

    public void changeText1(String text){
        mText1 = text;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }
}
