package com.example.kidsgametimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ActivityItem> mActivityList;

    private RecyclerView mRecyclerView;
    private ActivityAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private EditText editTextInsert;
    private ImageView itemRemoveImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

        setButtons();

    }

    public void insertItem(int position, String insertedName) {
        mActivityList.add(new ActivityItem(R.id.imageDelete, insertedName, "Is playing now."));
        mAdapter.notifyItemInserted(mActivityList.size()-1);
    }

    public void removeItem(int position) {
        mActivityList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text) {
        mActivityList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createExampleList() {
        mActivityList = new ArrayList<>();
        mActivityList.add(new ActivityItem(R.id.imageDelete, "Test1", "Is playing now."));
        mActivityList.add(new ActivityItem(R.id.imageDelete, "Test3", "Is playing now."));
        mActivityList.add(new ActivityItem(R.id.imageDelete, "Test5", "Is playing now."));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.activity_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ActivityAdapter(mActivityList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ActivityAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClicked(int position) {
                removeItem(position);
            }
        });
    }

    public void setButtons() {
        buttonInsert = findViewById(R.id.addUserButton);
        editTextInsert = findViewById(R.id.editName);
        itemRemoveImage = findViewById(R.id.imageDelete);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insertedName = editTextInsert.getText().toString();
                //int position = editTextInsert.getText().toString();
                if(insertedName.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Name!",Toast.LENGTH_SHORT).show();
                }else {
                    try{
                        String insertName = editTextInsert.getText().toString();
                        insertItem(mActivityList.size(),insertedName);
                        editTextInsert.setText("");
                    }catch (NumberFormatException e){

                    }
                }
            }
        });
    }
}
