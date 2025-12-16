package Tema2;
import java.util.Scanner;

public class Ejercicio2_4_5 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double b, h, a;
		System.out.println("########################################");
		System.out.println("#  Calculadora de areas rectangulares  #");
		System.out.println("########################################");
		System.out.println("");
		System.out.println("□");
		System.out.println("↔\n");
		System.out.println("Inserta la medida de la base: ");
		b = s.nextDouble();
		System.out.println("");
		System.out.println("□↕");
		System.out.println("");
		System.out.println("Inserta la medida de la altura: ");
		h = s.nextDouble();
		
		a = b*h;
		
		System.out.printf("El area del rectangulo es %.2f cm²", a);
		
		s.close();
	}

}
