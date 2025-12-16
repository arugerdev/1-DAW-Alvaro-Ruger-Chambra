package daw.javafx.AlvaroRugerFX;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Ejercicio {
	public String name = "0";
	public boolean finished = true;
	private static ArrayList<Node> toRemove = new ArrayList<Node>();

	public Ejercicio(String name, boolean finished) {
		this.name = name;
		this.finished = finished;
	}

	public void start(Stage stage) {

	}

	public static Region lineJump(Pane disp) {
		Region p = new Region();
		p.setPrefSize(Double.MAX_VALUE, 0.0);
		disp.getChildren().add(p);
		return p;
	}

	public static void spinnerKeyboard(Spinner s) {
		s.setOnKeyPressed(event -> {
			switch (event.getCode()) {
			case UP:
				s.increment(1);
				break;
			case DOWN:
				s.decrement(1);
				break;
			case RIGHT:
				s.increment(100);
				break;
			case LEFT:
				s.decrement(100);
				break;
			default:
				break;
			}
		});
	}

	public static void clearRemove() {
		toRemove.clear();
	}

	public static void addRemove(Node[] cArray) {
		for (Node control : cArray) {
			toRemove.add(control);
		}
	}

	public static void addRemove(Node control) {
		toRemove.add(control);
	}

	public static void commitRemove(Pane disp) {
		for (Node c : toRemove) {
			disp.getChildren().remove(c);
		}
	}

	public static Label createTextLabel(String text, Pane disp, boolean onLine) {
		if (onLine) {
			lineJump(disp);
		}
		Label l = new Label(text);
		disp.getChildren().add(l);
		return l;
	}
}
