package com.kystudio.myapplication;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2, button3;
    private TextView textView;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        textView = (TextView) findViewById(R.id.textView);

        wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

        button1.setOnClickListener(new MyButtonListener());
        button2.setOnClickListener(new MyButtonListener());
        button3.setOnClickListener(new MyButtonListener());
    }

    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button:
                    if(!wifiManager.isWifiEnabled()) {
                        wifiManager.setWifiEnabled(true);
                        textView.setText("WIFI: " + wifiManager.getWifiState());
                    }
                case R.id.button2:
                    if(wifiManager.isWifiEnabled()) {
                        wifiManager.setWifiEnabled(false);
                        textView.setText("WIFI: " + wifiManager.getWifiState());
                    }
                case R.id.button3:
                    textView.setText("WIFI: " + wifiManager.getWifiState());
            }
        }
    }
}
