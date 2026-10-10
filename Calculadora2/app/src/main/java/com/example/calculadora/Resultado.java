package com.example.calculadora;

import java.io.Serializable;

public class Resultado implements Serializable {

    private final String operacion;
    private final double numero1;
    private final double numero2;
    private final double valor;

    public Resultado(String operacion, double numero1, double numero2, double valor) {
        this.operacion = operacion;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.valor = valor;
    }

    public String getOperacion() { return operacion; }
    public double getNumero1() { return numero1; }
    public double getNumero2() { return numero2; }
    public double getValor() { return valor; }
}