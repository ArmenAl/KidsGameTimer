package com.example.kidsgametimer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    private ArrayList<ActivityItem> mActivityList;

    private RecyclerView mRecyclerView;
    private ActivityAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private EditText editTextInsert;
    private EditText timeInsert;
    private ImageView itemRemoveImage;

    private Button buttonAddTime;
    private Button buttonRemoveTime;
    private Button buttonResetTime;
    private EditText timerToSet;

    LocalTime setsTime = LocalTime.of(00, 10, 000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

        setButtons();

    }

    public void insertItem(int position, String insertedName, String insertTime) {
        mActivityList.add(new ActivityItem(R.id.imageDelete, insertedName, "Is playing now.", insertTime));
        mAdapter.notifyItemInserted(mActivityList.size() - 1);
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
        mActivityList.add(new ActivityItem(R.id.imageDelete, "Test1", "Is playing now.", "00:00:000"));
        mActivityList.add(new ActivityItem(R.id.imageDelete, "Test3", "Is playing now.", "00:00:000"));
        mActivityList.add(new ActivityItem(R.id.imageDelete, "Test5", "Is playing now.", "00:00:000"));
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
        timeInsert = findViewById(R.id.timerView);
        itemRemoveImage = findViewById(R.id.imageDelete);

        timerToSet = findViewById(R.id.timerView);
        buttonAddTime = findViewById(R.id.addTimeButton);
        buttonRemoveTime = findViewById(R.id.removeTimeButton);
        buttonResetTime = findViewById(R.id.resetButton);

        // Adds name to list
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insertedName = editTextInsert.getText().toString();
                //int position = editTextInsert.getText().toString();
                if (insertedName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        String insertName = editTextInsert.getText().toString();
                        String insertTime = timeInsert.getText().toString();
                        insertItem(mActivityList.size(), insertedName, insertTime);
                        editTextInsert.setText("");
                        buttonResetTime.callOnClick();
                    } catch (NumberFormatException e) {

                    }
                }
            }
        });

        // Adds time to timer
        buttonAddTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setsTime = setsTime.plusMinutes(1);
                timerToSet.setText(setsTime.format(DateTimeFormatter.ISO_TIME));

                Toast.makeText(getApplicationContext(), "1 Minute Added!", Toast.LENGTH_SHORT).show();
            }
        });

        // Removes time from timer
        buttonRemoveTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setsTime = setsTime.minusMinutes(1);
                timerToSet.setText(setsTime.format(DateTimeFormatter.ISO_TIME));
                Toast.makeText(getApplicationContext(), "1 Minute Removed!", Toast.LENGTH_SHORT).show();
            }
        });

        // Resets time
        buttonResetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setsTime = LocalTime.of(00, 10, 000);
                timerToSet.setText(setsTime.format(DateTimeFormatter.ISO_TIME));
                Toast.makeText(getApplicationContext(), "Time Is Set To 10 Minute's!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
