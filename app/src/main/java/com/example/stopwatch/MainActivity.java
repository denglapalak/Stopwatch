package com.example.stopwatch;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Button startButton, stopButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        resetButton = findViewById(R.id.resetButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startChronometer();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopChronometer();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetChronometer();
            }
        });
    }

    private void startChronometer() {
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();

        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        resetButton.setEnabled(true);
    }

    private void stopChronometer() {
        chronometer.stop();

        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    private void resetChronometer() {
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());

        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        resetButton.setEnabled(false);
    }
}
