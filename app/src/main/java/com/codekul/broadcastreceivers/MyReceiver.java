package com.codekul.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {


        String action = intent.getAction();

        Toast.makeText(context,"Receiver Called ... action is -> "+action,Toast.LENGTH_LONG).show();

    }
}
