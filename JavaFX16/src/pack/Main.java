package pack;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; 
import javafx.scene.control.Label;
import javafx.scene.control.TextField;;


 
public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		Stage window = primaryStage;
		window.setTitle("Title of the window");
		
		//Input and labels
		TextField userInput = new TextField();
		userInput.setMaxWidth(200);
		Label label1 = new Label("Welcome to the Jungle");
		Label label2 = new Label();
		
		HBox bottomText = new HBox(label1, label2);
		bottomText.setAlignment(Pos.CENTER);
		
		VBox vBox = new VBox(10, userInput, bottomText);
		vBox.setAlignment(Pos.CENTER);
		
		label2.textProperty().bind(userInput.textProperty());
		
		Scene scene = new Scene(vBox, 300, 300);
		window.setScene(scene);
		window.show();
	}

}
