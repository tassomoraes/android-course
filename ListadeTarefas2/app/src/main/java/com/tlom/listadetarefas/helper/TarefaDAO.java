package com.tlom.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.tlom.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

// DAO é um padrão de projeto Data Access Object define uma separação dos dados
// classe para salvar os dados da tarefa

public class TarefaDAO implements ITarefaDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    // para ascessar o DBHelper
    public TarefaDAO(Context context) {
        DBHelper db = new DBHelper( context );
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());


        try {
            escreve.insert(DBHelper.TABELA_TAREFAS, null, cv); // salvando os dados; null para dizer que é preciso ter a tarefa preenchida
            Log.i("INFO","Tarefa salva com sucesso!");
        }catch ( Exception e){
            Log.e("INFO", "Erro ao salvar tarefa " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try {
            String[] args = {tarefa.getId().toString()};
            escreve.update(DBHelper.TABELA_TAREFAS, cv, "id=?", args); // salvando os dados; null para dizer que é preciso ter a tarefa preenchida
            Log.i("INFO","Tarefa atualizada com sucesso!");
        }catch ( Exception e){
            Log.e("INFO", "Erro ao atualizar tarefa " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        try {
            String[] args = {tarefa.getId().toString()};
            escreve.delete(DBHelper.TABELA_TAREFAS, "id=?", args); // salvando os dados; null para dizer que é preciso ter a tarefa preenchida
            Log.i("INFO","Tarefa deletada com sucesso!");
        }catch ( Exception e){
            Log.e("INFO", "Erro ao deletar tarefa " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        // recuperando as tarefas do BD
        String sql = "SELECT * FROM " + DBHelper.TABELA_TAREFAS + " ;";
        Cursor c = le.rawQuery(sql, null);  // selectionArgs seriam filtros para aplicar dentro do SELECT
        while ( c.moveToNext() ){
            Tarefa tarefa = new Tarefa();

            Long id = c.getLong( c.getColumnIndex("id"));
            String nomeTarefa = c.getString( c.getColumnIndex("nome"));

            tarefa.setId( id );
            tarefa.setNomeTarefa( nomeTarefa );

            tarefas.add( tarefa );
        }

        return tarefas;
    }
}
