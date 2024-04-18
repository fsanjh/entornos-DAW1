package org.example;

import java.util.Random;

public abstract class Personaje {

    // Atributos
    private int ataque;
    private int defensa;
    private int vida;
    private String nombre;


    // Constructores
    public Personaje(int _ataque, int _defensa, int _vida, String _nombre){
        ataque = _ataque;
        defensa = _defensa;
        vida = _vida;
        nombre = _nombre;
    }

    // Métodos
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean ataqueCritico() {
        Random r = new Random();
        return (r.nextInt(0, 100) < 15);
    }

    public int atacar(){
        Random r = new Random();
        // Ataque mínimo 1, máximo según su atributo de ataque
        int puntosAtaque = r.nextInt(1, ataque+1);
        if(ataqueCritico()){
            System.out.println("El ataque de " + nombre + " ha salido crítico!");
            return puntosAtaque*2;
        }else{
            return puntosAtaque;
        }
    }

    public int defender(){
        Random r = new Random();
        // Defensa mínimo 1, máximo según su atributo de defensa
        return r.nextInt(1,defensa+1);
    }

    public boolean isDead(){
        return vida<1;
    }
}