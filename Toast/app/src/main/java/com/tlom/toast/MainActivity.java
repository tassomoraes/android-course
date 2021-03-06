package com.tlom.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ativarToast (View view) {

        TextView textView = new TextView( getApplicationContext() );
        textView.setText("Mensagem do Toast");
        //textView.setBackgroundColor(R.color.colorPrimaryDark);

        ImageView imagem = new ImageView( getApplicationContext() );
        imagem.setImageResource(android.R.drawable.btn_star_big_on);

        Toast toast = new Toast( getApplicationContext() );
        //toast.setView( imagem );
        toast.setView( textView );
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

        /*
        Toast.makeText(
                getApplicationContext(),
                "Mostrando mensagem do Toas",
                Toast.LENGTH_LONG
        ).show();
         */

    }

}
