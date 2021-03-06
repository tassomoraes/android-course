package com.tlom.passadadosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textNome    = findViewById(R.id.textNome);
        textIdade   = findViewById(R.id.textIdade);

        //Recuperando Dados
        Bundle dados = getIntent().getExtras();

        String nome = dados.getString("nome");
        String idade = String.valueOf(dados.getInt("idade"));

        Usuario user = (Usuario) dados.getSerializable("usuario");
        nome = user.getNome();
        idade = user.getEmail();

        textNome.setText(nome);
        textIdade.setText(idade);


    }
}
