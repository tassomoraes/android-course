package com.tlom.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RasultadoActivity extends AppCompatActivity {

    private ImageView imageResultado;
    private Button botaoVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasultado);

        imageResultado  = findViewById(R.id.imageResultado);
        botaoVoltar     = findViewById(R.id.botaoVoltar);

        //Recuperando resultado para exibir imagem cara ou coroa
        Bundle dados = getIntent().getExtras();
        int resultado = dados.getInt("result");

        if (resultado == 0)
            imageResultado.setImageResource(R.drawable.moeda_coroa);
        else
            imageResultado.setImageResource(R.drawable.moeda_cara);

        //Ao clicar na imagem voltar
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }
}
