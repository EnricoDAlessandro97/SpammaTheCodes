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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		Stage window = primaryStage;
		window.setTitle("Title of the window");
		
		Button button = new Button("Click me");
		ComboBox<String> comboBox = new ComboBox<String>();
		comboBox.getItems().addAll(
				"Good Will Hunting",
				"St. Vincent",
				"BlackHat"
		);
		
		comboBox.setPromptText("What is your favourite movie?");
		
		comboBox.setEditable(true);
		
		button.setOnAction(e -> printMovie(comboBox));
		
		comboBox.setOnAction(e -> System.out.println("User selects: " + comboBox.getValue() ));
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(comboBox,button);
		Scene scene = new Scene(layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	
	private void printMovie(ComboBox<String> comboBox) {
		System.out.println(comboBox.getValue());
	}

}
