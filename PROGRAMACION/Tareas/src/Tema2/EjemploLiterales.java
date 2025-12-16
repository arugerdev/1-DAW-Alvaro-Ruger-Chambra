package Tema2;

public class EjemploLiterales {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		boolean unBooleano;
		int unEntero;
		long unLargo;
		float unFlotante;
		double unDoble;
		char unCaracter;
		String unaCadena;
		
		unBooleano = true;
		unBooleano = false;
		
		unEntero = 1;
		unEntero = 013;
		unEntero = 0x77;
		unEntero = 0b01010111;
		
		unLargo = 23L;
		
		unFlotante = 11.4F;
		unFlotante = 11.4E2F;
		
		unDoble = 1.3;
		unDoble = 1.53D;
		unDoble = 1.745F;
		unDoble = 1.3E3;
		
		unCaracter = 'a';
		unCaracter = '\013';
		unCaracter = '\u000E';
		unCaracter = 013;
		unCaracter = 0x000E;
		
		unaCadena = "asdjisa \n Hola!"
				+ "\n \\n <- Salto de linea"
				+ "\n Hola\b´ \\b <- Retroceso"
				+ "\n Esto es \t un tabulador \\t"
				+ "\n \f \\f <- Salto de pagina"
				+ "\n \r \\r <- Retorno de carro"
				+ "Hola!";
		
		System.out.printf(unaCadena);
	}
	
}
