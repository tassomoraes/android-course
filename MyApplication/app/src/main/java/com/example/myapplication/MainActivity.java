package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText etNome;
    private TextView tvResultado;
    private TextInputEditText tiEmail;

    private CheckBox checkVerde, checkBranco, checkVermelho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome          = findViewById(R.id.etNome);
        tvResultado     = findViewById(R.id.tvResultado);
        tiEmail         = findViewById(R.id.tiEmail);

        //checkbox
        checkVerde      = findViewById(R.id.checkVerde);
        checkBranco     = findViewById(R.id.checkBranco);
        checkVermelho   = findViewById(R.id.checkVermelho);
    }

    void checkbox (){

        String texto = "";
        if (checkVerde.isChecked()){
            texto = texto + checkVerde.getText().toString();
            texto = texto + " selecionado; ";
        }
        if (checkBranco.isChecked()){
            texto = texto + checkBranco.getText().toString();
            texto = texto + " selecionado; ";
        }
        if (checkVermelho.isChecked()){
            texto = texto + checkVermelho.getText().toString();
            texto = texto + " selecionado.";
        }

        tvResultado.setText(texto);
    }

    public void enviar (View view){

        checkbox();

        String nome = etNome.getText().toString();
        String email = tiEmail.getText().toString();

        //tvResultado.setText( "Nome: " + nome + " Email: " + email);

        limpar();
    }

    public void limpar (){
        etNome.setText("");
        tiEmail.setText("");
    }

}
