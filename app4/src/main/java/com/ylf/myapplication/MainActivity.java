package com.ylf.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView myTextView;
    private ProgressBar myProgressBar;
    private Button myButton, myButton2;

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

        myTextView = (TextView) findViewById(R.id.myTextView);
        myButton = (Button) findViewById(R.id.myButton);
        myProgressBar = (ProgressBar) findViewById(R.id.myProgressBar);
        myButton2 = (Button) findViewById(R.id.myButton2);
        myButton.setOnClickListener(new MyButtonListener());
        myButton2.setOnClickListener(new MyButtonListener());
    }

    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.myButton:
                    Thread t = new MyThread();
                    t.start();
                    break;
                case R.id.myButton2:
                    Thread t1 = new MyThread1();
                    t1.start();
                    break;
                default:
                    break;
            }

        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myTextView.setText("Run");
        }
    }

    class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myProgressBar.setProgress(myProgressBar.getProgress() + 1);
            }
        }
    }
}
