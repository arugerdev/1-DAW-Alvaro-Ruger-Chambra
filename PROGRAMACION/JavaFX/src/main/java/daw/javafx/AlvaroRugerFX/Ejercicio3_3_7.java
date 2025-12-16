package daw.javafx.AlvaroRugerFX;


import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejercicio3_3_7 extends Ejercicio{

	public Ejercicio3_3_7(String name, boolean finished) {
		super(name, finished);
	}

	//	Se pide un programa que genere 5 textos del tipo “PIEDRA”, “PAPEL” o “TIJERA” a partir de la generación de un número entero aleatorio entre 1 y 3. Usa for() y switch() para resolver este problema.
	
	public enum TYPE {PIEDRA, PAPEL, TIJERA}
	
	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("3.3 7. Se pide un programa que genere 5 textos del tipo “PIEDRA”, “PAPEL” o “TIJERA” \n"
				+ " a partir de la generación de un número entero aleatorio entre 1 y 3. Usa for() y switch() para resolver este problema."));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Juego de piedra papel tijeras "));
		
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
    	
    	ChoiceBox<TYPE> cb = new ChoiceBox<TYPE>();
    	cb.getItems().addAll(TYPE.values());
    	cb.setValue(TYPE.PAPEL);
    	disp.getChildren().add(cb);

    	lineJump(disp);
    	
    	Button submit = new Button("JUGAR");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		TYPE machine_selection = TYPE.values()[(int) (Math.random()*3)];
    		
    		
    		disp.getChildren().add(new Label("La maquina elije: " + machine_selection.toString() ));
    		disp.getChildren().add(new Label("El ganador es " + (winPlayer((TYPE) cb.getValue(), machine_selection) ? "el jugador." : ((TYPE) cb.getValue()).equals(machine_selection) ? "nadie, ha sido empate." : "la maquina.") ));
        	lineJump(disp);

    		
    	});
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Calcular potencia");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
	public boolean winPlayer(TYPE player_play, TYPE machine_play) {
		switch(player_play) {
		case PAPEL:
			return machine_play.equals(TYPE.PIEDRA);
		case PIEDRA:
			return machine_play.equals(TYPE.TIJERA);
		case TIJERA:
			return machine_play.equals(TYPE.PAPEL);
		default: 
			return false;
		}
	}
	
}
