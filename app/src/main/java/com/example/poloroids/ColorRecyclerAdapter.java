package com.example.poloroids;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ColorRecyclerAdapter extends RecyclerView.Adapter<ColorRecyclerAdapter.ColorsViewholder> {

    Context context;
    ArrayList<colors> colorsArrayList;
    public ColorRecyclerAdapter(Context context,ArrayList<colors> colorsArrayList){
        this.context=context;
        this.colorsArrayList=colorsArrayList;
    }

    @NonNull
    @Override
    public ColorsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.colors_item,parent,false);
        return new ColorsViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorsViewholder holder, int position) {
        colors colors=colorsArrayList.get(position);
        holder.colorName.setText(colors.colorName);
        holder.colorImage.setImageResource(colors.colorImage);
    }

    @Override
    public int getItemCount() {
        Log.d("TAG","Here");
        return colorsArrayList.size();
    }

    public static class ColorsViewholder extends RecyclerView.ViewHolder{

        ImageView colorImage;
        TextView colorName;
        public ColorsViewholder(@NonNull View itemView) {
            super(itemView);
            colorImage=itemView.findViewById(R.id.imgColors);
            colorName=itemView.findViewById(R.id.txtDesc);
        }
    }
}
