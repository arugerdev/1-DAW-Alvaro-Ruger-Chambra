package Tema2;

public class EjemploCadenas {
	public static void main(String[] args) {
		String unaCadena = "Cadena de prueba";
		unaCadena = new String("Cadena de prueba 2");
		
		System.out.println("Longitud = " + unaCadena.length());
		
		unaCadena = "uno" + "dos";
		
		unaCadena = "uno".concat("dos");
		
		unaCadena = new String("Uno").concat(new String("dos"));
		
		
		unaCadena.equals("Unodos");
		unaCadena.equalsIgnoreCase("unoDOS");
		
		
	}

}
