package com.tlom.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch switchMic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchMic = findViewById(R.id.switchMic);

        adicionarListener();

    }

    public void adicionarListener(){

        switchMic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                abrirDialog();
            }
        });

    }

    public void abrirDialog (){

        //Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder( this );

        //Configurar título e mensagem
        dialog.setTitle("Ativar Microfone");
        dialog.setMessage("Você deja ativar o microfone do dispositivo?");

        //Configurar Cancelamento
        dialog.setCancelable(true);

        //Configurar Icone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        //Configurar ações para SIM e NÃO
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switchMic.setChecked(true);
                Toast.makeText(
                        getApplicationContext(),
                        "Microfone ativado!",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switchMic.setChecked(false);
                Toast.makeText(
                        getApplicationContext(),
                        "Microfone Desativado",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });

        //Criar e exibir AlertDialog
        dialog.create();
        dialog.show();

    }

}
