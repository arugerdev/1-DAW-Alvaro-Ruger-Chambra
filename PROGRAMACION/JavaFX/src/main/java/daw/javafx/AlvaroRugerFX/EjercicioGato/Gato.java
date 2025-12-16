package daw.javafx.AlvaroRugerFX.EjercicioGato;

public class Gato {
	
	public enum Sex{MACHO, HEMBRA, HERMAFRODITA}
	

	public String nombre;
	public String color;
	public String raza;
	public Sex sexo;
	public int peso;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Gato(String nombre, String color, String raza, Sex sexo, int peso) {
		this.nombre = nombre;
		this.color = color;
		this.raza = raza;
		this.sexo = sexo;
		this.peso = peso;
	}


	// Setters
	public void setNombre(String newNombre) {
		this.nombre = newNombre;
	}
	public void setColor(String newColor) {
		this.color = newColor;
	}
	public void setRaza(String newRaza) {
		this.raza = newRaza;
	}
	public void setSex(Sex newSexo) {
		this.sexo = newSexo;
	}
	public void setPeso(int newPeso) {
		this.peso = newPeso;
	}
	
	// Getters
	public String getNombre() {
		return this.nombre;
	}
	public String getColor() {
		return this.color;
	}
	public String getRaza() {
		return this.raza;
	}
	public Sex getSex() {
		return this.sexo;
	}
	public int getPeso() {
		return this.peso;
	}
	
	// Methods
	
	public void comer(int gramos) {
		this.peso += gramos;
		this.peso = Math.min(this.peso, 10000);

	}
	
	public void correr(int minutos) {
		this.peso -= 10*(minutos / 60);
		this.peso = Math.max(this.peso, 0);
	}
	
	public String maullar() {
		return " Miau! ";
	}
	
	public String saludar() {
		return "¡Hola!, me llamo " + nombre;
	}
	
	public String toString() {
		return "Gato(nombre = " + nombre + ", color = " + color + ", raza = " + raza + ", peso = " + peso + ")";
	}
}
