package Tema2;

import java.time.LocalDate;
import java.util.Scanner;

public class Ejercicio2_5_2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name;
		String passed = "tu cumpleaños ya pasó";
		String no_passed = "tu cumpleaños NO ha pasado";
		int day, month, year;
		int yearNow = LocalDate.now().getYear();
		int monthNow = LocalDate.now().getMonthValue();
		int dayNow = LocalDate.now().getDayOfMonth();
		
		System.out.print("Escribe tu nombre: ");
		name = s.nextLine();
		
		System.out.print("Escribe tu fecha de nacimiento (dia): ");
		day = Integer.parseInt(s.nextLine());
		System.out.println("");
		System.out.print("Escribe tu fecha de nacimiento (mes): ");
		month = Integer.parseInt(s.nextLine());
		System.out.println("");
		System.out.print("Escribe tu fecha de nacimiento (año): ");
		year = Integer.parseInt(s.nextLine());
		
		
		System.out.printf("%s naciste el %d-%02d-%d, estamos en %d y han transcurrido %d años, %s este año %d",
		name, day, month, year, yearNow, yearNow - year, monthNow > month ? passed : monthNow == month ? dayNow > day ? passed : no_passed : no_passed , yearNow);
		
		s.close();
	}

}
