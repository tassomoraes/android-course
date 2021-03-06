package com.example.myapplication.classes;

public class Animal {

    protected int tamanho;
    protected String cor;
    protected int peso;

    //Getters and Setters
    void setCor (String cor){
        this.cor = cor;
    }

    String getCor (){
        return this.cor;
    }

    void dormir(){
        System.out.println("Dormir como um");
    }

    void correr(){
        System.out.println("Correr como um");
    }

}
