package com.tlom.passadadosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        //Configura click no botão
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criando intent para chamar SegundaActivity
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);

                //Enviar dados para SegundaActivity através da intent
                intent.putExtra("nome","Tasso Moraes");
                intent.putExtra("idade",28);
                //Enviando um objeto para SegundaActivity
                Usuario user = new Usuario("Prysccylla Maria","prysccyllaregis@gmail.com");
                intent.putExtra("usuario",user);

                //Iniciando SegundaActivity
                startActivity( intent );


            }
        });

    }
}
