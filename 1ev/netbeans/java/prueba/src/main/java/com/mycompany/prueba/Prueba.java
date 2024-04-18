/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba;


import java.util.Scanner; //Para leer lo introducido por texto
//import javax.swing.JOptionPane; //Para mostrar ventana emergente

/**
 *
 * @author Nocturno
 */
public class Prueba {
    public static void main(String[] args) {
        /*Hola mundo*/
        //System.out.println("goofy ahh java shit"); //Hola mundo v.2
        
        
        /*Multiplicación con una variable*/
        /*
	int num; //Declaro variable     
        num = 2; //Le asigno un valor a num
        num = num * 4; //Hago una multiplicación y le asigno ese resultado
        System.out.println(num); //Muestro el resultado 
	*/
        
        
        /*Muestra una ventana emergente*/
        //JOptionPane.showMessageDialog(null,"Ahora mostramos un mensaje emergente.");
        
        
        /*Leer algo pedido al usuario*/
        /* 
	Scanner input = new Scanner (System.in);
        String nombre; //Nombre es tipo string
        System.out.println("¿Cómo te llamas?"); //Pregunto por el nombre
        nombre = input.nextLine(); //A nombre se le asignara la siguiente línea escrita por el usuario
        System.out.println("Hola " + nombre); //Muestra un mensaje + el nombre dado 
	*/
        
        
        /*Pide varios datos al usuario y después los muestra*/
        /* 
	Scanner input = new Scanner (System.in);
        String nombre, direccion, telefono; //Variables que se pediran
        
        System.out.print("Nombre-> "); //Pregunto el nombre
        nombre = input.nextLine(); //Leo y asigno el nombre
        
        System.out.print("Dirección-> "); //Pregunto dirección
        direccion = input.nextLine(); //Leo y asigno la dirección
        
        System.out.print("Número de teléfono-> "); //Pregunto num. teléfono
        telefono = input.nextLine(); //Leo y asigno el teléfono
        
        System.out.println("Nombre: " + nombre + "\nDirección: " + direccion + "\nTelefono: " + telefono); //Muestro todos los datos pedidos 
	*/
        
        
        /* Calcula el volumen de una esfera */
        Scanner input = new Scanner (System.in);
        Double r, v; //Declaro las variables
        
        System.out.print("Escribe el radio de la esfera-> "); //Pregunto por un número
        r = input.nextDouble(); //Lee un número introducido de tipo Double
        
        v= 4.00/3.00 * Math.PI * Math.pow(r, 3.00); //Hace la fórmula del volumen y asigna el resultado a v
        
        System.out.print("El volumen sería: " + v); //Muestra el volumen
    }
}