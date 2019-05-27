package com.roll.recyclerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> textosArray;
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
        populateTextosArray();
        initRecycler();
    }

    void initRecycler(){
        recyclerView = findViewById(R.id.recycler_view);
        recyclerAdapter = new RecyclerViewAdapter(this,textosArray);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void populateTextosArray(){
        for (int i=0;i<15;i++){
            textosArray.add("Texto número "+i);
        }
    }
}
