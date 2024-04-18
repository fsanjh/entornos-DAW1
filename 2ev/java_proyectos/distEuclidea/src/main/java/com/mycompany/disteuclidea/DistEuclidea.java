
/**
 *
 * @author fsanj
 */

package com.mycompany.disteuclidea;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DistEuclidea {
  //Calcula la distancia usando la función
    public static double distancia_euclidea(double [][] posiciones){
        double resul, x, y;
        x = Math.pow((posiciones[1][0] - posiciones [0][0]), 2);
        y = Math.pow((posiciones[1][1] - posiciones [0][1]), 2);
        resul = Math.sqrt(x + y);
        
        
        return resul;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double [][] posiciones = new double [2][2]; //Array para las posiciones X1, Y1 || X2, Y2
        double num = 0;
        boolean error = false;
        
        System.out.println("Introduce dos puntos de coordenadas");
        do{
            System.out.print("  Coordenada X1: ");
            try{
                num = input.nextDouble();
                error = false;
            }catch(InputMismatchException e){
                System.out.println("Por favor, ingrese un número real válido");
                input.nextLine();
                error = true;
           }
        }while(error);
        posiciones[0][0] = num; //Mete la posicion en el array
        
        do{
            System.out.print("  Coordenada Y1: ");
            try{
                num = input.nextDouble();
                error = false;
            }catch(InputMismatchException e){
                System.out.println("Por favor, ingrese un número real válido");
                input.nextLine();
                error = true;
           }
        }while(error);
        posiciones[0][1] = num;
        
        System.out.println("------------------");
        
        do{
            System.out.print("  Coordenada X2: ");
            try{
                num = input.nextDouble();
                error = false;
            }catch(InputMismatchException e){
                System.out.println("Por favor, ingrese un número real válido");
                input.nextLine();
                error = true;
           }
        }while(error);
        posiciones[1][0] = num;
        
        do{
            System.out.print("  Coordenada Y2: ");
            try{
                num = input.nextDouble();
                error = false;
            }catch(InputMismatchException e){
                System.out.println("Por favor, ingrese un número real válido");
                input.nextLine();
                error = true;
           }
        }while(error);
        posiciones[1][1] = num;
        
        System.out.println("La distancia entre las dos posiciones es de: "+ String.format("%.2f",distancia_euclidea(posiciones)));
    }
}
