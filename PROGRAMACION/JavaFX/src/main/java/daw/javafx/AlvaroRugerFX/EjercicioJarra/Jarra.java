package daw.javafx.AlvaroRugerFX.EjercicioJarra;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Jarra {

	public int capacidadMaxima;
	public int contenidoActual;

// Visuals
// ***************************
	public ProgressBar pb;
	public Label l;
// ***************************

	public Jarra(int capacidadMaxima, ProgressBar pb, Label l) {
		this.capacidadMaxima = capacidadMaxima;
		this.contenidoActual = 0;
		this.pb = pb;
		this.l = l;
		update();
	}

	// Getters

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public int getContenidoActual() {
		return contenidoActual;
	}

	public void llenar() {
		contenidoActual = capacidadMaxima;

		update();
	}

	public void vaciar() {
		contenidoActual = 0;

		update();
	}

	public int rellenar(int cantidad) {
		int sobrante = 0;
		contenidoActual += cantidad;

		if (contenidoActual > capacidadMaxima) {
			sobrante = contenidoActual - capacidadMaxima;
			llenar();
		}

		update();

		return sobrante;
	}

	public int verter(int cantidad) {
		int sobrante = 0;
		contenidoActual -= cantidad;

		if (contenidoActual < 0) {
			sobrante = Math.abs(contenidoActual);
			vaciar();
		}

		update();

		return sobrante;
	}

	public int traspasar(Jarra otra, int cantidad) {
		int toTrans = Math.min(cantidad, this.contenidoActual);

		int sobrante = otra.rellenar(toTrans);

		verter(toTrans - sobrante);

		return toTrans - sobrante;
	}

	public String toString() {
		return "Jarra(capacidadMaxima = " + capacidadMaxima + ", contenidoActual = " + contenidoActual + ")";
	}

	public void update() {
		l.setText(new String(contenidoActual + "lts de " + capacidadMaxima));

		if (contenidoActual <= 0) {
			pb.setProgress(0);
			return;
		}

		pb.setProgress((double) ((double) contenidoActual / (double) capacidadMaxima));
	}

}