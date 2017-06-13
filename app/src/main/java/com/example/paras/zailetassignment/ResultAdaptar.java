package com.example.paras.zailetassignment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ResultAdaptar extends RecyclerView.Adapter<ResultAdaptar.Viewholder> {
    Context context;
    List<result> Arraylist1;
    int counter;
    Intent i;
    int prepos=0;
    public ResultAdaptar(Context context, List<result> Arraylist1) {
        this.context = context;
        this.Arraylist1 = Arraylist1;
        i=new Intent(context,MainActivity.class);
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic, parent, false);
        return new Viewholder(v);

    }
    @Override
    public void onBindViewHolder(final Viewholder holder, final int position) {

        result r = Arraylist1.get(position);
        holder.interest.setText(r.getInterest().toUpperCase());
        Glide.with(context).load("http://www.zailet.com/" + r.getCover()).into(holder.cover);
        if(prepos<position){
            AnimationUtil.animate(holder,true);
        }
        else { AnimationUtil.animate(holder,false);
        }
prepos=position;
            holder.cover.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View v) {
                if(holder.interest.getText()!="SELECTED")
                {    holder.interest.setText("SELECTED");
                    counter = counter + 1;
                }
               else {
                    holder.interest.setText(Arraylist1.get(position).getInterest());
                    counter = counter - 1;
                 }

                     }
        }) ;
    }

    @Override
    public int getItemCount() {
        return Arraylist1.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder

    {
        public ImageView cover;
        public TextView interest;
        public Viewholder(View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.topic);
            interest = (TextView) itemView.findViewById(R.id.topicname);
        }


        }

        }


