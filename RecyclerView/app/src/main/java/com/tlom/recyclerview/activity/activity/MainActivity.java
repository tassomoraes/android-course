package com.tlom.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tlom.recyclerview.R;
import com.tlom.recyclerview.activity.RecyclerItemClickListener;
import com.tlom.recyclerview.activity.adapter.Adapter;
import com.tlom.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Configurar adapter
        Adapter adapter = new Adapter( listaFilmes );

        //Listagem de filmes
        this.criarFilmes();

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize( true ); //otimizando
        recyclerView.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL)); //adicionando linhas
        recyclerView.setAdapter( adapter );

        //Tratando clicke
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                String filme = listaFilmes.get(position).getTituloFilme();
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item selecionado :" + filme,
                                        Toast.LENGTH_SHORT
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                String filme = listaFilmes.get(position).getTituloFilme();
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + filme,
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }

    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha - de volta ao lar","2017","Aventura");
        listaFilmes.add( filme );
        filme = new Filme("Mulher Maravilha","2017","Fantasia");
        listaFilmes.add( filme );
        filme = new Filme("Liga da Justça","2017","Ficção");
        listaFilmes.add( filme );
        filme = new Filme("Capitão America - Guerra Civil","2016","Aventura/Ficção");
        listaFilmes.add( filme );
        filme = new Filme("It - A coisa","2017","Drama/Terror");
        listaFilmes.add( filme );
        filme = new Filme("Pica Pal - O Filme","2017","Comédia/Animação");
        listaFilmes.add( filme );
        filme = new Filme("A Múmia","2017","Aventura");
        listaFilmes.add( filme );
        filme = new Filme("A Bela e a Fera","2017","Romance");
        listaFilmes.add( filme );
        filme = new Filme("Meu Malvado Favorito 3","2017","Comédia/Animação");
        listaFilmes.add( filme );
        filme = new Filme("Carros 3","2017","Comédia/Animação/Aventura");
        listaFilmes.add( filme );

    }

}
