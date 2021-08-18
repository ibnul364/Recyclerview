package com.example.recyclerviewcardview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcardview.Model;

import java.util.ArrayList;

public class myadapter  extends RecyclerView.Adapter<myviewholder> implements Filterable
{

    ArrayList<Model> data;
    //backup copy of  arraylist
    ArrayList<Model> backup;
    Context context;

    public myadapter(ArrayList<Model> data,Context context) {
        this.data = data;
        this.context = context;
        backup = new ArrayList<> (data);
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

        final Model temp = data.get(position);

        holder.t1.setText(data.get(position).getHeader());
        holder.t2.setText(data.get(position).getDesc());
        holder.img1.setImageResource(data.get(position).getImg());

        holder.img1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainActivity2.class);
                intent.putExtra("imagename",temp.getImg());
                intent.putExtra("header",temp.getHeader());
                intent.putExtra("desc",temp.getDesc());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {



        return filter;
    }
    //Make an Anonymous inner Class

    Filter filter =  new Filter() {
        @Override //background Thread
        protected FilterResults performFiltering(CharSequence keyword) {

            //Here we will pass a keyword, keyword will check it in the array then pass it in the temporary array
            //now have to make a temporary array
            ArrayList<Model> filteredData = new ArrayList<>();

            if(keyword.toString().isEmpty()){
                filteredData.addAll(backup);

            }else{
                    for (Model obj : backup){
                        if(obj.getHeader().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                            filteredData.add(obj);
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredData;
            return results;


        }

        @Override //main UI Thread
        protected void publishResults(CharSequence keyword, FilterResults results) {
            data.clear();
            data.addAll((ArrayList<Model>)results.values);
            notifyDataSetChanged();
        }
    };


}
