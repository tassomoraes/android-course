package com.tlom.cardview.activity.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tlom.cardview.R;
import com.tlom.cardview.activity.activity.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Postagem> postagems = new ArrayList<Postagem>();

    public Adapter(List<Postagem> postagems) {
        this.postagems = postagems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Inflando o xml para view
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_post,parent,false);

        return new MyViewHolder( itemLista );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.data.setText(postagems.get(position).getData());
        holder.userName.setText(postagems.get(position).getUser());
        holder.post.setText(postagems.get(position).getPost());
        holder.imagemPost.setImageResource(postagems.get(position).getImagemPost());
    }

    @Override
    public int getItemCount() {
        return postagems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView userName;
        TextView post;
        TextView data;
        ImageView imagemPost;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userName    = itemView.findViewById(R.id.textUser);
            post        = itemView.findViewById(R.id.textPost);
            data        = itemView.findViewById(R.id.textData);
            imagemPost  = itemView.findViewById(R.id.imagePost);

        }
    }

}
