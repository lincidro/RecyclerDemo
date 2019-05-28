package com.roll.recyclerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> textosArray;
    private ArrayList<String> datesArray;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();
    }

    void initVars(){
        textosArray = new ArrayList<>();
        datesArray = new ArrayList<>();
        populateTextosArray();
        initRecycler();
    }

    void initRecycler(){
        recyclerView = findViewById(R.id.recycler_view);
        recyclerAdapter = new RecyclerViewAdapter(this,textosArray,datesArray);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void populateTextosArray(){

        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        for (int i=0;i<15;i++){
            textosArray.add("Texto número "+i);
            datesArray.add(dateFormat.format(date));
        }
    }
}
