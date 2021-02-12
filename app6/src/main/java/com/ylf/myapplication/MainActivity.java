package com.ylf.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView firstTextView;
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

        firstTextView = (TextView) findViewById(R.id.firstTextView);
        firstButton = (Button) findViewById(R.id.firstButton);
        handler = new MyHandler();
        firstButton.setOnClickListener(new MyButtonListener());
    }

    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Thread t = new NetworkThread();
            t.start();
        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            System.out.println("handlerMessage---->" + Thread.currentThread().getName());
            String str = (String) msg.obj;
            firstTextView.setText(str);
        }
    }

    class NetworkThread extends Thread {
        @Override
        public void run() {
            System.out.println("network---->" + Thread.currentThread().getName());
            // 模拟访问网络，所以当线程运行时，先休眠2秒。
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 从网络中获取的数据
            String str = "从网络当中获取的数据！";

            Message msg = handler.obtainMessage();
            // sendMessage()方法，无论是在主线程当中发送还是再WorkerThread当中发送，都是可以的。
            msg.obj = str;
            handler.sendMessage(msg);
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
