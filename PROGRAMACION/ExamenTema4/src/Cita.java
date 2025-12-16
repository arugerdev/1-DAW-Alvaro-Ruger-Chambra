
// Realizo esta actividad con la utilidad LocalDate y LocalTime de java, pero tambien se podria hacer sin ellas,
// utilizando tipos basicos de java, al no indicarlo en el ejercicio, lo he hecho de esta manera.
import java.time.*;

public class Cita {
	private LocalDate fecha;
	private LocalTime hora;

	public Cita(LocalDate fecha, LocalTime hora) {
		this.fecha = fecha;
		this.hora = hora;
	}

	// Getters and setters
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	//

	public void retrasarSemanas(int cantidadSemanas) {
		// Al sumar 7 * la cantidad de semanas a la fecha, sumaria semanas enteras desde
		// cualquier fecha.
		setFecha(fecha.plusWeeks(cantidadSemanas));
	}

	@Override
	public String toString() {
		return "Cita el dia " + fecha + " a las " + hora;
	}

}
