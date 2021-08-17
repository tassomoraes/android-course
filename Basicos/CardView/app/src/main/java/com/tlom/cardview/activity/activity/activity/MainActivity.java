package com.tlom.cardview.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.tlom.cardview.R;
import com.tlom.cardview.activity.activity.adapter.Adapter;
import com.tlom.cardview.activity.activity.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPost;
    private List<Postagem> postagems;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPost = findViewById(R.id.recyclerPost);
        postagems = new ArrayList<Postagem>();

        carregaPosts();

        //Definir layout
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( this );
        LinearLayoutManager layoutManager = new LinearLayoutManager( this );
        layoutManager.setOrientation(LinearLayout.HORIZONTAL);
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerPost.setLayoutManager( layoutManager );

        //Definir adapter
        Adapter adapter = new Adapter( postagems );
        recyclerPost.setAdapter( adapter );

    }

    private void carregaPosts() {

        Postagem post;

        post = new Postagem("Tasso Moraes","21/04/2020","Aterrissando em Lisboa \n#JMJ",R.drawable.imagem1);
        this.postagems.add( post );
        post = new Postagem("Hotel HM","21/05/2010","Melhot Hotel para se passar as férias",R.drawable.imagem2);
        this.postagems.add( post );
        post = new Postagem("Luiza","15/05/2012","Em Juazeiro \n#terraDeMissão",R.drawable.imagem3);
        this.postagems.add( post );
        post = new Postagem("Marcos Paulo","29/09/2020","Aniversário na Contemplativa",R.drawable.imagem4);
        this.postagems.add( post );

    }
}
