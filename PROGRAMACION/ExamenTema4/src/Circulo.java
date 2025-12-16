
public class Circulo {

	private static int circulosCreados = 0;

	private final double PI = Math.PI;

	private int x, y;
	private double radio;

	public Circulo(int x, int y, double radio) {
		this.x = x;
		this.y = y;
		this.radio = radio;

		circulosCreados++;
	}

	public double calcularArea() {
		return PI * Math.pow(radio, 2);
	}

	public double calcularCircunferencia() {
		return 2 * PI * radio;
	}

	public static int getCirculosCreados() {
		return circulosCreados;
	}

}
