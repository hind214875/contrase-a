/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contsenia;

import java.util.Random;

/**
 *
 * @author hinda
 */
public class Contraseña {
    //metodos

    private static int GeneraEnteroAleatorio(int a, int b) {//una metodo para generar un numero Intero en un rango
        Random rd = new Random();
        int numeroAleatorio;
        if (a > b) {
            numeroAleatorio = rd.nextInt(a - b + 1) + b;
        } else {
            numeroAleatorio = rd.nextInt(b - a + 1) + a;//nextInt(max - min + 1) + min;
        }

        return numeroAleatorio;

    }

    private static boolean sumaImpar(int digito1, int digito2) {//metodo que devuelve si la suma de dos enteros par o impar   
        return (digito1 + digito2) % 2 != 0;
    }
    
    private static boolean MultiplicacionPar(int digito1,int digito2){
      return (digito1 * digito2)%2 == 0;
    }
    
    public static void main(String[] args) {
        //declaracion de variables
        int numero1, numero2, numero3, numero4;
        char c;

        //Constantes
        int MINCHAR = 70, MAXCHAR = 88, MIN = 0, MAX = 9;

        do {// boucle que se repeta cuando uno de los condiciones no es valida
             
            //genera numero aleatorio para cada numero
            numero1 = GeneraEnteroAleatorio(MIN, MAX);
            numero2 = GeneraEnteroAleatorio(MIN, MAX);
            numero3 = GeneraEnteroAleatorio(MIN, MAX);
            numero4 = GeneraEnteroAleatorio(MIN, MAX);

            do {//se repita si numero 2 y 1 egual cambia el valor de numero2 y genera numero2 otravez
                numero2 = GeneraEnteroAleatorio(MIN, MAX);
            } while (numero1 == numero2);

            do {//se repete si el numero3 egual a numero2 o numero1 y genra numero3 otravez
                numero3 = GeneraEnteroAleatorio(MIN, MAX);
            } while (numero2 == numero3 || numero3 == numero1);

            do {//se repete si numero3 egual numero4 o numero1 para generar otravez numero4
                numero4 = GeneraEnteroAleatorio(MIN, MAX);
            } while (numero3 == numero4 || numero4 == numero1);

            //genera letra aleatoria utilisando el metodo GeneraEnteroAleatorio()
            c = (char) GeneraEnteroAleatorio(MINCHAR,MAXCHAR);
            
            if (!(sumaImpar(numero1, numero4)) || (sumaImpar(numero2, numero3))) {//si una de las condiciones no es valida contraseña no es valida
                System.out.println("Contraseña no es valida: " + numero1 + numero2 + numero3 + numero4 + c);
            }
        } while (!(sumaImpar(numero1, numero4)) || !(MultiplicacionPar(numero2, numero3)));//se repete la buclo y genera otra contraseña

        System.out.println("la contraseña es valida: " + numero1 + numero2 + numero3 + numero4 + c);
    }

}
