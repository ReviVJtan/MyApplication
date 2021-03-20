package com.kystudio.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        Thread d1 = new DownloadTxtThread();
        d1.start();
    }

    public void onDownloadOtherFileClick(View view) {
        Thread d2 = new DownloadOtherFileThread();
        d2.start();
    }

    class DownloadTxtThread extends Thread {

        @Override
        public void run() {
            httpDownloader = new HttpDownloader();
            String url = "http://172.28.19.115:8080/txt/myfile.txt";
            String lrc = httpDownloader.downloadTxt(url);
            System.out.println("txt:" + lrc);
        }
    }

    class DownloadOtherFileThread extends Thread {

        @Override
        public void run() {
            httpDownloader = new HttpDownloader();
            String url = "http://172.28.19.115:8080/mp3/a1.mp3";
            int result = httpDownloader.downloadFile(url, "kylin_test", "a1.mp3");
            if (1 == result) {
                System.out.println("mp3:下载成功！");
            } else if (0 == result) {
                System.out.println("mp3:文件已存在！");
            } else if (-1 == result) {
                System.out.println("mp3:文件不存在！");
            }

        }
    }
}
