package com.tlom.aprendaingles.Fragments;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.tlom.aprendaingles.R;

import java.util.IllegalFormatCodePointException;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener{

    private MediaPlayer mediaPlayerNumeros;
    private ImageView image1, image2, image3, image4, image5, image6;

    public NumerosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        //É preciso utiliza o tipo View para usa o findViewById
        image1 = view.findViewById(R.id.image1);
        image2 = view.findViewById(R.id.image2);
        image3 = view.findViewById(R.id.image3);
        image4 = view.findViewById(R.id.image4);
        image5 = view.findViewById(R.id.image5);
        image6 = view.findViewById(R.id.image6);

        //Já que a classe implementa o método OnClickListener passa passar o contexto this
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        image5.setOnClickListener(this);
        image6.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        //Trata o click em cada imagem pegando o Id
        switch (view.getId()){
            case R.id.image1:
                playSound(R.raw.one);
                break;
            case R.id.image2:
                playSound(R.raw.two);
                break;
            case R.id.image3:
                playSound(R.raw.three);
                break;
            case R.id.image4:
                playSound(R.raw.four);
                break;
            case R.id.image5:
                playSound(R.raw.five);
                break;
            case R.id.image6:
                playSound(R.raw.six);
                break;
        }

    }

    public void playSound(int soundId){

        mediaPlayerNumeros = MediaPlayer.create(getActivity(),soundId);

        if(mediaPlayerNumeros != null){
            mediaPlayerNumeros.start();

            //limpando recurso após executar o som
            mediaPlayerNumeros.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayerNumeros.release();
                }
            });
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayerNumeros != null){
            mediaPlayerNumeros.release();
            mediaPlayerNumeros = null;
        }
    }
}
