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

public class Main extends Application{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		 Stage window = primaryStage;
		 window.setTitle("Title of the window");
		 
		 //Check boxes
		 
		 CheckBox box1 = new CheckBox("Bacon");
		 CheckBox box2 = new CheckBox("Tuna"); 
		 
		 //box2.setSelected(true);
		 
		 //Button
		 Button button = new Button("Order now");
		 button.setOnAction(e -> handleOptions(box1, box2));
		 
		 VBox layout = new VBox(10);
		 layout.setPadding(new Insets(20, 20, 20, 20));
		 layout.getChildren().addAll(box1, box2, button);
		 
		 Scene scene = new Scene(layout, 200, 200);
		 window.setScene(scene);
		 window.show();
	}
	
	private void handleOptions(CheckBox box1, CheckBox box2) {
		String message = "User order: ";
		if(box1.isSelected() == true) {
			message += "Bacon";
		}
		
		if(box2.isSelected() == true) {
			message += "Tuna";
		}
		
		System.out.println(message);
	}

}
