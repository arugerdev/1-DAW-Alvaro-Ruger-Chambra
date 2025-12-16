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

public class Ejercicio3_11 extends Ejercicio{

	public Ejercicio3_11(String name, boolean finished) {
		super(name, finished);
	}

	//	Escribe un programa que dada una hora determinada (horas y minutos), calcule los segundos que faltan para llegar a la medianoche.
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("11. Escribe un programa que dada una hora determinada (horas y minutos), calcule los segundos que faltan para llegar a la medianoche."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Inserta el tiempo (horas y minutos)"));
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		
		Spinner<Integer> hours = new Spinner<>(0, 23, 12);
		Spinner<Integer> minutes = new Spinner<>(0, 59, 30);

		spinnerKeyboard(hours);
		spinnerKeyboard(minutes);
		
		disp.getChildren().add(hours);
		disp.getChildren().add(new Label(":"));
		disp.getChildren().add(minutes);
		
    	lineJump(disp);
    	
    	Button submit = new Button("Calcular");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		int h = 24 - hours.getValue();
    		int m = h * 60 - minutes.getValue();
    		int s =  m * 60;
    		
    		disp.getChildren().add(new Label("Quedan " + s + " segundos para llegar a la media noche (00:00)"));

    	});
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Calculadora segundos hasta medianoche");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
