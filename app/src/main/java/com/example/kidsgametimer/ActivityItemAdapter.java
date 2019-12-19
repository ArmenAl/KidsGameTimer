package com.example.kidsgametimer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityItemAdapter extends RecyclerView.Adapter<ActivityItemAdapter.ViewHolder> {

    private List<ActivityItemList> activityItemLists;
    private Context context;

    public ActivityItemAdapter(List<ActivityItemList> itemsList, Context context) {
        this.activityItemLists = itemsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ActivityItemList activityItemList = activityItemLists.get(position);

        holder.textViewHeading.setText(activityItemList.getHeading());
        holder.textViewDescription.setText(activityItemList.getDescription());
    }

    @Override
    public int getItemCount() {
        return activityItemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHeading;
        public TextView textViewDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHeading = (TextView) itemView.findViewById(R.id.itemHeading);
            textViewDescription = (TextView) itemView.findViewById(R.id.itemDescription);
        }
    }
}
