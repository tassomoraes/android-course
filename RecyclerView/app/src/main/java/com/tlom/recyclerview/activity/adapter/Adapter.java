package com.tlom.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tlom.recyclerview.R;
import com.tlom.recyclerview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    //O ViewHolder é utilizado pra exibir cada item da lista
    //cada item da lista é um objeto da classe ViewHolder

    private List<Filme> listaFilmes;

    public Adapter (List<Filme> lista) {
        this.listaFilmes = lista;
    }

    // Método usado para criar as visualizações
    // logo é preciso criar os layouts xml
    // ele é chamado até criar todas a visualizações da lista
    // é preciso pegar o xml e retornar para cada um dos itens da lista
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Convertendo o xml para uma View (inflate)
        // o parent.getContext() pega o contexto baseado no componetem o item de lista está dentro
        // no caso o parent
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);

        // o objeto itemLista é passado como parametro para o ViewHolder para que o ViewHolder
        // configure os dados dentro da visualização
        return new MyViewHolder( itemLista );
    }

    // Métodos usado para exibir cada um dos elementos
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = listaFilmes.get(position);
        holder.ano.setText(filme.getAno());
        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());

    }

    // Método que retorna a quantidade de itens que vão ser exibidos
    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    //Inner class: uma classe dentro de outra classe
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // É o item View que acessa o objeto View, então é através dele que é possível acessar
            // os ids dos item do xml adapter_list
            titulo  = itemView.findViewById(R.id.textTitulo);
            ano     = itemView.findViewById(R.id.textAno);
            genero  = itemView.findViewById(R.id.textGenero);

        }
    }

}
