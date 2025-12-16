package Tema2;

import java.util.Scanner;

public class Ejercicio2_4_4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double a,b,r;
		System.out.println("############################");
		System.out.println("#  Calculadora matemática  #");
		System.out.println("############################");
		System.out.println("");
		
		System.out.print("Inserta el primer número: ");
		a = s.nextDouble();
		
		System.out.print("Inserta el segundo número: ");
		
		b = s.nextDouble();
		
		System.out.println("");

		r = a + b;
		System.out.printf("SUMA: %.1f + %.1f = %.1f \n", a,b,r);
		r = a - b;
		System.out.printf("RESTA: %.1f - %.1f = %.1f \n", a,b,r);
		r = a * b;
		System.out.printf("MULTIPLICACION: %.1f x %.1f = %.1f \n", a,b,r);
		r = a / b;
		System.out.printf("DIVISION: %.1f / %.1f = %.1f \n", a,b,r);
		
		s.close();
	}

}
