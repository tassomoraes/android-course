package com.tlom.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;

    private CheckBox checkAmarelo, checkRoxo, checkAzul;
    private RadioButton sexoMasculino, sexoFeminino;
    private RadioGroup sexoGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //campos
        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);

        //textos
        textoResultado = findViewById(R.id.textDados);

        //caixas
        checkAmarelo = findViewById(R.id.checkAmarelo);
        checkRoxo = findViewById(R.id.checkRoxo);
        checkAzul = findViewById(R.id.checkAzul);

        //radioButtons
        sexoMasculino = findViewById(R.id.radioButtonMasculino);
        sexoFeminino = findViewById(R.id.radioButtonFeminino);
        sexoGroup = findViewById(R.id.radioGroup);

        radioButton();  
    }

    public void radioButton (){

        sexoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButtonMasculino)
                    textoResultado.setText("Masculino");
                else if(checkedId == R.id.radioButtonFeminino)
                    textoResultado.setText("Feminino");
            }
        });

        /*
        String texto = "";

        if( sexoMasculino.isChecked() ){
            String sexo = sexoMasculino.getText().toString();
            texto = "Sexo: " + sexo;
        }else if( sexoFeminino.isChecked() ){
            String sexo = sexoFeminino.getText().toString();
            texto = "Sexo: " + sexo;
        }

        textoResultado.setText(texto);

         */
    }

    public void checkBox (){
        String texto = "";

        if( checkAmarelo.isChecked() ){
            String cor = checkAmarelo.getText().toString();
            texto += cor + "\n";
        }
        if( checkRoxo.isChecked() ){
            String cor = checkRoxo.getText().toString();
            texto += cor + "\n";
        }
        if( checkAzul.isChecked() ){
            String cor = checkAzul.getText().toString();
            texto += cor + "\n";
        }

        textoResultado.setText((texto));
    }

    public void enviar (View view){

        //radioButton();
        //checkBox();
        /*
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        textoResultado.setText("nome: " + nome + "\nemail: " + email);

         */

    }

    public void limpar (View view){
        campoNome.setText("");
        campoEmail.setText("");
    }
}
