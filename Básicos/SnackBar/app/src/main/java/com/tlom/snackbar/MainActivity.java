package com.tlom.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonAtivar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAtivar = findViewById(R.id.buttonAtivar);

        buttonAtivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(
                        view,
                        "Snackbar Ativado",
                        Snackbar.LENGTH_INDEFINITE
                ).setAction("Confirmar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();

            }
        });
    }
}
