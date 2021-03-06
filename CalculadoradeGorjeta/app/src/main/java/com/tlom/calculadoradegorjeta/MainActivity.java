package com.tlom.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarPercent;
    private TextView textPercent, textGorjeta, textTotal;
    private EditText editConta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        textTotal       = findViewById(R.id.textTotal);
        textGorjeta     = findViewById(R.id.textGorjeta);
        textPercent     = findViewById(R.id.textPercent);

        //Campos
        editConta       = findViewById(R.id.editConta);

        //SeekBar
        seekBarPercent  = findViewById(R.id.seekBarPercent);

        carregarListener();

    }

    public void carregarListener(){

        seekBarPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPercent.setText(Math.round(porcentagem) + "%");
                calculaGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calculaGorjeta (){

        String recuperaConta = editConta.getText().toString();
        if (recuperaConta.equals("") || recuperaConta == null)
            Toast.makeText(
                    getApplicationContext(),
                    "Digite algum valor para a conta!",
                    Toast.LENGTH_SHORT
            );
        else{
            double valorConta = Double.parseDouble(recuperaConta);
            double gorjeta = valorConta*(porcentagem/100);

            textGorjeta.setText("R$ " + gorjeta);
            textTotal.setText("R$ " + (valorConta+gorjeta));
        }


    }

}
