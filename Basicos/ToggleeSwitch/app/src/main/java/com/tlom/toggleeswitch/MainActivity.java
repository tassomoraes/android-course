package com.tlom.toggleeswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch switchSenha;
    private ToggleButton toggleSenha;
    private CheckBox checkSenha;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchSenha = findViewById(R.id.switchSenha);
        toggleSenha = findViewById(R.id.toggleSenha);
        checkSenha = findViewById(R.id.checkSenha);
        textResultado = findViewById(R.id.textResultado);


        adicionarListener();

    }

    public void adicionarListener(){

        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked ){
                    textResultado.setText("Ligado");
                } else{
                    textResultado.setText("Desligado");
                }
                toggleSenha.setChecked(isChecked);
                checkSenha.setChecked(isChecked);
            }
        });

        toggleSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked ){
                    textResultado.setText("Ligado");
                } else{
                    textResultado.setText("Desligado");
                }
                switchSenha.setChecked(isChecked);
                checkSenha.setChecked(isChecked);
            }
        });

        checkSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked ){
                    textResultado.setText("Ligado");
                } else{
                    textResultado.setText("Desligado");
                }
                toggleSenha.setChecked(isChecked);
                switchSenha.setChecked(isChecked);
            }
        });
    }

    public void enviar (View view){

        //if( toggleSenha.isChecked() ){
        //if( checkSenha.isChecked() ){
        if( switchSenha.isChecked() ){
            textResultado.setText("Ligado");
        } else{
            textResultado.setText("Desligado");
        }


    }

}
