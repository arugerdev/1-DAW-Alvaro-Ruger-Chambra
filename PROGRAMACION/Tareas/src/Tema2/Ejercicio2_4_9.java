package Tema2;
import java.util.Scanner;

public class Ejercicio2_4_9 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double r, h, v;
		System.out.println("#######################################");
		System.out.println("#  Calculadora de volumenes de conos  #");
		System.out.println("#######################################");
		System.out.println("Inserta la medida del radio (cm): ");
		r = s.nextDouble();
		System.out.println("");
		System.out.println("Inserta la medida de la altura (cm) : ");
		h = s.nextDouble();
		
		v = ((Math.PI * Math.pow(r, 2)) * h) / 3;
		
		System.out.printf("El volumen del cono es de %.2f cm³", v);
		
		s.close();
	}

}
