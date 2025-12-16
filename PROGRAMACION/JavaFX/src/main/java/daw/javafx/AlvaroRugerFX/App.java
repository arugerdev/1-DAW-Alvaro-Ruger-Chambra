package daw.javafx.AlvaroRugerFX;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */


public class App extends Application {
	
	public static Tema[] content = {
        new Tema(0, new Ejercicio[]{
        	new EjercicioCalcCum("0", true)
        	}),
        new Tema(3, new Ejercicio[]{
            	new Ejercicio3_11("3.1 - 11", true),
            	new Ejercicio3_12("3.1 - 12", true),
            	new Ejercicio3_13("3.1 - 13", true),
            	new Ejercicio3_14("3.1 - 14", true),
            	new Ejercicio3_15("3.1 - 15", true),
            	new Ejercicio3_16("3.1 - 16", true),
            	new Ejercicio3_17("3.1 - 17", true),
            	new Ejercicio3_18("3.1 - 18", true),
            	new Ejemplo3_1("EJ 01", true),
            	new Ejemplo3_2("EJ 02", true),
            	new Ejercicio3_3_1("3.3 - 1", true),
            	new Ejercicio3_3_2("3.3 - 2", true),
            	new Ejercicio3_3_3("3.3 - 3", true),
            	new Ejercicio3_3_4("3.3 - 4", true),
            	new Ejercicio3_3_5("3.3 - 5", true),
            	new Ejercicio3_3_6("3.3 - 6", true),
            	new Ejercicio3_3_7("3.3 - 7", true),
            	new Ejercicio3_2_1("3.2 - 1", true),
            	new Ejercicio3_2_2("3.2 - 2", true),
            	new Ejercicio3_2_3("3.2 - 3", true),
            	new Ejercicio3_2_4("3.2 - 4", true),
            	new Ejercicio3_2_5("3.2 - 5", true),
            	new Ejercicio3_2_6("3.2 - 6", true),
            	new Ejercicio3_5_4("3.5 - 4", true),
            	new Ejercicio3_5_5("3.5 - 5", true),
            	new Ejercicio3_5_6("3.5 - 6", true),
            	new Practica3_1_1("Practica 3.1 - 1", true),
            	new Practica3_1_2("Practica 3.1 - 2", true),
            	new Practica3_1_3("Practica 3.1 - 3", true),
            	new Practica3_1_4("Practica 3.1 - 4", true),
            	new Practica3_2_1("Practica 3.2 - 1", true),
            	new Practica3_2_2("Practica 3.2 - 2", true),
            	new Practica3_2_3("Practica 3.2 - 3", true),
            	new Practica3_2_4("Practica 3.2 - 4", true),
            	new Ejercicio3_11("3.1 - 11", true),


            	}),
        		new Tema(4, new Ejercicio[]{
                    new EjerGato("Practica Gato", true),
                    new EjerLibro("Practica Libro", true),
                    new EjerJarra("Practica Jarra", true),
                    new EjerCoche("Practica Coche", true),
                    new EjerMarcianos("Practica Marcianos", true),
                    new Practica4_1_1("Practica 4.1 1 Autobus", true),
                    new Practica4_1_2("Practica 4.1 2 Tiempo", true),
                    new Practica4_1_3("Practica 4.1 3 Domino", true),

        		}),
          		new Tema(5, new Ejercicio[]{
                        new Ejercicio5_1("Ejercicio Arrays", true),
                        new Ejercicio5_2("Ejercicio 5.2", true),
                        new Ejercicio5_3_1("Ejercicio 5.3.1", true),
                        new Life("Life", true),

            		})
        };

    @Override
    public void start(Stage stage) {
    	
    	FlowPane disp = new FlowPane();
    	
    	disp.setPadding(new Insets(20,20,20,20));
    	disp.setHgap(10);
    	disp.setVgap(20);
    	
    	Text title = new Text(String.format("Álvaro Ruger Programación DAW1"));
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);

    	
    	for (Tema tema : content) {
        	Ejercicio.lineJump(disp);

    		
	    	Text subtitle = new Text(String.format("Tema " + tema.num));
	    	subtitle.setFont(Font.font(16));
	    	disp.getChildren().add(subtitle);
	    	

	    	
	    	for (Ejercicio ejer : tema.ejercicios) {	    		
		    	Button submit = new Button(ejer.name);
		    	if(ejer.finished) {		    		
		    		submit.setStyle("-fx-background-color: #7FB685; -fx-text-fill: #426A5A; -fx-cursor: hand;");
		    	}
		    	else
		    	{
		    		submit.setStyle("-fx-background-color: #F2C57C; -fx-text-fill: #DDAE7E; -fx-cursor: hand;");
		    	}
		    	
		    	disp.getChildren().add(submit);
		    	submit.setOnAction(e -> {
		    		ejer.start(new Stage());
		    	});
	    	}
	    	
    	}
    	
    	Ejercicio.lineJump(disp);
    	
    	Button exit = new Button("Salir");
    	exit.setStyle("-fx-background-color: #EF6F6C; -fx-text-fill: #B81714; -fx-font-weight: bold; -fx-cursor: hand;");
    	disp.getChildren().add(exit);
    	exit.setOnAction(e -> {
    		  stage.close();
    	});
    	
        var scene = new Scene(disp, 480, 320);
        stage.setTitle("Álvaro Ruger Programación DAW1");
        stage.setScene(scene);
        stage.setWidth(1920);
        stage.setHeight(1080);
        stage.show();
    }

    public static void main(String[] args) {
    	System.setProperty("prism.allowhidpi", "false");
    	System.setProperty("prism.pixelScale", "1.0");

        launch();
    }

}