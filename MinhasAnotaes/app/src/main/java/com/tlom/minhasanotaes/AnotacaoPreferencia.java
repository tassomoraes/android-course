package com.tlom.minhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencia {

    /*Fica mais fácil recuperar o contexto no mainActivity
    e passar o contexto para essa clase*/
    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor; //manipula os arquivos

    private final String CHAVE_NOME = "nome";
    private final String NOME_ARQUIVO = "anotacao.preferencia";

    public AnotacaoPreferencia( Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,0); //recuperar a anotação
        editor = preferences.edit(); //salvar a anotação
    }

    public void salvarAnotacao (String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public String recuperarAnotacao(){
        String anotacao = preferences.getString(CHAVE_NOME,"");
        return anotacao;
    }

}
