package Tema2;

import java.time.LocalDate;
import java.util.Scanner;

public class Ejercicio2_5_1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name;
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
		
		System.out.printf("%s naciste el %d-%02d-%d, estamos en %d-%02d-%d y han transcurrido %d dias.",
		name, day, month, year, dayNow, monthNow, yearNow, ((yearNow - year) * 365) + ((monthNow - month) * 30) + (dayNow - day));
		
		s.close();
	}

}
