package com.ylf.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button firstButton;
    private Handler handler;

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

        firstButton = (Button) findViewById(R.id.firstButton);
        firstButton.setOnClickListener(new MyBtnListener());

        WorkThread wt = new WorkThread();
        wt.start();
    }

    class MyBtnListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            System.out.println("onClick:" + Thread.currentThread().getName());
            Message msg = handler.obtainMessage();
            handler.sendMessage(msg);
        }
    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            // 准备Looer对象
            Looper.prepare();
            // 在WorkerThread当中生成一个Handler对象
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    System.out.println("handleMessage:"+Thread.currentThread().getName());
                    System.out.println("收到了消息对象！");
                }
            };
            // 调用Looper的loop()方法之后，Looper对象将不断的从消息队列当中取出消息对象，然后调用handler的handleMessage()方法，处理该消息对象
            // 如果消息队列当中没有对象，则线程阻塞。
            Looper.loop();
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
}
