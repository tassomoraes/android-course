package com.example.myapplication;

class Funcionario {

    //atributos
    String nome;
    double salario;

    //metodos
    double recuperarSalario(double bonus, double descontoAdicional){

        this.salario = this.salario - (this.salario*0.1);
        this.salario = this.salario + bonus - descontoAdicional;
        return  this.salario;

    }

}
