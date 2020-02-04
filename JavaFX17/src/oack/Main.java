package oack;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;


public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
