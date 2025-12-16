package Tema2;

import java.util.Scanner;

public class Ejercicio2_4_2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double input, result;
		System.out.println("#################################");
		System.out.println("#  Conversor de Euro a Pesetas  #");
		System.out.println("#################################");
		System.out.println("");
		
		System.out.print("Inserta los euros a convertir: ");
		input = s.nextDouble();
		
		result = input * 166.386;
		
		System.out.println("");
		System.out.printf("%s euros son %s pesetas.", input, result);
		
		s.close();
	}

}
