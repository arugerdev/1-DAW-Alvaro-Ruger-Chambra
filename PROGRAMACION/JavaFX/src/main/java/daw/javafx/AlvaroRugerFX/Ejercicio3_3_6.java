package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_3_6 extends Ejercicio{

	public Ejercicio3_3_6(String name, boolean finished) {
		super(name, finished);
	}

	//	Escribe un programa que pida una base y un exponente (entero positivo) y que calcule la potencia. Realiza el cálculo con un bucle for() donde el número de iteraciones sea el valor del exponente. En cada vuelta puedes usar el operador *= para ir almacenando el cálculo hasta ese momento.
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.3 6. Escribe un programa que pida una base y un exponente (entero positivo) y que calcule la potencia. \n"
				+ "Realiza el cálculo con un bucle for() donde el número de iteraciones sea el valor del exponente. \n"
				+ "En cada vuelta puedes usar el operador *= para ir almacenando el cálculo hasta ese momento."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Calculador de potencias "));
		
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		disp.getChildren().add(new Label("Base: "));
    	Spinner<Integer> base = new Spinner<>(1, Integer.MAX_VALUE, 5);
		spinnerKeyboard(base);

		disp.getChildren().add(base);
    	
    	lineJump(disp);
		disp.getChildren().add(new Label("Exponente: "));
    	Spinner<Integer> expo = new Spinner<>(1, Integer.MAX_VALUE, 5);
		spinnerKeyboard(expo);

		disp.getChildren().add(expo);
    	
    	lineJump(disp);
    	
    	Button submit = new Button("Calcular");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		long acum = 1;
    		for (int i = 0; i < expo.getValue(); i++) {
    			acum *= base.getValue();
    		}
    		
    		disp.getChildren().add(new Label("El resultado es: " + acum));
        	lineJump(disp);

    		
    	});
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Calcular potencia");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
