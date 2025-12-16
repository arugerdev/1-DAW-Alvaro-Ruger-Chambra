package daw.javafx.AlvaroRugerFX;

import daw.javafx.AlvaroRugerFX.EjercicioGato.Gato;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjerGato extends Ejercicio {

	public EjerGato(String name, boolean finished) {
		super(name, finished);
	}

	public void start(Stage stage) {
		FlowPane disp = new FlowPane();

		disp.setOrientation(Orientation.HORIZONTAL);
		disp.setPadding(new Insets(20, 20, 20, 20));
		disp.setHgap(10);
		disp.setVgap(10);

		Text enun = new Text(String.format("4. Ejercicio Gato"));
		enun.setFont(Font.font(12));
		disp.getChildren().add(enun);

		lineJump(disp);

		Text title = new Text(String.format("Clases: Gato"));

		title.setFont(Font.font(24));
		disp.getChildren().add(title);

		Gato gato = new Gato("Garfield", "anaranjado", "persa", Gato.Sex.MACHO, 500);
		
		lineJump(disp);

		TextField inputName = new TextField();
		inputName.setText(gato.getNombre());
		disp.getChildren().add(inputName);
		
		Button setName = new Button("SET_NAME");
		disp.getChildren().add(setName);
		setName.setOnAction(e -> {
			gato.setNombre(inputName.getText());
		});
		
		Button getName = new Button("GET_NAME");
		disp.getChildren().add(getName);
		getName.setOnAction(e -> {
			createTextLabel(gato.getNombre(), disp, false);
		});
		
		lineJump(disp);
		
		TextField inputColor = new TextField();
		inputColor.setText(gato.getColor());
		disp.getChildren().add(inputColor);
		
		Button setColor = new Button("SET_COLOR");
		disp.getChildren().add(setColor);
		setColor.setOnAction(e -> {
			gato.setColor(inputColor.getText());
		});
		
		Button getColor = new Button("GET_COLOR");
		disp.getChildren().add(getColor);
		getColor.setOnAction(e -> {
			createTextLabel(gato.getColor(), disp, false);
		});
		
		lineJump(disp);
		
		
		TextField inputRaza = new TextField();
		inputRaza.setText(gato.getRaza());
		disp.getChildren().add(inputRaza);
		
		Button setRaza = new Button("SET_RAZA");
		disp.getChildren().add(setRaza);
		setRaza.setOnAction(e -> {
			gato.setRaza(inputRaza.getText());
		});
		
		Button getRaza = new Button("GET_RAZA");
		disp.getChildren().add(getRaza);
		getRaza.setOnAction(e -> {
			createTextLabel(gato.getRaza(), disp, false);
		});
		
		lineJump(disp);

		ChoiceBox<Gato.Sex> cb = new ChoiceBox<Gato.Sex>();
		cb.getItems().addAll(Gato.Sex.values());
		cb.setValue(gato.getSex());
		disp.getChildren().add(cb);

		Button setSex = new Button("SET_SEX");
		disp.getChildren().add(setSex);
		setSex.setOnAction(e -> {
			gato.setSex(cb.getValue());
		});
		
		Button getSex = new Button("GET_SEX");
		disp.getChildren().add(getSex);
		getSex.setOnAction(e -> {
			createTextLabel( "" + gato.getSex(), disp, false);
		});
		
		lineJump(disp);
		
		Spinner<Integer> peso = new Spinner<>(0, 1000, gato.getPeso());
		spinnerKeyboard(peso);

		disp.getChildren().add(peso);
		
		Button setPeso = new Button("SET_PESO");
		disp.getChildren().add(setPeso);
		setPeso.setOnAction(e -> {
			gato.setPeso(peso.getValue());
		});
		
		Button getPeso = new Button("GET_PESO");
		disp.getChildren().add(getPeso);
		getPeso.setOnAction(e -> {
			createTextLabel(gato.getPeso() + " grms", disp, false);
		});
		
		lineJump(disp);
		
		Spinner<Integer> mins = new Spinner<>(0, 1000, 0);
		spinnerKeyboard(mins);

		disp.getChildren().add(mins);
		
		Button correr = new Button("CORRER");
		disp.getChildren().add(correr);
		correr.setOnAction(e -> {
			gato.correr(mins.getValue());
		});
		
		lineJump(disp);
		
		
		Spinner<Integer> grms = new Spinner<>(0, 10000, 0);
		spinnerKeyboard(grms);

		disp.getChildren().add(grms);
		
		Button comer = new Button("COMER");
		disp.getChildren().add(comer);
		comer.setOnAction(e -> {
			gato.comer(grms.getValue());
		});
		
		lineJump(disp);

		Button saludar = new Button("SALUDAR");
		disp.getChildren().add(saludar);
		saludar.setOnAction(e -> {
			createTextLabel(gato.saludar(), disp, false);
		});
		
		Button maullar = new Button("MAULLAR");
		disp.getChildren().add(maullar);
		maullar.setOnAction(e -> {
			createTextLabel(gato.maullar(), disp, false);
		});
		
		createTextLabel(gato.toString(), disp, true);
		lineJump(disp);
		var scene = new Scene(disp, 1920, 1080);
		stage.setTitle("GATO!");
		stage.setScene(scene);
		stage.setWidth(960);
		stage.setHeight(480);
		stage.show();
	}


}
