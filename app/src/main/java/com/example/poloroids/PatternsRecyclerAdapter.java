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

public class PatternsRecyclerAdapter extends RecyclerView.Adapter<PatternsRecyclerAdapter.PatternsViewholder> {

    Context context;
    ArrayList<patterns> patternsArrayList;
    public PatternsRecyclerAdapter(Context context,ArrayList<patterns> patternsArrayList){
        this.context=context;
        this.patternsArrayList=patternsArrayList;
    }

    @NonNull
    @Override
    public PatternsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.colors_item,parent,false);
        return new PatternsViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PatternsViewholder holder, int position) {
        patterns patterns=patternsArrayList.get(position);
        holder.patternName.setText(patterns.patternName);
        holder.patternImage.setImageResource(patterns.patternImage);
    }

    @Override
    public int getItemCount() {
        return patternsArrayList.size();
    }

    public static class PatternsViewholder extends RecyclerView.ViewHolder{

        ImageView patternImage;
        TextView patternName;
        public PatternsViewholder(@NonNull View itemView) {
            super(itemView);
            patternImage=itemView.findViewById(R.id.imgColors);
            patternName=itemView.findViewById(R.id.txtDesc);
        }
    }
}
