package com.tlom.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

// Classe usada para criação do BD e para persistir os dados
public class DBHelper extends SQLiteOpenHelper {

    //  primeira versão do app
    //  na 1ª versão do app é chamado o méto onCreate
    //  caso o valor seja alterado de para outro o método chamado é o onUpgrade

    public static int VERSION = 2;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";

    public DBHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    // os metodos onCreate e onUpgrade são chamado somente um vez, na criação e atualização do app

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL ) ";

        try {
            db.execSQL( sql );
            Log.i("INFO DB", "Sucesso ao criar a tabela");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Ex: deletando uma tabela
        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ;";
        //Ex: alterando tabela adicionando uma coluna de status
        //String sql = "ALTER TABLE " + TABELA_TAREFAS + " ADD COLUMN status VARCHAR(2);";

        try {
            db.execSQL( sql );
            //Ex: criando a tabela novamente
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar a tabela");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar a tabela" + e.getMessage());
        }

    }
}
