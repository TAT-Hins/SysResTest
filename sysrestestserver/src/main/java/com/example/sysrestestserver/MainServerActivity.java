package com.example.sysrestestserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.invoke.MethodType;

public class MainServerActivity extends AppCompatActivity {

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
    }

    private void addText(String msg) {
        double curTimeMs = SystemClock.elapsedRealtime() / 1000d;
        if (mTextView != null) {
            mTextView.append("[" + curTimeMs + "ms] " + msg + "\n");
        }
    }
}
