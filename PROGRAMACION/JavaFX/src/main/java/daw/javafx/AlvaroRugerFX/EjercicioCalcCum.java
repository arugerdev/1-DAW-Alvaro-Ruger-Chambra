package daw.javafx.AlvaroRugerFX;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class EjercicioCalcCum extends Ejercicio {

	public EjercicioCalcCum(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
    	GridPane disp = new GridPane();
    	
    	disp.setPadding(new Insets(20,20,20,20));
    	disp.setHgap(40);
    	disp.setVgap(30);
    	
    	Text title = new Text(String.format("Calculadora de cumpleaños"));
    	title.setFont(Font.font(24));
    	disp.add(title, 0, 0, 2, 1);

    	Label nameTag = new Label("Nombre");
    	TextField nameField = new TextField();
    	disp.add(nameTag, 0, 1);
    	disp.add(nameField, 1, 1);
    	
    	Label dateTag = new Label("Fecha de nacimiento");
    	DatePicker dateField = new DatePicker();
    	disp.add(dateTag, 0, 2);
    	disp.add(dateField, 1, 2);
    	
    	Button submit = new Button("Calcular");
    	disp.add(submit, 1, 3);
    	submit.setOnAction(e -> {
            Stage st2 = new Stage();
            
            LocalDate now = LocalDate.now();
            LocalDate birth = dateField.getValue();
            String name = nameField.getText();
            
            Label r = new Label("Error inesperado, comprueba los campos y vuelve a intentarlo...");
            
            if(!name.isEmpty() && birth != null) {
				r = new Label("Hola " + name + ", has nacido el "
						+ birth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) 
						+ ", estamos en " + now.getYear() + " y tu cumpleaños "
						+ (now.getDayOfYear() > birth.getDayOfYear() ? "ya ha pasado." : "aun NO ha pasado."));
            }
            
            
    		var scene = new Scene(new StackPane(r), 640, 60);
    		st2.setMinWidth(640);
    		st2.setMaxWidth(640);
    		st2.setMinHeight(60);
    		st2.setMaxHeight(60);
    		st2.setTitle("Resultado");
    		st2.setScene(scene);
    		st2.show();
    	});
    	
        var scene = new Scene(disp, 480, 320);
        stage.setTitle("Calculadora de cumpleaños");
        stage.setScene(scene);
        stage.setMinWidth(480);
        stage.setMaxWidth(480);
        stage.setMinHeight(320);
        stage.setMaxHeight(320);
        stage.show();
    }


}