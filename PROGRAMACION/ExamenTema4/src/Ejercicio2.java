
public class Ejercicio2 {

	public static void main(String[] args) {
		System.out.println(Circulo.getCirculosCreados());

		Circulo cir1 = new Circulo(10, 5, 6.5);

		System.out.println(Circulo.getCirculosCreados());

		System.out.println("Circulo 1");
		System.out.println("Area: " + cir1.calcularArea());
		System.out.println("Circunferencia: " + cir1.calcularCircunferencia());

		Circulo cir2 = new Circulo(3, 4, 9.5);
		Circulo cir3 = new Circulo(-1, 7, 3.5);

		System.out.println(Circulo.getCirculosCreados());

		System.out.println("Circulo 2");
		System.out.println("Area: " + cir2.calcularArea());
		System.out.println("Circunferencia: " + cir2.calcularCircunferencia());

		System.out.println("Circulo 3");
		System.out.println("Area: " + cir3.calcularArea());
		System.out.println("Circunferencia: " + cir3.calcularCircunferencia());

	}

}
