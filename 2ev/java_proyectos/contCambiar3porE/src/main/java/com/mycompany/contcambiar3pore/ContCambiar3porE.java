
/**
 *
 * @author fsanj
 */

package com.mycompany.contcambiar3pore;

public class ContCambiar3porE {
    public static void main(String[] args) {
        int cont1 = 0;
        String nums;
        do{
            nums = String.format("%05d", cont1);
//%= donde se inicia el tipo de formato, 0= se rellena con ceros, 5= cantidad mínima de caracteres, d= tipo de números
            nums = nums.replace("3", "E"); //Cambia en el string los 3 por E
            System.out.println(nums);
            cont1++;
        }while(cont1 < 100000);
    }
}
