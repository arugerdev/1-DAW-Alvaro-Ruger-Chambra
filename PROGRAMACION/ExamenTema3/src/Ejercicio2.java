import java.util.Scanner;

public class Ejercicio2 {

	// Leer secuencia de ADN (lectura sin fin ¿?)
	// Si contiene exactamente "CCC" positivo, el resto negativo

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (true) {
			boolean positivo = false;
			String sec = "";

			System.out.print("Indica la secuencia: ");
			// Añado un espacio para que a la hora de recorrer la cadena haga otro paso mas para la verificacion final.
			sec = s.nextLine() + " ";
			// Contador de 'C'
			int Cs = 0;
			// Recorremos todo el string
			for (char ch : sec.toCharArray()) {
				// Si es 'C' sumamos el contador
				if (ch == 'C') {
					Cs++;
				} else {
					// Si no es 'C' reseteamos el contador de 'C' segidas pero antes comprobamos si
					// ya tenemos las 3
					if (Cs == 3) {
						positivo = true;
					}

					Cs = 0;
				}
			}

			System.out.println("Resultado: " + (positivo ? "POSITIVO" : "NEGATIVO"));
		}

	}

}
