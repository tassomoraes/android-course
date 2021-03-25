package com.tlom.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tlom.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageView imageCachorro, imageGato, imageLeao, imageMacaco, imageVaca, imageOvelha;
    private MediaPlayer mediaPlayerBichos;

    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        imageCachorro = view.findViewById(R.id.imageCachorro);
        imageGato = view.findViewById(R.id.imageGato);
        imageLeao = view.findViewById(R.id.imageLeao);
        imageMacaco = view.findViewById(R.id.imageMacaco);
        imageVaca = view.findViewById(R.id.imageVaca);
        imageOvelha = view.findViewById(R.id.imageOvelha);

        imageCachorro.setOnClickListener(this);
        imageGato.setOnClickListener(this);
        imageLeao.setOnClickListener(this);
        imageMacaco.setOnClickListener(this);
        imageVaca.setOnClickListener(this);
        imageOvelha.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imageCachorro:
                playSound(R.raw.dog);
                break;
            case R.id.imageGato:
                playSound(R.raw.cat);
                break;
            case R.id.imageLeao:
                playSound(R.raw.lion);
                break;
            case R.id.imageMacaco:
                playSound(R.raw.monkey);
                break;
            case R.id.imageVaca:
                playSound(R.raw.cow);
                break;
            case R.id.imageOvelha:
                playSound(R.raw.sheep);
                break;
        }

    }

    private void playSound(int soundId) {

        mediaPlayerBichos = MediaPlayer.create(getActivity(),soundId);

        if (mediaPlayerBichos != null){
            mediaPlayerBichos.start();

            mediaPlayerBichos.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayerBichos.release();
                }
            });
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayerBichos != null){
            mediaPlayerBichos.release();
            mediaPlayerBichos = null;
        }
    }
}
