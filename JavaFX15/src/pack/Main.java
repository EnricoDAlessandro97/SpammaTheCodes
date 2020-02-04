package pack;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		Stage window = primaryStage;
		window.setTitle("Title of the window");
		
		Person bucky = new Person();
		bucky.firstNameProperty().addListener((v, oldValue, newValue) -> {
			System.out.println("Name change to: " + newValue);
			System.out.println("firstNameProperty(): " + bucky.firstNameProperty());
			System.out.println("getFirstName(): " + bucky.getFirstName());
		});
		
		
		
		Button button = new Button("Submit");
		button.setOnAction(e-> bucky.setFirstName("Porky"));
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();
	}

}
