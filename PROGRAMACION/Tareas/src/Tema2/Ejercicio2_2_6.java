package Tema2;

public class Ejercicio2_2_6 {
	
	enum Estaciones {Otoño, Invierno, Primavera, Verano}
	enum Continentes {África, América, Asia, Europa, Oceanía}
	public static void main(String[] args) {
		Estaciones a = Estaciones.Verano;
		Continentes b = Continentes.Asia;
		
		System.out.println(a);
		System.out.println(b);
		
		a = Estaciones.Invierno;
		b = Continentes.Europa;
		
		System.out.println(a);
		System.out.println(b);
	}

}
