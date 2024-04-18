/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aritmeticatest;

/**
 *
 * @author Nocturno
 */
public class Aritmetica {
    private double num1;
    private double num2;

    public Aritmetica(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    public double suma(){
        return num1 + num2;
    }
    public double resta(){
        return num1 - num2;
    }
    public double mult(){
        return num1 * num2;
    }
    public double divi(){
        return num1 / num2;
    }
    
}
