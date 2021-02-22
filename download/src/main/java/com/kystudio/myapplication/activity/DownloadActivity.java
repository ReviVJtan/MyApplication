package com.kystudio.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kystudio.myapplication.R;
import com.kystudio.myapplication.utils.HttpDownloader;

public class DownloadActivity extends AppCompatActivity {
    private Button btn1, btn2;
    private HttpDownloader httpDownloader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
    }

    public void onDownloadTxtFileClick(View view) {
        httpDownloader = new HttpDownloader();
        String url = "";
        String lrc = httpDownloader.downloadTxt(url);
        System.out.println(lrc);
    }

    public void onDownloadOtherFileClick(View view) {
        httpDownloader = new HttpDownloader();
        String url = "";
        int result = httpDownloader.downloadFile(url, "kylin_test", "a1.mp3");
        System.out.println(result);
    }
}
