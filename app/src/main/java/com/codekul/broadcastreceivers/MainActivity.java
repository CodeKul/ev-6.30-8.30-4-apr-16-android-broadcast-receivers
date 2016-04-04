package com.codekul.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();
        //filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        filter.addAction("com.codekul.my.broadcast");
        registerReceiver(new MyReceiver(), filter);

        findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBroadcast = new Intent("com.codekul.my.broadcast");
                sendBroadcast(intentBroadcast);
            }
        });

        IntentFilter filterBattery = new IntentFilter();
        filterBattery.addAction(Intent.ACTION_BATTERY_CHANGED);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                int level = intent.getIntExtra("level", 0);
                Log.i("@codekul", " Level is 1 " + level);

            }
        }, filterBattery);

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                int level = intent.getIntExtra("level", 0);
                Log.i("@codekul", " Level is 2 " + level);

            }
        }, filterBattery);
    }
}
