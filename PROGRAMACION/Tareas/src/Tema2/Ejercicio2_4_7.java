package Tema2;
import java.util.Scanner;

public class Ejercicio2_4_7 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double base, iva = 21.0, result;
		System.out.println("#######################################");
		System.out.println("#  Calculadora de precio total + IVA  #");
		System.out.println("#######################################");
		System.out.println("");
		System.out.println("Inserta el dinero base: ");
		base = s.nextDouble();
		System.out.println("Inserta el iva (Por defecto 21%): ");
		iva = s.nextDouble() > 0 ? s.nextDouble() : 21D;
		
		result = base + (base * iva / 100.0);
		
		System.out.printf("El precio total de la factura con base"
				+ " %.2f €, con IVA al %.2f %%,"
				+ " son: %.2f €", base,iva,result);
		
		s.close();
	}

}
