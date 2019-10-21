package com.unida.sirajuddin.otherwordpress.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unida.sirajuddin.otherwordpress.Model.Model;
import com.unida.sirajuddin.otherwordpress.R;
import com.unida.sirajuddin.otherwordpress.WPPost.WPPostDetails;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter{

    private ArrayList<Model> dataset;
    private Context context;

    public RecycleViewAdapter(ArrayList<Model> mlist, Context context){
        this.dataset = mlist;
        this.context = context;
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView mtitle,msubtitle;
        public ImageTypeViewHolder(@NonNull View itemView) {
            super(itemView);

            this.mtitle = itemView.findViewById(R.id.title);
            this.msubtitle = itemView.findViewById(R.id.subtitle);
            this.imageView = itemView.findViewById(R.id.icont);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postdetails, parent, false);
        return new ImageTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            final Model object = dataset.get(position);


        ((ImageTypeViewHolder)holder).mtitle.setText(object.title);
        ((ImageTypeViewHolder)holder).msubtitle.setText(object.subtitle);

        ((ImageTypeViewHolder)holder).mtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WPPostDetails.class);
                intent.putExtra("itemposition",position);
                context.startActivity(intent);
            }
        });

        ((ImageTypeViewHolder)holder).msubtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WPPostDetails.class);
                intent.putExtra("itemposition",position);
                context.startActivity(intent);
            }
        });

        ((ImageTypeViewHolder)holder).imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WPPostDetails.class);
                intent.putExtra("itemposition",position);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() { return dataset.size();
    }
}
