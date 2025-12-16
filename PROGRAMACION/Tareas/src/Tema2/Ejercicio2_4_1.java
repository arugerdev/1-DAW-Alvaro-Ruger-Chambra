package Tema2;

import java.util.Scanner;

public class Ejercicio2_4_1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double a,b,r;
		
		System.out.print("Introduce un numero: ");
		a = s.nextDouble();
		System.out.println("");
		System.out.print("Introduce otro numero: ");
		b = s.nextDouble();
		System.out.println("");
		r = a * b;
		System.out.printf("%s x %s = %s", a,b,r);
		
		s.close();
	}

}
