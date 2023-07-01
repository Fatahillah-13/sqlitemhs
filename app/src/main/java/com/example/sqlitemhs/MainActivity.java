package com.example.sqlitemhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbh;
    ListView listView;
    Button tblinput;

    ArrayList<String>list_item;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list_data);
        tblinput=findViewById(R.id.tombol_input);
        dbh=new DatabaseHelper(this);
        list_item= new ArrayList<>();

        Cursor cursor= dbh.baca_data();

        list_item.clear();
        while (cursor.moveToNext()){
            list_item.add(cursor.getString(0)+" "+cursor.getString(1));
        }
        adapter=new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list_item);
        listView.setAdapter(adapter);

        tblinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Input_Mhs.class);
                startActivity(intent);
            }
        });
    }
}