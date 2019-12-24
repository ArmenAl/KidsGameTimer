package com.example.kidsgametimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    private ImageView clearResetEdit;
    private ImageView saveResetTime;
    private EditText hoursEdit;
    private EditText minutesEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setButtons();

        Toast.makeText(getApplicationContext(), "Timer Settings.", Toast.LENGTH_SHORT).show();
    }

    public void setButtons() {
        clearResetEdit = findViewById(R.id.clearResetTextBtn);
        saveResetTime = findViewById(R.id.saveResetBtn);
        hoursEdit = findViewById(R.id.hoursSetText);
        minutesEdit = findViewById(R.id.setMinutesText);

        clearResetEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hoursEdit.setText("00");
                minutesEdit.setText("00");
            }
        });

        saveResetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
