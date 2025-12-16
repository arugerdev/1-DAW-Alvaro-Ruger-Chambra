import java.time.*;

public class Ejercicio4 {

	public static void main(String[] args) {
		Cita cita1 = new Cita(LocalDate.now(), LocalTime.now());

		System.out.println(cita1);

		System.out.println("Fecha:" + cita1.getFecha());
		System.out.println("Hora:" + cita1.getHora());

		cita1.setFecha(LocalDate.parse("2026-01-25"));
		cita1.setHora(LocalTime.parse("10:00"));

		System.out.println(cita1);

		System.out.println("Retrasamos 2 semanas: ");
		cita1.retrasarSemanas(2);

		System.out.println(cita1);

	}

}
