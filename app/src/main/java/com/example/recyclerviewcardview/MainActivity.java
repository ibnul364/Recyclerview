package com.example.recyclerviewcardview;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView1;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Recycler and Card View Demo");

                //This is for Cardview
        recyclerView1 = findViewById(R.id.recyclerView);
//        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        adapter = new myadapter(dataQueue());
        recyclerView1.setAdapter(adapter);

        //This is for HorizontalLayout
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //recyclerView1.setLayoutManager(layoutManager);

        //This is for GridLayout
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView1.setLayoutManager(layoutManager);


    }

    public ArrayList<Model> dataQueue()

    {

        ArrayList<Model> holder = new ArrayList<>();

        Model ob1 = new Model();
//        Log.d(TAG,"not found");
        ob1.setHeader("C Programming");
        ob1.setDesc("Desktop Programming");
        ob1.setImg(R.drawable.ggravity);
        holder.add(ob1);

        Model obj2 = new Model();
        obj2.setHeader("C++ Programming");
        obj2.setDesc("Desktop Programming");
        obj2.setImg(R.drawable.ggravity);
        holder.add(obj2);


        Model obj3 = new Model();
        obj3.setHeader("Java Programming");
        obj3.setDesc("Desktop Programming");
        obj3.setImg(R.drawable.ggravity);
        holder.add(obj3);

        Model obj4 = new Model();
        obj4.setHeader("Python Programming");
        obj4.setDesc("Desktop Programming");
        obj4.setImg(R.drawable.ggravity);
        holder.add(obj4);


        Model obj5 = new Model();
        obj5.setHeader("Php Programming");
        obj5.setDesc("Desktop Programming");
        obj5.setImg(R.drawable.ggravity);
        holder.add(obj5);


        Model obj6 = new Model();
        obj6.setHeader("Javascript Programming");
        obj6.setDesc("Desktop Programming");
        obj6.setImg(R.drawable.ggravity);
        holder.add(obj6);

        Model obj7 = new Model();
        obj7.setHeader("Ruby Programming");
        obj7.setDesc("Desktop Programming");
        obj7.setImg(R.drawable.ggravity);
        holder.add(obj7);


        Model obj8 = new Model();
        obj8.setHeader("Dart Programming");
        obj8.setDesc("Desktop Programming");
        obj8.setImg(R.drawable.ggravity);
        holder.add(obj8);

        return holder;


    }


}