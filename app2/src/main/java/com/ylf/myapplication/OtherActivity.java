package com.ylf.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class OtherActivity extends AppCompatActivity {
    private Button firstBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
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

        firstBtn = (Button)findViewById(R.id.firstBtn);
        firstBtn.setOnClickListener(new MyButtonListener());

        System.out.println("OtherActivity:onCreate");
    }

    class MyButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(OtherActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("OtherActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("OtherActivity:onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("OtherActivity:onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("OtherActivity:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("OtherActivity:onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("OtherActivity:onDestroy");
    }

}
