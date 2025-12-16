package Tema2;
import java.util.Scanner;

public class Ejercicio2_4_8 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double hours, pricePerHour = 12, result;
		System.out.println("####################################");
		System.out.println("#  Calculadora de salario semanal  #");
		System.out.println("####################################");
		System.out.println("");
		System.out.print("Cuantas horas has realizado esta semana? : ");
		hours = s.nextDouble();

		result = hours * pricePerHour;
		
		System.out.printf("Las horas son pagadas a %.2f€. "
				+ "Por lo tanto, el salario semanal es de %.2f€ "
				+ "(%.2f€/dia)", pricePerHour, result, result / 5);
		
		s.close();
	}
}