package mediaNums;

import java.util.Scanner;
public class mediaNums {

	public static void main(String[] args) {
		//Introducir números hasta que uno sea negativo, calcular la media de los anteriores
		/*Scanner input = new Scanner(System.in);
		double num, total, cont;
		total = cont = 0;
		
		do {
		System.out.println("Introduzca un número, para salir introduzca un número negativo: ");
		num = input.nextDouble();
		if (num < 0) {
			break;
		}
		total = total + num;
		cont ++;
		}while(num > -1);
		
		System.out.println("La media de los números introducidos es "+ total / cont);*/
		
		
		//Números del 100 al 0 de 7 en 7
		/*System.out.println("Números del 100 al 0 de 7 en 7:");
		for(int i = 100; i > 0; i -= 7) {
			System.out.print(i +" ");
		}
		System.out.println("0 \nFIN");*/
		
		
		//Tabla de multiplicar
		Scanner input = new Scanner(System.in);
		int num;
		System.out.print("Introduzca un número del 1 al 10: ");
		num = input.nextInt();
		for(int i=1; i<11;i++) {
			System.out.println(num +" x "+ i +"= "+ num * i);
		}
		
	}
}