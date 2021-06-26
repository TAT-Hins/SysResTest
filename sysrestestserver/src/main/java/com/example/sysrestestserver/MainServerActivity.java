package com.example.sysrestestserver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.invoke.MethodType;

public class MainServerActivity extends AppCompatActivity {
    private static final String TAG = "MainServerActivity";

    private Button mClickButton;
    private TextView mTextView;
    private static int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_server);

        mTextView = findViewById(R.id.main_server_textview);
        mClickButton = findViewById(R.id.main_server_clickbutton);
        mClickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addText("Click " + (++clickCount) + " times!");
            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction(getApplication().getPackageName() + ".MainServerActivity.AlarmListener");
        registerReceiver(new AlarmListener(), filter);
    }

    private void addText(String msg) {
        double curTimeMs = SystemClock.elapsedRealtime() / 1000d;
        if (mTextView != null) {
            mTextView.append("[" + curTimeMs + "ms] " + msg + "\n");
        }
    }

    public class AlarmListener extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            String action = intent.getAction();
            addText("receive broadcast, action=" + action);
            if (action.equals(getApplication().getPackageName() + ".MainServerActivity.AlarmListener")) {
                Log.i(TAG, "receive dynamic broadcast successful!");
            } else {
                Log.e(TAG, "receive unexcepted broadcast!");
            }
        }
    }
}
