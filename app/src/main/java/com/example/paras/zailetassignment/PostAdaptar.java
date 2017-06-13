package com.example.paras.zailetassignment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class PostAdaptar extends RecyclerView.Adapter<PostAdaptar.Viewholder> {
    Context context;
    List<posts> Arraylist1;

    public PostAdaptar(Context context, List<posts> Arraylist1) {
        this.context = context;
        this.Arraylist1 = Arraylist1;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        posts p = Arraylist1.get(position);
        holder.description.setText(p.getDescription());
        holder.title.setText(p.getTitle());
        holder.name.setText(p.getName());
        holder.time.setText(p.getTime());
        Glide.with(context).load("http://www.zailet.com/" + p.getCover()).into(holder.cover);
        Glide.with(context).load("http://www.zailet.com/" + p.getDp()).into(holder.dp);

    }

    @Override
    public int getItemCount() {
        return Arraylist1.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder

    {
        private ImageView dp;
        private TextView title;
        private TextView description;
        private ImageView cover;
        private TextView time;
        private TextView name;

        public Viewholder(View itemView) {
            super(itemView);
            dp = (ImageView) itemView.findViewById(R.id.dp);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.desp);
            cover = (ImageView) itemView.findViewById(R.id.cover);
            time = (TextView) itemView.findViewById(R.id.time);
            name = (TextView) itemView.findViewById(R.id.name);


        }
    }
}
