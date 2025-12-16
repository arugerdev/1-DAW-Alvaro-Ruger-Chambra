package daw.javafx.AlvaroRugerFX;


import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_3_5 extends Ejercicio{

	public Ejercicio3_3_5(String name, boolean finished) {
		super(name, finished);
	}

	//	Crea un programa que simule la Lotería Primitiva (sin n.º complementario), compuesta por seis números enteros aleatorios entre 1 y 49. (puede ser que genere números repetidos, pero no haremos control de esto)
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.3 5. Crea un programa que simule la Lotería Primitiva (sin n.º complementario), \n"
				+ " compuesta por seis números enteros aleatorios entre 1 y 49. (puede ser que genere números repetidos, \n"
				+ " pero no haremos control de esto)"));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Generador Primitiva "));
		
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		
    	Button submit = new Button("Generar");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		String lot = "";
    		for (int i = 0; i < 6; i++) {
    			int v = (int)(Math.random() * 49) + 1;

    			lot += v + (i < 5 ?" - ":"");
    		}
    		
    		disp.getChildren().add(new Label("El numero ganador es: " + lot));
        	lineJump(disp);

    		
    	});
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Calcular Fractal");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
