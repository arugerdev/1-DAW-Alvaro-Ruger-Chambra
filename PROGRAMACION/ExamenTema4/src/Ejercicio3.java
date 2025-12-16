
public class Ejercicio3 {
	public static void main(String[] args) {
		Cartera cart1 = new Cartera(3, 0);
		
		//No accesible, por lo tanto no se puede modificar
		// cart1.dinero
		// cart1.centimos
		
		System.out.println("Cartera 1: " + cart1);
		
		Cartera cart2 = new Cartera(3, 235);
		System.out.println("Cartera 2: " + cart2);
		Cartera cart3 = new Cartera(1, -170);
		System.out.println("Cartera 3: " + cart3);
		
		System.out.println("Suma cartera 2 + 3: " + cart2.sumar(cart3));
		
		Cartera cart4 = new Cartera(-2, -320);
		System.out.println(cart4);
		
	}
}
