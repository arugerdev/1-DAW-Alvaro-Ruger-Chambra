package daw.javafx.AlvaroRugerFX;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_3_1 extends Ejercicio{

	public Ejercicio3_3_1(String name, boolean finished) {
		super(name, finished);
	}

	//	Se pide un programa que pida inicialmente un número entero. Ese número indicará la cantidad de personas de las que queremos introducir nombre y DNI. Realiza un bucle for() para la entrada del total de esos datos personales, grabando los valores de cada persona en la misma variable que la anterior (por lo cual se pierden los datos anteriores, pero esto ahora no nos importa que suceda).
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.3 1. Se pide un programa que pida inicialmente un número entero. \n"
				+ "Ese número indicará la cantidad de personas de las que queremos introducir nombre y DNI. \n"
				+ "Realiza un bucle for() para la entrada del total de esos datos personales, \n"
				+ "grabando los valores de cada persona en la misma variable que la anterior \n"
				+ "(por lo cual se pierden los datos anteriores, pero esto ahora no nos importa que suceda)."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Inserta la cantidad de personas a introducir (1,15): "));
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		
		Spinner<Integer> n = new Spinner<>(1, 15, 1);
		spinnerKeyboard(n);

		disp.getChildren().add(n);

		lineJump(disp);
    	
		
    	Button submit = new Button("Crear");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		disp.getChildren().remove(title);
    		disp.getChildren().remove(n);
    		disp.getChildren().remove(submit);

    		for (int i = 0; i < n.getValue(); i++) {
    			
    			Label p = new Label("PERSONA " +( i + 1));
    			
    	        TextField nameField = new TextField();
    	        TextField dniField = new TextField();

    	        Label nameLabel = new Label("Nombre: ");
    	        Label dniLabel = new Label("DNI: ");
    	        
    			HBox nameBox = new HBox(10);
    			HBox dniBox = new HBox(10);
    			
    			nameBox.getChildren().addAll(nameLabel, nameField);
    			dniBox.getChildren().addAll(dniLabel, dniField);

    			VBox root = new VBox(10);
		        root.getChildren().addAll(p, nameBox, dniBox);
		        root.setPadding(new Insets(10,10,10,10));
		    	root.setStyle("-fx-background-color: #CCCCCC; ");
				disp.getChildren().add(root);
			}
    		
    	});
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Cantidad de caracteres");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
}
