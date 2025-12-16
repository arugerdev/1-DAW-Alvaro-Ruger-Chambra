package Tema2;

import javax.swing.JOptionPane;

public class Ejercicio5_2 {
	public static void main(String[] args) {

		int sizeArray = 0;
		do {
			try {
				sizeArray = Integer.parseInt(JOptionPane.showInputDialog("Indica un numero del 1 al 100: "));
			} catch (Exception err) {
				System.exit(1);
			}

		} while (sizeArray < 1 || sizeArray > 100);

		String[] arrayS = new String[sizeArray];

		for (String s : arrayS) {
			System.out.print(s + ", ");
		}

		int pointer = -1;
		do {
			try {
				pointer = Integer
						.parseInt(JOptionPane.showInputDialog("Indica un numero del 0 al " + arrayS.length + ": "));
			} catch (Exception err) {
				System.exit(1);
			}
		} while (pointer < 0 || pointer >= arrayS.length);

		String insertS = JOptionPane.showInputDialog("Indica una cadena de texto a insertar: ");

		arrayS[pointer] = insertS;

		System.out.println("\n");
		
		int c = 0;
		for (String s : arrayS) {
			c++;
			System.out.print(s + (c % 5 == 0 ? ", \n" : ", "));
		}

	}
}
