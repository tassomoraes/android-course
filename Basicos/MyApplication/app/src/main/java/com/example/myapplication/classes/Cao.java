package com.example.myapplication.classes;

class Cao extends Animal {

    void latir (){
        System.out.println("Latir como um cão");
    }

    void dormir(){
        super.dormir();
        System.out.println("cão");
    }

    void correr(){
        super.correr();
        System.out.println("cão");
    }

}
