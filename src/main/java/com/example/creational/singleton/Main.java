package com.example.creational.singleton;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Invoice invoice = new Invoice();
        invoice.calculateTotalPrice();

        Offer offer = new Offer();
        offer.calculateTotalOffer();

        if (invoice.calculator == offer.calculator)
            System.out.println("Mismo objeto calculadora");
    }
}

class Calculator { // singleton

    private static Calculator calculadora;

    private Calculator() {
    }

    public static Calculator getCalculator(){
        if(calculadora == null)
            calculadora = new Calculator();

        return calculadora;
    }

}

class Invoice {

    Calculator calculator = Calculator.getCalculator();

    public double calculateTotalPrice(){
        // algoritmo que utiliza la calculadora
        return 0d;
    }
}

class Offer {

    Calculator calculator = Calculator.getCalculator();

    public double calculateTotalOffer(){
        // algoritmo que utiliza la calculadora
        return 0d;
    }

}

