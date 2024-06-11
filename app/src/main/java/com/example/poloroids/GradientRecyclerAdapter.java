package com.example.poloroids;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GradientRecyclerAdapter extends RecyclerView.Adapter<GradientRecyclerAdapter.GradientsViewholder> {

    Context context;
    ArrayList<gradients> gradientsArrayList;
    public GradientRecyclerAdapter(Context context,ArrayList<gradients> gradientsArrayList){
        this.context=context;
        this.gradientsArrayList=gradientsArrayList;
    }

    @NonNull
    @Override
    public GradientsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.colors_item,parent,false);
        return new GradientsViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GradientsViewholder holder, int position) {
        gradients gradients=gradientsArrayList.get(position);
        holder.gradientName.setText(gradients.gradientName);
        holder.gradientImage.setImageResource(gradients.gradientImage);
    }

    @Override
    public int getItemCount() {
        return gradientsArrayList.size();
    }

    public static class GradientsViewholder extends RecyclerView.ViewHolder{

        ImageView gradientImage;
        TextView gradientName;
        public GradientsViewholder(@NonNull View itemView) {
            super(itemView);
            gradientImage=itemView.findViewById(R.id.imgColors);
            gradientName=itemView.findViewById(R.id.txtDesc);
        }
    }
}
