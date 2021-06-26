package com.example.sysrestestclient;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class MainClientActivity extends AppCompatActivity {
    private static final String TAG = "MainClientActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent("com.example.sysrestestserver.MainServerActivity.AlarmListener");
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + 5, pi);
    }
}
