package com.example.kidsgametimer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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

        public ActivityViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.itemHeading);
            mTextView2 = itemView.findViewById(R.id.itemDescription);
            mTimeView = itemView.findViewById(R.id.itemTimer);
            mDeleteImage = itemView.findViewById(R.id.imageDelete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClicked(position);
                        }
                    }
                }
            });

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
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
    public void onBindViewHolder(ActivityViewHolder holder, int position) {
        ActivityItem currentItem = mActivityItemList.get(position);

        //holder.mDeleteImage.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
        holder.mTimeView.setText(currentItem.getTime());
    }

    @Override
    public int getItemCount() {
        return mActivityItemList.size();
    }
}
