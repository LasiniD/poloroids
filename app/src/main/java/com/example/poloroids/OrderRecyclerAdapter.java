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

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.OrdersViewholder> {

    Context context;
    ArrayList<orders> ordersArrayList;
    public OrderRecyclerAdapter(Context context,ArrayList<orders> ordersArrayList){
        this.context=context;
        this.ordersArrayList=ordersArrayList;
    }

    @NonNull
    @Override
    public OrdersViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.orders_item,parent,false);
        return new OrdersViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersViewholder holder, int position) {
        orders orders=ordersArrayList.get(position);
        holder.orderEmail.setText(orders.lblemail);
        holder.orderPhoneNo.setText(orders.lblphoneno);
        holder.ordertxtEmail.setText(orders.email);
        holder.ordertxtPhoneNo.setText(orders.phoneno);
        holder.orderDate.setText(orders.orderdate);
        holder.username.setText(orders.username);

    }

    @Override
    public int getItemCount() {
        Log.d("TAG","here");
        return ordersArrayList.size();
    }

    public static class OrdersViewholder extends RecyclerView.ViewHolder{

        TextView orderName,orderEmail,orderPhoneNo,ordertxtEmail,ordertxtPhoneNo,orderDate,username;
        public OrdersViewholder(@NonNull View itemView) {
            super(itemView);
            orderName=itemView.findViewById(R.id.username);
            orderEmail=itemView.findViewById(R.id.lblemail);
            orderPhoneNo=itemView.findViewById(R.id.lblphoneno);
            ordertxtEmail=itemView.findViewById(R.id.email);
            ordertxtPhoneNo=itemView.findViewById(R.id.phoneno);
            orderDate=itemView.findViewById(R.id.orderdate);
        }
    }
}

