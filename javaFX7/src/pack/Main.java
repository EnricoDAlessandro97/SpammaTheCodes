package pack;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	Stage window;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		window = primaryStage;
		window.setTitle("Title");
		
		//Form
		TextField nameInput = new TextField();
		
		Button button = new Button("Click me");
		button.setOnAction(e -> isInt(nameInput, nameInput.getText()));
		 
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(nameInput, button);
		
		Scene scene = new Scene(layout, 600, 600);
		window.setScene(scene);
		window.show();
		
		
	}
	
	private boolean isInt(TextField input, String message) {
		try {
			int age = Integer.parseInt(input.getText());
			System.out.println("User is " + age);
			return true;
		}catch(NumberFormatException e) {
			System.out.println("Error " + message + " is not a number");
			return false;
		}
	}

}
