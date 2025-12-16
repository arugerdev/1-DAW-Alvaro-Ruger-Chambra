package daw.javafx.AlvaroRugerFX.EjercicioLibro;

public class Libro {

	public String titulo;
	public String autor;
	public int numeroPaginas;
	public String isbn;
	public int ejemplaresExistentes;
	public int ejemplaresPrestados;
	
	public Libro(String titulo, String autor, int numeroPaginas, String isbn, int ejemplaresExistentes) {
		this.titulo = titulo;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.ejemplaresExistentes = ejemplaresExistentes;
		this.ejemplaresPrestados = 0;
	}

	// Getters
	
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public int getNumPag() {
		return numeroPaginas;
	}
	public String getIsbn() {
		return isbn;
	}
	public int getEjemplaresExistentes() {
		return ejemplaresExistentes;
	}
	
	// Setters
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setNumPag(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setEjemplaresExistentes(int ejemplaresExistentes) {
		this.ejemplaresExistentes = ejemplaresExistentes;
	}
	
	
	// Methods
	public int getEjemplaresDisponibles() {
		return ejemplaresExistentes - ejemplaresPrestados;
	}
	
	public String prestar() {
		if(this.getEjemplaresDisponibles() <= 0) {
			return "ERROR: No quedan ejemplares de: " + this.titulo + ".";
		}
		
		this.ejemplaresPrestados++;
		return "Se ha prestado un ejemplar de " + this.titulo  +". Quedan " + this.getEjemplaresDisponibles() + " ejemplares para prestar.";
	}
	
	public String devolver() {
		if(this.ejemplaresPrestados <= 0) {
			return "ERROR: No quedan ejemplares por devolver de: " + this.titulo + ".";
		}
		
		this.ejemplaresPrestados--;
		return "Se ha devuelto un ejemplar de " + this.titulo  +". Quedan " + this.getEjemplaresDisponibles() + " ejemplares para prestar.";
	}
	
	public String toString() {
		return "Libro(titulo = " + titulo + ", autor = " + autor + ", numPags = " + numeroPaginas + ", isbn = " + isbn + ", ejempExis = " + ejemplaresExistentes + ", ejempPrest = " + ejemplaresPrestados +")";
	}
}
