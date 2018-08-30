package com.example.shraboni.technicaltestmcc.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.shraboni.technicaltestmcc.ImageActivity;
import com.example.shraboni.technicaltestmcc.R;
import com.example.shraboni.technicaltestmcc.model.Contentfilelist;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    Context context;
    private List<Contentfilelist> listing;

    public DataAdapter(Context context,List<Contentfilelist> data) {
        this.context = context;
        this.listing = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final String image = listing.get(position).getIMG();
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(listing.get(position).getIMG())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.ivUrlImage);

        holder.ivUrlImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), ImageActivity.class);
                intent.putExtra("image",image);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listing.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivUrlImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivUrlImage = itemView.findViewById(R.id.ivUrlImage);
        }
    }
}
