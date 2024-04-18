/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo10_rectangulo;

/**
 *
 * @author Nocturno
 */
public class Rectangulo {
    private int ancho;
    private int largo;
    
    public Rectangulo(int _ancho, int _largo){
        this.ancho = _ancho;
        this.largo = _largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }
    
    public int getArea (){
        return this.ancho * this.largo;
    }
    
    
}
