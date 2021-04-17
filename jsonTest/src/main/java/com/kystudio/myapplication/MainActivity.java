package com.kystudio.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonData = "[{\"name\":\"kylin\",\"age\":20},{\"name\":\"yuan\",\"age\":21}]";
        String jsonData1 = "{\"name\":\"tom\",\"age\":23}";
        
        parseJson(jsonData);

        parseFromJson(jsonData);
        parseFromJson1(jsonData1);
    }

    private void parseJson(String jsonData){
        JsonReader reader = new JsonReader(new StringReader(jsonData));
        try {
            reader.beginArray();
            while (reader.hasNext()){
                reader.beginObject();
                while (reader.hasNext()){
                    String tagName = reader.nextName();
                    if (tagName.equals("name")){
                        System.out.println("name-->" + reader.nextString());
                    }else if (tagName.equals("age")){
                        System.out.println("age-->" + reader.nextInt());
                    }
                }
                reader.endObject();
            }
            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseFromJson(String jsonData){
        Type listType = new TypeToken<LinkedList<User>>(){}.getType();
        Gson gson = new Gson();
        LinkedList<User> users = gson.fromJson(jsonData,listType);

        for(Iterator iterator = users.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();
            System.out.println("fromJson:user-->" + user);
        }
    }

    private void parseFromJson1(String jsonData){
        Gson gson = new Gson();
        User user = gson.fromJson(jsonData,User.class);
        System.out.println("fromJson1:user-->" + user);
    }

}
