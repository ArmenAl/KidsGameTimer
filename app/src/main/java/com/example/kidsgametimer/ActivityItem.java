package com.example.kidsgametimer;

public class ActivityItem {
    private int mImageResource;
    private String mText1;
    private String mText2;
    private String mTimeText;
    private long mTimer;

    public ActivityItem(int imageDeleteResource, String text1, String text2, String timerText, long timer) {
        mImageResource = imageDeleteResource;
        mText1 = text1;
        mText2 = text2;
        mTimeText = timerText;
        mTimer = timer;
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

    public String getmTimerText() {
        return getmTimerText();
    }

    public long getmTimer() {
        return mTimer;
    }

}
