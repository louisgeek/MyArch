package com.louisgeek.myarch;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.louisgeek.myarch.db.MyDatabase;
import com.louisgeek.myarch.image.ImageLoaderFactory;
import com.louisgeek.myarch.json.JsonParserFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Room.databaseBuilder(this, MyDatabase.class,"myDatabase").build();
    }
}
