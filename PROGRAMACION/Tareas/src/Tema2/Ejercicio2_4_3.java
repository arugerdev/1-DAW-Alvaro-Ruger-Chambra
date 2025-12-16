package Tema2;

import java.util.Scanner;

public class Ejercicio2_4_3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double input, result;
		System.out.println("##################################");
		System.out.println("#  Conversor de Pesetas a Euros  #");
		System.out.println("##################################");
		System.out.println("");
		
		System.out.print("Inserta las pesetas a convertir: ");
		input = s.nextDouble();
		
		result = input <= 0 ? 0 : input / 166.386;
		
		System.out.println("");
		System.out.printf("%.2f pesetas son %.2f euros.", input, result);
		
		s.close();
	}

}
