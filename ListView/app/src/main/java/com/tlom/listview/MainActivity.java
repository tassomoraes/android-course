package com.tlom.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLugares;
    private String[] itens = {
            "Recife", "Rio de Janeiro", "Natal", "Salvador",
            "Fortaleza", "Krakow", "Porto", "Lisboa", "Vila do Conde",
            "Barcelos", "Costa de Caparica", "Glasgow", "Bohun", "Londres",
            "Essen", "Edingurg", "Warsow", "Berlin", "Frankfurt", "Dortmond"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLugares = findViewById(R.id.listLugares);

        //Criando adaptador para a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        //Adicionar Adaptador na lista
        listLugares.setAdapter( adaptador );

        //Ação no click
        listLugares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String lugarSelecionado = listLugares.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),lugarSelecionado,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
