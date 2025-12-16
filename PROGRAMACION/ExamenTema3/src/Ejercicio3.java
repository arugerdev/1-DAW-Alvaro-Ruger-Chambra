import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int altura = 1;

		System.out.print("Introduce una altura: ");
		altura = s.nextInt();

		if ((altura % 2) == 0) {
			System.out.println("Error: la altura debe de ser impar.");
			return;
		}

		for (int row = 0; row < altura; row++) {
			String c = "*";
			
			for (int col = 0; col < altura; col++) {

				if (row <= altura / 2) {
					if (col < row) {
						c += "*";
					}
				}
				if (row > altura / 2) {
					if (col > row) {
						c += "*";
					}
				}
			}
			
			System.out.println(c);
		}
	}

}
