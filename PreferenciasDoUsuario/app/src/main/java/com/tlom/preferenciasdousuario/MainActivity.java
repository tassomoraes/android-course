package com.tlom.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSalvar;
    private TextView textResultado;
    private EditText campoNome;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.button);
        textResultado = findViewById(R.id.textNome);
        campoNome = findViewById(R.id.editNome);



        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //usadao para salvar pequenas configurações do usuário
                //mode 0 = só esse app pode modificar esse arquivo
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                //É com esse obj que é possível editar o arquivo de preferencias
                SharedPreferences.Editor editor = preferences.edit();

                //Validar o nome
                if (campoNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o campo com um nome!",Toast.LENGTH_LONG).show();
                }else {

                    String nome = campoNome.getText().toString();
                    editor.putString("nome",nome);
                    editor.commit();
                    textResultado.setText("Olá, " + nome);

                }
            }
        });

        //Recuperar dados salvos
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

        //Validar se temos o nome em preferencias
        if (preferences.contains("nome")){
            String nome = preferences.getString("nome","usuário não definido");
            textResultado.setText("Olá, " + nome);
        }else {
            textResultado.setText("Olá, usuário não definido");
        }

    }
}
