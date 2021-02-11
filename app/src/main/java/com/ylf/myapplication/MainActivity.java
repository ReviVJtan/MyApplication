package com.ylf.myapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private Switch wifiSwitch;

    private CheckBox checkAll;
    private CheckBox eatBox;
    private CheckBox sleepBox;
    private CheckBox dotaBox;

    private TimePicker firstTimePicker;
    private Button getTimeBtn;
    private DatePicker firstDatePicker;
    private Button getDateBtn;

    private ProgressBar progressBar;
    private Button firstBtn, secondBtn;

    private SeekBar firstSeekBar;
    private Button thirdBtn;
    private int i;

    private RatingBar firstRatingBar;
    private Button fourthBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*
        wifiSwitch = (Switch) findViewById(R.id.switch1);

        boolean wifiEnabled = isWifiConnected(this);
        if (wifiEnabled) {
            wifiSwitch.setChecked(true);
        } else {
            wifiSwitch.setChecked(false);
        }
        //-----------------------------------------------
        checkAll = (CheckBox) findViewById(R.id.checkAll);
        eatBox = (CheckBox) findViewById(R.id.eatBox);
        sleepBox = (CheckBox) findViewById(R.id.sleepBox);
        dotaBox = (CheckBox) findViewById(R.id.dotaBox);

        checkAll.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        eatBox.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        sleepBox.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        dotaBox.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //-----------------------------------------------
        firstTimePicker = (TimePicker) findViewById(R.id.firstTimePicker);
        getTimeBtn =(Button)findViewById(R.id.getTimeBtn);
        firstTimePicker.setIs24HourView(true);

        firstTimePicker.setOnTimeChangedListener(new TimeListener());
        getTimeBtn.setOnClickListener(new GetTimeClickListener());
        //-----------------------------------------------
        firstDatePicker = (DatePicker) findViewById(R.id.datePicker);
        firstDatePicker.updateDate(2015, 10, 12);
        getDateBtn = (Button) findViewById(R.id.getDateBtn);

        getDateBtn.setOnClickListener(new GetDateClickListener());
        //-----------------------------------------------
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        firstBtn = (Button) findViewById(R.id.firstBtn);
        secondBtn = (Button) findViewById(R.id.secondBtn);
        
        firstBtn.setOnClickListener(new MyButtonListener());
        secondBtn.setOnClickListener(new MyButtonListener());
        //-----------------------------------------------
        firstSeekBar = (SeekBar) findViewById(R.id.firstSeekBar);
        thirdBtn = (Button) findViewById(R.id.thirdBtn);
        firstSeekBar.setProgress(30);
        firstSeekBar.setSecondaryProgress(40);
        firstSeekBar.setOnSeekBarChangeListener(new MySeekBarListener());
        thirdBtn.setOnClickListener(new MyButtonListener());
        */
        firstRatingBar = (RatingBar) findViewById(R.id.firstRatingBar);
        fourthBtn = (Button) findViewById(R.id.fourthBtn);
        firstRatingBar.setOnRatingBarChangeListener(new RatingBarListener());
        fourthBtn.setOnClickListener(new MyButtonListener());
    }

    class RatingBarListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            System.out.println("rating:" + rating + ",fromUser:" + fromUser);
        }
    }

    class MySeekBarListener implements SeekBar.OnSeekBarChangeListener {
        /**
         * @param seekBar
         * @param progress
         * @param fromUser
         */
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Toast.makeText(getApplicationContext(), "progress:" + progress + ",fromUser:" + fromUser, Toast.LENGTH_SHORT).show();
            System.out.println("progress:" + progress + ",fromUser:" + fromUser);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
            System.out.println("onStart");
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
            System.out.println("onStop");
        }
    }

    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.firstBtn) {
                progressBar.incrementProgressBy(10);
            } else if (v.getId() == R.id.secondBtn) {
                progressBar.incrementSecondaryProgressBy(20);
            } else if (v.getId() == R.id.thirdBtn) {
                i = firstSeekBar.getProgress();
                i += 10;
                firstSeekBar.setProgress(i);
                firstSeekBar.setSecondaryProgress(i + 10);
            } else if (v.getId() == R.id.fourthBtn) {
                firstRatingBar.setRating(firstRatingBar.getRating() + 1.0f);
            }
        }
    }

    class GetDateClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int year = firstDatePicker.getYear();
            int month = firstDatePicker.getMonth() + 1;
            int day = firstDatePicker.getDayOfMonth();

            //System.out.println("year:" + year + ",month:" + month+ ",day:" + day);
            Toast.makeText(getApplicationContext(), "year:" + year + ",month:" + month + ",day:" + day, Toast.LENGTH_SHORT).show();
        }
    }

    class GetTimeClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int hour = firstTimePicker.getCurrentHour();
            int minute = firstTimePicker.getCurrentMinute();

            //System.out.println("Hour:"+hour+",minute:"+minute);
            Toast.makeText(getApplicationContext(), hour + "点" + minute + "分", Toast.LENGTH_SHORT).show();
        }
    }

    class TimeListener implements TimePicker.OnTimeChangedListener {
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            //System.out.println("Hour:" + hourOfDay + ",minute:" + minute);
            Toast.makeText(getApplicationContext(), "Hour:" + hourOfDay + ",minute:" + minute, Toast.LENGTH_SHORT).show();
        }
    }

    class MyOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.getId() == R.id.checkAll) {
                if (buttonView.isChecked()) {
                    eatBox.setChecked(true);
                    sleepBox.setChecked(true);
                    dotaBox.setChecked(true);
                    Toast.makeText(getApplicationContext(), "全选", Toast.LENGTH_SHORT).show();
                } else {
                    eatBox.setChecked(false);
                    sleepBox.setChecked(false);
                    dotaBox.setChecked(false);
                    Toast.makeText(getApplicationContext(), "反选", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void switchWifiClickHandler(View view) {
        WifiManager wifiManager = (WifiManager) super.getSystemService(Context.WIFI_SERVICE);
        if (WifiManager.WIFI_STATE_ENABLED == wifiManager.getWifiState()) {
            wifiManager.setWifiEnabled(false);
            Toast.makeText(this, "wifi关闭！", Toast.LENGTH_SHORT).show();
            wifiSwitch.setChecked(false);
        } else if (WifiManager.WIFI_STATE_DISABLED == wifiManager.getWifiState()) {
            wifiManager.setWifiEnabled(true);
            Toast.makeText(this, "wifi开启！", Toast.LENGTH_SHORT).show();
            wifiSwitch.setChecked(true);
        }
    }

    /**
     * 判断是否有网络连接
     *
     * @param context
     * @return
     */
    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断WIFI网络是否可用
     *
     * @param context
     * @return
     */
    public boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断MOBILE网络是否可用
     *
     * @param context
     * @return
     */
    public boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断网络类型
     *
     * @param context
     * @return -1：没有网络 1：WIFI网络 2：wap网络 3：net网络
     */
    public static int GetNetworkType(Context context) {
        int networkType = -1;
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo == null) {
            return networkType;
        }
        int nType = networkInfo.getType();
        if (nType == ConnectivityManager.TYPE_MOBILE) {
            if (networkInfo.getExtraInfo().toLowerCase().equals("cmnet")) {
                networkType = 3;
            } else {
                networkType = 2;
            }
        } else if (nType == ConnectivityManager.TYPE_WIFI) {
            networkType = 1;
        }
        return networkType;
    }
}
