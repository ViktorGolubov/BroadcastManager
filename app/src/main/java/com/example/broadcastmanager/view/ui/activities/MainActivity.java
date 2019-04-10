package com.example.broadcastmanager.view.ui.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.broadcastmanager.R;
import com.example.broadcastmanager.view.ui.activities.receivers.SystemBroadcastReceiver;

public class MainActivity extends AppCompatActivity {

    private SystemBroadcastReceiver mySystemReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout clRoot = findViewById(R.id.activity_main_cl_root);
        clRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customIntent = new Intent();
                customIntent.setAction("org.bts_netmind.CUSTOM_INTENT");
                sendBroadcast(customIntent);
            }
        });

        Button btnEnableReceiver = findViewById(R.id.activity_main_btn_enable_receiver);
        btnEnableReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySystemReceiver = new SystemBroadcastReceiver();
                registerReceiver(mySystemReceiver,
                        new IntentFilter(Intent.ACTION_BATTERY_LOW));
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mySystemReceiver);
    }
}
