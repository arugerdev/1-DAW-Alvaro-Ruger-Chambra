package daw.javafx.AlvaroRugerFX;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ejemplo3_1 extends Ejercicio{

	public Ejemplo3_1(String name, boolean finished) {
		super(name, finished);
	}

	boolean running = true;
	double timer = 0.0;
    Label timerLabel = new Label("0:0.0");

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();
		
		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20,20,20,20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("Ejemplo 1 while"));
		enun.setFont(Font.font(12));
    	disp.getChildren().add(enun);

    	lineJump(disp);
    	
		Text title = new Text(String.format("Inserta el codigo secreto para que el contador pare (\" codigosec \"): "));
    	title.setFont(Font.font(24));
    	disp.getChildren().add(title);
    	
    	lineJump(disp);
		
		TextField t = new TextField();

		disp.getChildren().add(t);

		lineJump(disp);
  
    	Button submit = new Button("Enviar");
    	disp.getChildren().add(submit);
    	submit.setOnAction(e -> {
    		String input = t.getText().toLowerCase();
            if (input.equals("codigosec")) {
                running = false;
            }

    	});
    	
    	
		lineJump(disp);
		disp.getChildren().add(timerLabel);
		startTimer();	
		lineJump(disp);
		lineJump(disp);
		
		disp.getChildren().add(new Label("boolean running = true; \n"
				+ "double timer = 0.0; \n"
				+ "String input = \"\"; \n"
				+ "String codsec = \"codigosec\"; \n \n"
				+ "while(running) { \n"
				+ "		timer++;\n"
				+ "		if (input == codsec) { \n"
				+ "			running = false;\n"
				+ "		}\n"
				+ "}\n"
				));
		
		var scene = new Scene(disp, 480, 320);
        stage.setTitle("Cantidad de caracteres");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(480);
        stage.show();
	}
	
	private void startTimer() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while (running) {
                    Thread.sleep(10);
                    timer += 0.01;
                    
                    Platform.runLater(() -> {
                        int minutes = (int) (timer / 60);
                        double seconds = timer % 60;
                        timerLabel.setText(String.format("%d:%.1f", minutes, seconds));
                    });
                }
                return null;
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
	
}
