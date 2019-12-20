package com.example.kidsgametimer;

import static android.graphics.Color.rgb;

public class ActivityItem {
    private int mImageResource;
    private String mText1;
    private String mText2;
    private String mTime;

    public ActivityItem(int imageDeleteResource, String text1, String text2, String time) {
        mImageResource = imageDeleteResource;
        mText1 = text1;
        mText2 = text2;
        mTime = time;
    }

    public void changeText1Text2(String text1, String text2) {
        mText1 = text1;
        mText2 = text2;
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

    public String getTime() {
        return mTime;
    }

}
