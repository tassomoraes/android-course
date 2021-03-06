package com.tlom.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button botaoJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar = findViewById(R.id.botaoJogar);

        //Ao clicar na imagem
        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Chamando tela do resultado ResultadoActivity
                Intent intent = new Intent(getApplicationContext(),RasultadoActivity.class);
                //Passa resultado radomico
                Random random = new Random();
                int result = random.nextInt(2);
                intent.putExtra("result",result);

                startActivity( intent );

            }
        });

    }
}
