package daw.javafx.AlvaroRugerFX.Practica4_1;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Domino {
	private int lValue, rValue;
	public Label l;
	private Pane parent;

	public Domino(int l, int r, Pane parent) {
		this.lValue = l;
		this.rValue = r;
		this.parent = parent;
		this.l = new Label();
		this.l.setText(this.toString());
		
		this.l.setUserData(this);

		this.l.setPrefWidth(60);  
		this.l.setPrefHeight(30); 
		this.l.setMinWidth(60);
		this.l.setMinHeight(30);
		this.l.setMaxWidth(60);
		this.l.setMaxHeight(30);
		this.l.setFont(Font.font("Consolas", 16));
		this.l.setStyle("-fx-border-color: black; -fx-alignment: center;");

		
		setDAD();
	}
	
	class Delta {
		double x, y;
		}

	public Label setDAD() {
		final Delta dragDelta = new Delta();
		
		l.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				dragDelta.x = l.getLayoutX() - mouseEvent.getSceneX();
				dragDelta.y = l.getLayoutY() - mouseEvent.getSceneY();
				l.setCursor(Cursor.MOVE);
				
				if(mouseEvent.isSecondaryButtonDown()) {
					rotate();
				}
				
				
			}
		});
		l.setOnMouseReleased(mouseEvent -> {
		    l.setCursor(Cursor.HAND);

		    var bounds = l.getBoundsInParent();

		    for (var node : parent.getChildren()) {
		        if (node == l) continue;

		        if (bounds.intersects(node.getBoundsInParent())) {
		            Domino otro = (Domino) node.getUserData();
		            if (encaja(otro)) {
		                colocarAlLado(otro);
		            } 
		        }
		    }
		});

		l.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				l.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
				l.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
			}
		});
		l.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				l.setCursor(Cursor.HAND);
			}
		});
		l.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
			}
		});

		return l;
	}

	public void setPos(int x, int y) {
		l.setLayoutX(x);
		l.setLayoutY(y);
	}
	
	public void rotate() {
		int e = lValue;
		lValue = rValue;
		rValue = e;
		
		this.l.setText(this.toString());
	}

	public void colocarAlLado(Domino otro) {
	    double offset = 60; 

	    if (otro.rValue == this.lValue) {
	        this.setPos((int)(otro.l.getLayoutX() + offset), (int)otro.l.getLayoutY());
	        return;
	    }

	    if (otro.lValue == this.rValue) {
	        this.setPos((int)(otro.l.getLayoutX() - offset), (int)otro.l.getLayoutY());
	        return;
	    }
	}

	
	public boolean encaja(Domino other) {
		return other.lValue == this.rValue || other.rValue == this.lValue;
	}

	@Override
	public String toString() {
		return  "" + (lValue == 0 ? "" : lValue) + " | " + (rValue == 0 ? "" : rValue) + "";
	}

}
