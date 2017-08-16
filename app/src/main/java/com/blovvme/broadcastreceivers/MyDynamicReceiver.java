package com.blovvme.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyDynamicReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        intent.getStringExtra("send");
        Toast.makeText(context, "I am Dynamic", Toast.LENGTH_SHORT).show();
    }
}
