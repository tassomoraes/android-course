package com.example.myapplication;

public class Conta {

    private int numeroConta;
    private double saldo = 100;

    public double recuperarSaldo(){
        return this.saldo;
    }

    void depositar(double valorDeposito){
        this.saldo = this.saldo + valorDeposito;
    }

    void sacar(double valorSaque){
        this.saldo = this.saldo - valorSaque;
    }

}
