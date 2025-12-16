package Tema2;
import java.util.Scanner;

public class Pruebas {
	public static void main(String[] args) 
    {
		System.out.print("Inserta un numero: ");
		
        Scanner s = new Scanner(System.in);


        // Reading data using readLine
        long d = s.nextLong();
        System.out.println(d % 2 == 1 ? "Numero Impar" : "Numero Par");
        
        s.close();
    }
}
