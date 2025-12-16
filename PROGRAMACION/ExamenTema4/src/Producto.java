
public class Producto {

	private String nombre;
	private int cantidad;

	public Producto(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public void agregarStock(int añadir) {
		// Menos de 0 (negativo), no hace nada (suma 0)
		cantidad += Math.max(añadir, 0);
	}

	public boolean vender(int venta) {
		if (Math.max(venta, 0) > cantidad) {
			return false;
		}

		cantidad -= Math.max(venta, 0);
		return true;
	}

	@Override
	public String toString() {
		return "CÓDIGO: " + nombre + " (" + cantidad + ")";
	}

}
