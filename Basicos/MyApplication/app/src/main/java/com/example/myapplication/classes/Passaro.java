package com.example.myapplication.classes;

class Passaro extends Animal{

    void voar(){
        System.out.println("Voar como um passaro");
    }

    void correr(){
        super.correr();
        System.out.println("passaro");
    }

    void dormir(){
        super.dormir();
        System.out.println("passaro");
    }

}
