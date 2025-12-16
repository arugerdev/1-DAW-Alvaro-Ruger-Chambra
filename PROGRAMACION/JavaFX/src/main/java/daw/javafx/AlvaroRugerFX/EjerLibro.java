package daw.javafx.AlvaroRugerFX;

import daw.javafx.AlvaroRugerFX.EjercicioLibro.Libro;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjerLibro extends Ejercicio {

	public EjerLibro(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("4. Ejercicio Libro"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Clases: Libro"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		Libro libro = new Libro("El Quijote", "Miguel de Cervantes", 100, "978-84-376-0495-8", 10);		
		
		lineJump(disp);

		TextField inputTitulo = new TextField();
		inputTitulo.setText(libro.getTitulo());
		disp.getChildren().add(inputTitulo);
		
		Button setTitulo = new Button("SET_TITULO");
		disp.getChildren().add(setTitulo);
		setTitulo.setOnAction(e -> {
			libro.setTitulo(inputTitulo.getText());
		});
		
		Button getTitulo = new Button("GET_TITULO");
		disp.getChildren().add(getTitulo);
		getTitulo.setOnAction(e -> {
			createTextLabel(libro.getTitulo(), disp, false);
		});
		
		lineJump(disp);
		
		TextField inputAutor = new TextField();
		inputAutor.setText(libro.getAutor());
		disp.getChildren().add(inputAutor);
		
		Button setAutor = new Button("SET_AUTOR");
		disp.getChildren().add(setAutor);
		setAutor.setOnAction(e -> {
			libro.setAutor(inputAutor.getText());
		});
		
		Button getColor = new Button("GET_AUTOR");
		disp.getChildren().add(getColor);
		getColor.setOnAction(e -> {
			createTextLabel(libro.getAutor(), disp, false);
		});
		
		lineJump(disp);
		
		Spinner<Integer> numPags = new Spinner<>(0, 1000, libro.getNumPag());
		spinnerKeyboard(numPags);

		disp.getChildren().add(numPags);
		
		Button setNpags = new Button("SET_NUMERO_PAGINAS");
		disp.getChildren().add(setNpags);
		setNpags.setOnAction(e -> {
			libro.setEjemplaresExistentes(numPags.getValue());
		});
		
		Button getNpags = new Button("GET_NUMERO_PAGINAS");
		disp.getChildren().add(getNpags);
		getNpags.setOnAction(e -> {
			createTextLabel(libro.getNumPag() + " pgs", disp, false);
		});
		
		lineJump(disp);
		
		TextField isbn = new TextField();
		isbn.setText(libro.getIsbn());
		disp.getChildren().add(isbn);
		
		Button setIsbn = new Button("SET_ISBN");
		disp.getChildren().add(setIsbn);
		setIsbn.setOnAction(e -> {
			libro.setIsbn(isbn.getText());
		});
		
		Button getIsbn = new Button("GET_ISBN");
		disp.getChildren().add(getIsbn);
		getIsbn.setOnAction(e -> {
			createTextLabel(libro.getIsbn(), disp, false);
		});
		
		lineJump(disp);
		
		Spinner<Integer> ejemplaresExistentes = new Spinner<>(0, 1000, libro.getEjemplaresExistentes());
		spinnerKeyboard(ejemplaresExistentes);

		disp.getChildren().add(ejemplaresExistentes);
		
		Button setEjems = new Button("SET_EJEMPLARES_EXISTENTES");
		disp.getChildren().add(setEjems);
		setEjems.setOnAction(e -> {
			libro.setEjemplaresExistentes(ejemplaresExistentes.getValue());
		});
		
		Button getEjems = new Button("GET_EJEMPLARES_EXISTENTES");
		disp.getChildren().add(getEjems);
		getEjems.setOnAction(e -> {
			createTextLabel(libro.getEjemplaresExistentes() + " ejemplares", disp, false);
		});
		
		lineJump(disp);

		Button prestar = new Button("PRESTAR");
		disp.getChildren().add(prestar);
		prestar.setOnAction(e -> {
			createTextLabel(libro.prestar(), disp, false);
		});
		
		Button devolver = new Button("DEVOLVER");
		disp.getChildren().add(devolver);
		devolver.setOnAction(e -> {
			createTextLabel(libro.devolver(), disp, false);
		});
		
		createTextLabel(libro.toString(), disp, true);
		lineJump(disp);
		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("GATO!");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}


}
