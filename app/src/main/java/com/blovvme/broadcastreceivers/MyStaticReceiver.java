package com.blovvme.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyStaticReceiver extends BroadcastReceiver {

    private static final String TAG = "StaticBroadcast";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        switch (intent.getAction()){
            case "MyAction":
                Log.d(TAG, "onReceive: " + "MyAction");
                Toast.makeText(context, "MyAction ", Toast.LENGTH_SHORT).show();
                break;
            case "MyAction2":
                Log.d(TAG, "onReceive: " + "MyAction2");
                Toast.makeText(context, "MyAction2 ", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Log.d(TAG, "onReceive: " + "Airplane");
                Toast.makeText(context, "Airplane ", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}