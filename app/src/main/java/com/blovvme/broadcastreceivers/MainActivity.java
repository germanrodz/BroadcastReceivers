package com.blovvme.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    MyDynamicReceiver dynamicReceiver = new MyDynamicReceiver();
    IntentFilter intentFilter;
    EditText etText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText = (EditText) findViewById(R.id.etText);
    }

    public void sendBroadcast(View view) {
        switch (view.getId()){
            case R.id.btnSendStatic:
                Intent intent = new Intent();
                intent.setAction("MyAction");
                sendBroadcast(intent);
                break;
            case R.id.btnSendStatic2:
                Intent intent1 = new Intent();
                intent1.setAction("MyAction2");
                sendBroadcast(intent1);
                break;
            case R.id.btnSendDynamic:
                Intent intent2 = new Intent();
                intent2.setAction("doSomething");
                sendBroadcast(intent2);
                break;
            case R.id.btnBroadcast:
                Intent intent3 = new Intent();
                intent3.setAction("doSomething");
                intent3.putExtra("send",etText.getText().toString());
                Log.d(TAG, "sendBroadcast: " + etText.getText().toString());
                sendBroadcast(intent3);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        intentFilter =  new IntentFilter();
        intentFilter.addAction("doSomething");
        registerReceiver(dynamicReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //unregisterReceiver(dynamicReceiver);
    }
}