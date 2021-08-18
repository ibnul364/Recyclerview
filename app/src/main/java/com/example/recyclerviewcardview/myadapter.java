package com.example.recyclerviewcardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcardview.Model;

import java.util.ArrayList;

public class myadapter  extends RecyclerView.Adapter<myviewholder>{

    ArrayList<Model> data;

    public myadapter(ArrayList<Model> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cardview_recycler,parent,false);
        myviewholder holder = new myviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.t1.setText(data.get(position).getHeader());
        holder.t2.setText(data.get(position).getDesc());
        holder.img1.setImageResource(data.get(position).getImg());



    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
