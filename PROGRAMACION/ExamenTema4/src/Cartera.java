
public class Cartera {
	private final int dinero, centimos;

	public Cartera(int dinero, int centimos) {
		int[] normalized = normalize(dinero, centimos);

		this.dinero = normalized[0];
		this.centimos = normalized[1];
	}

	public Cartera sumar(Cartera car) {
		return new Cartera(car.dinero + dinero, car.centimos + centimos);
	}

	@Override
	public String toString() {
		return String.format("%s%d'%02d €", dinero == 0 && centimos < 0 ? "-" : "", dinero, Math.abs(centimos));
	}

	// Metodo para normalizar las cantidades (lo separo para mejor utilizacion)
	private int[] normalize(int d, int c) {
		int fd = d + (int) (c / 100);
		int fc = c % 100;

		int[] farray = { fd, fc };
		return farray;
	}

}
