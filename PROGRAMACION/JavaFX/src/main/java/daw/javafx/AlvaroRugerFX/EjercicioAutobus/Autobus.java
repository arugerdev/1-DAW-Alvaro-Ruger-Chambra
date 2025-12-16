package daw.javafx.AlvaroRugerFX.EjercicioAutobus;

import java.time.LocalTime;

public class Autobus {
	public String matricula;
	public String ruta_origen, ruta_destino;
	public LocalTime tiempo_partida;
	public int asientos;
	public int asientos_reservados;

	public Autobus(String matricula, String ruta_origen, String ruta_destino, LocalTime hora, int asientos_dispo) {
		this.matricula = matricula;
		this.ruta_origen = ruta_origen;
		this.ruta_destino = ruta_destino;
		this.tiempo_partida = hora;
		this.asientos = asientos_dispo;
	}

	public int asientosDisp() {
		return asientos - asientos_reservados;
	}

	public int asientosReservados() {
		return asientos_reservados;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public String Reservar() {
		if (asientosDisp() > 0) {
			asientos_reservados++;
			return "Reservado correctamente 1 asiento";
		}

		return "Error: No quedan asientos disponibles.";
	}

	public String Cancelar() {
		if (asientosReservados() > 0) {
			asientos_reservados--;
			return "Cancelada correctamente la reserva de 1 asiento";
		}

		return "Error: No hay reservas disponibles para cancelar.";
	}

	@Override
	public String toString() {
		return "Autobus [matricula=" + matricula + ", ruta_origen=" + ruta_origen + ", ruta_destino=" + ruta_destino
				+ ", tiempo_partida=" + tiempo_partida + ", asientos=" + asientos + ", asientos_reservados="
				+ asientos_reservados + "]";
	}
	
	
}
