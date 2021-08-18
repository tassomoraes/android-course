package com.tlom.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // esse objeto referência nos permite salvar dados no fire base
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference(); // pega raiz como referência
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*VERIFICAR USUÁRIO LOGADO*/
        if (usuario.getCurrentUser() != null )  //retorna o usuário que está logado no app
            Log.i("CreateUser", "Usuário logado!");
        else
            Log.i("CreateUser", "Usuário não logado");

        /* CADASTRO USUÁRIO
        usuario.createUserWithEmailAndPassword(
                "prysccyllaregis@gmail.com", "pry1234")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if ( task.isSuccessful() ){
                            Log.i("CreateUser", "Usuario criado com sucesso!");
                        }else{
                            Log.i("CreateUser", "Erro ao criar usuário");
                        }
                    }
                });*/

        /*
        DatabaseReference usuarios = referencia.child("usuarios");
        DatabaseReference produtos = referencia.child("produtos");

        // RECUPERAR DADOS DO FIREBASE
        usuarios.addValueEventListener(new ValueEventListener() {
            @Override  // é chamado sempre que se consegue recuperar os dados alterados
            public void onDataChange(DataSnapshot snapshot) {
                Log.i("FIREBASE",snapshot.getValue().toString());
            }

            @Override   // se a raquisição for cancelada
            public void onCancelled(DatabaseError error) {

            }
        });

        // SALVAR DADOS NO FIREBASE

        Usuario usuario = new Usuario();
        usuario.setNome("Prysccylla");
        usuario.setSobrenome("Moraes");
        usuario.setIdade(28);

        Produto produto = new Produto();
        produto.setDescricao("nexus");
        produto.setMarca("LG");
        produto.setPreco(1569.90);

        produtos.child( "002" ).setValue( produto );
        */
    }
}