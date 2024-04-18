package org.example;

import java.util.Random;

public class Mago extends Personaje{

    // Constructores
    public Mago(int _ataque, int _defensa, int _vida, String _nombre) {
        super(_ataque, _defensa, _vida, _nombre);
    }

    // Métodos
    public int curacion() throws Exception{
        if(getVida()>90){
            throw new Exception ("No puedes curarte, tu vida está al máximo");
        }
        Random r = new Random();
        if (r.nextInt(0,100)>30 || getVida()>90){
            return 0;
        }else{
            return 10;
        }
    }

    @Override
    public int atacar(){
        Random r = new Random();
        // Ataque mínimo 1, máximo según su atributo de ataque
        int puntosAtaque = r.nextInt(1, getAtaque()+1);
        if(ataqueCritico()){
            System.out.println(getNombre() + " ha lanzado un hechizo!");
            return puntosAtaque*2;
        }else{
            return puntosAtaque;
        }
    }




}
