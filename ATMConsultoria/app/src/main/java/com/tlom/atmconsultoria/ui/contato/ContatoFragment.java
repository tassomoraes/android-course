package com.tlom.atmconsultoria.ui.contato;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlom.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContatoFragment extends Fragment {


    public ContatoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "A ATM consultoria está sempre a disposição para lhe atender." +
                "Entre em contato conosco e tire suas dúvidas.";

        return new AboutPage( getActivity())

                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("anteidmento@atmconsultoria.com.br","Envie um email")
                .addWebsite("google.com","Acesse nosso site")

                .create();

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_contato, container, false);
    }

}
