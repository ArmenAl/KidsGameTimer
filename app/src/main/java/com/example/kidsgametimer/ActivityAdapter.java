package com.example.kidsgametimer;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.time.LocalTime;
import java.util.ArrayList;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {
    private ArrayList<ActivityItem> mActivityItemList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClicked(int position);

        void onDeleteClicked(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ActivityViewHolder extends RecyclerView.ViewHolder {
        public ImageView mDeleteImage;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTimeView;
        public CardView mCardBackground;
        public CountDownTimer timer;

        public ActivityViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            mTextView1 = itemView.findViewById(R.id.itemHeading);
            mTextView2 = itemView.findViewById(R.id.itemDescription);
            mTimeView = itemView.findViewById(R.id.itemTimerView);
            mDeleteImage = itemView.findViewById(R.id.imageDelete);
            mCardBackground = itemView.findViewById(R.id.activityCard);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClicked(position);
                        }
                    }
                }
            });

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClicked(position);
                        }
                    }
                }
            });
        }
    }

    public ActivityAdapter(ArrayList<ActivityItem> activityItemList) {
        mActivityItemList = activityItemList;
    }

    @Override
    public ActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_list, parent, false);
        ActivityViewHolder evh = new ActivityViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(final ActivityViewHolder holder, int position) {
        ActivityItem currentItem = mActivityItemList.get(position);

        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());

        holder.mTimeView.setText("" + currentItem.getmTimer());
        holder.mCardBackground.setCardBackgroundColor(Color.parseColor("#FFB2FF59"));

        if (holder.timer != null) {
            holder.timer.cancel();
        }
        final long itemTimer = Long.parseLong("" + currentItem.getmTimer());

        holder.timer = new CountDownTimer(itemTimer, 1000) {

            public void onTick(long millisUntilFinished) {

                if (millisUntilFinished <= 60000) {
                    holder.mCardBackground.setCardBackgroundColor(Color.parseColor("#FFFFD740"));
                }
                    long seconds = (millisUntilFinished / 1000);
                    long minutes = (seconds / 60);
                    long hours = (minutes / 60);

                    String hour = String.format("%02d:", hours % 24);
                    String minute = String.format("%02d:", minutes % 60);
                    String second = String.format("%02d", seconds % 60);

                    String time = hour + minute + second;

                holder.mTimeView.setText(time);
            }

            public void onFinish() {
                holder.mCardBackground.setCardBackgroundColor(Color.parseColor("#FFFF5252"));
                holder.mTimeView.setText("00:00:00");
            }
        }.start();
    }

    @Override
    public int getItemCount() {
        return mActivityItemList.size();
    }
}
