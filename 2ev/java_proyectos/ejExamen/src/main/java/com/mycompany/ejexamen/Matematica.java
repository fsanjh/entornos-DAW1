package com.mycompany.ejexamen;

/**
 *
 * @author fsanj
 */
public class Matematica{
    private int a;
    private int b;

    public Matematica(int a, int b){
        this.a = a;
        this.b = b;
    }
    
    public int sumar(){
        return a + b;
    }
    
    public int multiplicacion(){
        return a * b;
    }
    
    public int restar(){
        if( a > b){
            return a - b;
        }else{
            return 0;
        }
    }
    
    
    
}
