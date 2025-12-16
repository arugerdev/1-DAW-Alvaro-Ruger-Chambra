package Tema2;

public class EjemploEnum {

	public enum DiasSemana {Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo};
	
	public static void main(String[] args) {
		DiasSemana diafav;
		diafav = DiasSemana.Viernes;
		
		System.out.printf("%s\n", diafav);

	}

}
