package com.example.myapplication;

public class Pessoa {

    String nome;
    int idade;

    public void exibirDados (String nome){
        System.out.println("Exibir apenas o nome: " + nome);
    }

    public void exibirDados (String nome, int idade){
        System.out.println("Exibir nome e idade: " + nome + " e " + idade);
    }
}
