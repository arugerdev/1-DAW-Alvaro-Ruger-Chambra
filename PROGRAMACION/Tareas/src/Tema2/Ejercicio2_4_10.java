package Tema2;

import java.util.Scanner;

public class Ejercicio2_4_10 {
	
	enum DataType {B,KB,MB,GB};
	
	public static DataType getType(String input) {
		switch(input.toUpperCase()) {
		case "MB":
			return DataType.MB;
		case "KB":
			return DataType.KB;
		case "B":
			return DataType.B;
		case "GB":
			return DataType.GB;
		default:
			return DataType.MB;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		DataType type, convertTo;
		double input, result;
		
		System.out.println("########################");
		System.out.println("#  Conversor de bytes  #");
		System.out.println("########################");
		System.out.println("");
		System.out.println("Ingresa el tipo de dato (MB, KB, B, GB ...): ");
		type = getType(s.nextLine().toUpperCase());
		
		System.out.printf("Ingresa la cantidad (%s): ", String.valueOf(type));
		input = Double.parseDouble(s.nextLine());
		
		System.out.println("Ingresa el tipo de dato a convertir (MB, KB, B, GB ...): ");
		convertTo = getType(s.nextLine().toUpperCase());
		
		int steps = Math.abs(type.ordinal() - convertTo.ordinal());
		double temp = input;
		for (int i = 0; i<steps; i++) {
			if(type.ordinal() - convertTo.ordinal() < 0) {				
			temp = temp / 1024;
			}
			else
			{
			temp = temp * 1024;
			}
		}
		
		result = temp;
		
		System.out.printf("El resultado de %.2f%s convertido a %s es de: %.2f%s", input, type, convertTo, result, convertTo);

		s.close();
	}

}
