package pack;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{

	Stage window;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Title of the window");
		
		//Grid layout
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(0, 0, 0, 0));
		grid.setVgap(8);
		grid.setHgap(10);
		
		
		// Name label
		Label nameLabel = new Label("Username: ");
		nameLabel.setId("bold-label");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		//Name input
		TextField nameInput = new TextField("Bucky");
		GridPane.setConstraints(nameInput, 1, 0);
		
		// Password label
		Label PasswordLabel = new Label("Password: ");
		GridPane.setConstraints(PasswordLabel, 0, 1);
		
		// Password input
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Button loginButton = new Button("Login");
		GridPane.setConstraints(loginButton, 1, 2);
		
		Button signUpButton = new Button("Sign Up");
		GridPane.setConstraints(signUpButton, 1, 3);
		signUpButton.getStyleClass().add("button-blue");
		grid.getChildren().addAll(nameLabel, nameInput, PasswordLabel, passInput, loginButton, signUpButton);
		
		Scene scene = new Scene(grid, 500,500);
		scene.getStylesheets().add("MyStyle.css");
		window.setScene(scene);
		window.show();
	}

}
