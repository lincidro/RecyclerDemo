package com.roll.recyclerdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private Context mContext;
    private ArrayList<String> mTextos;
    private ArrayList<String> mDates;

    //Se crea un constructor
    public RecyclerViewAdapter(Context context, ArrayList<String> textos, ArrayList<String> dates) {
        mContext = context;
        mTextos = textos;
        mDates = dates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //Aca la logica casi siempre es la misma
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextView.setText(mTextos.get(position));
        holder.mTextViewDates.setText((mDates.get(position)));
    }

    @Override
    public int getItemCount() {
        return mTextos.size();
    }


    /////////////////////////////////////////////////////////
    // 1 ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        // Declarar lo que contendrá cada item del recycler, en este caso solo está un TextView
        TextView mTextView;
        TextView mTextViewDates;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.recycler_item_tv);
            mTextViewDates = itemView.findViewById(R.id.recycler_item_date);
        }
    }
}
