// Los ejercicios tienen su clase main de prueba separadas de la clase a probar,
// es mas comodo asi para organizar los ejercicios y ver que se utiliza en cada uno.

public class Ejercicio1 {

	public static void main(String[] args) {
		Producto prod1 = new Producto("Arbol navidad", 10);

		System.out.println(prod1);

		prod1.agregarStock(3);
		prod1.agregarStock(-5);

		System.out.println(prod1);

		System.out.println("Se pudo vender: " + prod1.vender(10));

		System.out.println(prod1);

		System.out.println("Se pudo vender: " + prod1.vender(10));

		System.out.println(prod1);
	}

}
