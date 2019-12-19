package com.example.kidsgametimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<ActivityItemList> activityItemListList;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createItemToList();
        buildRecyclerView();

        // Add user to the list
       /* buttonInsert = (Button) findViewById(R.id.addUserButton);
        editTextInsert = (EditText) findViewById(R.id.editName);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                String name = editTextInsert.getText().toString();
                addItem(position, name);
            }
        });
*/
        //buttonRemove = findViewById();
    }

    public void addItem(int position, String name) {
        activityItemListList = new ArrayList<>();
        activityItemListList.add(position, new ActivityItemList(position +": Name: " + name, "Is playing now."));
        adapter.notifyItemChanged(position,name);
    }

    private void createItemToList() {
        activityItemListList = new ArrayList<>();

       /* for (int i = 0; i < 5; i++) {
            ActivityItemList activityItemList = new ActivityItemList(
                    "Kid nr. " + (i + 1),
                    "Is playing now.");

            activityItemListList.add(activityItemList);
        }*/

        activityItemListList.add(new ActivityItemList("Kid 1", "Is playing now."));
        activityItemListList.add(new ActivityItemList("Kid 2", "Is playing now."));
        activityItemListList.add(new ActivityItemList("Kid 3", "Is playing now."));
    }

    private void buildRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.activity_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ActivityItemAdapter(activityItemListList, this);
        recyclerView.setAdapter(adapter);
    }

    public void resetTimer(View view) {
        Toast.makeText(this, "Timer is set to 10 min.", Toast.LENGTH_LONG).show();
        TextView timerView = (TextView) findViewById(R.id.timerButton);
        timerView.setText("00:10");
    }

    public void addNewUserName(View view) {
        int position = Integer.parseInt(editTextInsert.getText().toString());
        String name = editTextInsert.getText().toString();
        addItem(position, name);
    }
}
