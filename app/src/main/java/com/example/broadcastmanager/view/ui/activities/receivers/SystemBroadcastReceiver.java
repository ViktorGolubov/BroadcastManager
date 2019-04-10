package com.example.broadcastmanager.view.ui.activities.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class SystemBroadcastReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        String message = "";
        switch (intent.getAction()) {
            case Intent.ACTION_POWER_CONNECTED:
                message = "Power connected!";
                break;
            case Intent.ACTION_BATTERY_LOW:
                message = "Battery low!";
                break;
                default:
        }

        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();

    }


}
