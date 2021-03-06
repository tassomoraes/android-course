package com.tlom.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private TextInputEditText campoAlcool, campoGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textos
        textResultado = findViewById(R.id.textResultado);

        //campos
        campoAlcool = findViewById(R.id.campoAlcool);
        campoGasolina = findViewById(R.id.campoGasolina);
    }

    public void calculaMelhorOpcao (View view){

        String precoAlcool = campoAlcool.getText().toString();
        String precoGasolina =  campoGasolina.getText().toString();

        boolean camposValidados = validaCampos(precoAlcool, precoGasolina);

        String melhorOpcao = "";

        if( camposValidados ){

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double resultado = valorAlcool/valorGasolina;

            if( resultado >= 0.7)
                melhorOpcao = "gasolina!";
            else
                melhorOpcao = "álcool!";

            textResultado.setText("Abasteça com " + melhorOpcao);

        }else
            textResultado.setText("Preencha ambos os cmapos!");

    }

    public boolean validaCampos(String pAlcool, String pGasolina){

        boolean validacao = true;

        if(pAlcool.equals(null) || pAlcool==""){
            validacao = false;
        } else if(pGasolina.equals(null) || pGasolina==""){
            validacao = false;
        }

        return validacao;

    }

}
