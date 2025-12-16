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

public class Ejercicio3_3_3 extends Ejercicio{

	public Ejercicio3_3_3(String name, boolean finished) {
		super(name, finished);
	}

	//	El sorteo de la ONCE, la Lotería Nacional y otras apuestas más usan un sistema de números que se compone de cinco dígitos del 0 al 9, para generar números entre 00000 y 99999. Realiza un programa que genere una secuencia de 5 números aleatorios usando un bucle for() donde en cada iteración se genere un dígito distinto. Presenta esos 5 números consecutivamente en la misma línea.
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.3 3. El sorteo de la ONCE, la Lotería Nacional y otras apuestas más usan un sistema de números que se \n"
				+ "compone de cinco dígitos del 0 al 9, para generar números entre 00000 y 99999. Realiza un programa que genere una secuencia \n"
				+ " de 5 números aleatorios usando un bucle for() donde en cada iteración se genere un dígito distinto. \n"
				+ "Presenta esos 5 números consecutivamente en la misma línea."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Generador loteria "));
		
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		
    	Button submit = new Button("Generar");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		String lot = "";
    		for (int i = 0; i < 5; i++) {
    			int v = (int)(Math.random() * 10);

    			lot += v;
    		}
    		
    		disp.getChildren().add(new Label("El numero ganador es: " + lot));
        	lineJump(disp);

    		
    	});
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Generar ONCE");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
