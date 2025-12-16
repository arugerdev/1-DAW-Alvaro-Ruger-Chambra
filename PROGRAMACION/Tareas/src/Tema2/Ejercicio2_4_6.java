package Tema2;
import java.util.Scanner;

public class Ejercicio2_4_6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double b, h, a;
		System.out.println("########################################");
		System.out.println("#  Calculadora de areas triangulares  #");
		System.out.println("########################################");
		System.out.println("");
		System.out.println("Δ");
		System.out.println("↔\n");
		System.out.println("Inserta la medida de la base: ");
		b = s.nextDouble();
		System.out.println("");
		System.out.println("Δ↕");
		System.out.println("");
		System.out.println("Inserta la medida de la altura: ");
		h = s.nextDouble();
		
		a = (b*h) / 2;
		
		System.out.printf("El area del triangulo es %.2f cm²", a);
		
		s.close();
	}

}
