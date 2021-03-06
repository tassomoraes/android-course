package com.tlom.atmconsultoria.ui.sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlom.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "A ATM consultoria tem como missão apoiar organizações " +
                "que desejam alcançar o sucesso através da excelência em gestão" +
                " e da busca pela qualidade.";

        Element versao = new Element();
        versao.setTitle( "Versão 1.0" );

        return new AboutPage( getActivity())
                .setImage(R.drawable.logo)
                .setDescription( descricao )

                .addGroup("Redes Sociais")
                .addFacebook("tassoluis","Facebook")
                .addInstagram("tassoluis","Instagram")
                .addTwitter("tassoluis","Twiter")
                .addYoutube("tassoluis","Youtube")
                .addGitHub("tassoluis","GitHub")
                .addPlayStore("com.instagram.android","PlayStore")

                .addItem(versao)

                .create();

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }

}
