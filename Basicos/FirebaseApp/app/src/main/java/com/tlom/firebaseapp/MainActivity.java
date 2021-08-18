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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // esse objeto referência nos permite salvar dados no fire base
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference(); // pega raiz como referência
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* APLICANDO FILTROS */
        DatabaseReference usuarios = referencia.child("usuarios");

        //DatabaseReference usuarioPesquisa = usuarios.child("-MhPX0yJfbEX-w4RsUs4");
        //Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Tasso");
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2); //ordena por chave e só pega o 2 primeiros itens
        //Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);   // pega os 2 ultlimos itens da lista

        /* Menos ou igual (>=) */
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(29);
        /* Menor ou igual (<=) */
        //Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(28);
        /* Menos ou igual (>=) */
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(28).endAt(29);

        /* Filtrando por texto */
        Query usuarioPesquisa = usuarios.orderByChild("nome").startAt("R").endAt("R" + "\uf8ff");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /*Usuario dadosUsuario = snapshot.getValue( Usuario.class );  // quando se passa uma classe o snapshot retorna um objeto da classe
                Log.i("Dados usuario: ", "nome: " + dadosUsuario.getNome());*/
                Log.i("Dados usuario: ", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /* IDENTIFICADOR ÚNICO /
        DatabaseReference usuarios = referencia.child("usuarios");

        Usuario usuario = new Usuario();
        usuario.setNome("Arthur");
        usuario.setSobrenome("Leblanc");
        usuario.setIdade(29);

        usuarios.push().setValue( usuario );

        /*DESLOGAR USUÁRIO/
        usuario.signOut();
        */

        /*LOGAR USUÁRIO/
        usuario.signInWithEmailAndPassword(
                "prysccyllaregis@gmail.com", "pry1234")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if ( task.isSuccessful() ){
                            Log.i("signIn", "Usuario logado com sucesso!");
                        }else{
                            Log.i("signIn", "Erro ao logar usuário");
                        }
                    }
                });

        /*VERIFICAR USUÁRIO LOGADO/
        if (usuario.getCurrentUser() != null )  //retorna o usuário que está logado no app
            Log.i("CreateUser", "Usuário logado!");
        else
            Log.i("CreateUser", "Usuário não logado");
        */

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