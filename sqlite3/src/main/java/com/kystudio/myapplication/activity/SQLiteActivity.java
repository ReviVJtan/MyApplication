package com.kystudio.myapplication.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kystudio.myapplication.R;
import com.kystudio.myapplication.db.DatabaseHelper;

public class SQLiteActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
    }

    public void onCreateClick(View view) {
        String dbName = "test_kylin_db";
        dbHelper = new DatabaseHelper(SQLiteActivity.this, dbName);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
    }

    public void onUpdateClick(View view) {
        String dbName = "test_kylin_db";
        dbHelper = new DatabaseHelper(SQLiteActivity.this, dbName, 2);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
    }

    public void onInsertClick(View view) {
        ContentValues values = new ContentValues();
        values.put("id", 1);
        values.put("name", "kylin");

        String dbName = "test_kylin_db";
        dbHelper = new DatabaseHelper(SQLiteActivity.this, dbName, 2);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert("user", null, values);
    }

    public void onUpdateRecordClick(View view) {
        String dbName = "test_kylin_db";
        dbHelper = new DatabaseHelper(SQLiteActivity.this, dbName, 2);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "kystudio");

        db.update("user", values, "id=?", new String[]{"1"});
    }

    public void onQueryClick(View view) {
        String dbName = "test_kylin_db";
        dbHelper = new DatabaseHelper(SQLiteActivity.this, dbName, 2);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query("user", new String[]{"id", "name"}, "id=?", new String[]{"1"}, null, null, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            System.out.println("query--->" + name);
        }

    }
}
