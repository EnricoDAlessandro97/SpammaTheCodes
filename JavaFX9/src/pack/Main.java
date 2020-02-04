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

public class Main extends Application{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		 Stage window = primaryStage;
		 window.setTitle("Title of the window");
		
		 //Button
		 Button button = new Button("Click me");
		 
		 ChoiceBox<String> choiceBox = new ChoiceBox<String>(); 
		 
		 //getItems returnes the ObservableList objext which you can listen to
		 choiceBox.getItems().add("Apples");
		 choiceBox.getItems().add("Bananas");
		 choiceBox.getItems().addAll("bacon", "Sam", "Bible");
		 
		 //Set the default value of the ChoiceBox
		 //choiceBox.setValue("Apples");
		 
		 //Listen for selection changes
		 choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue));
		 
		 VBox layout = new VBox(10);
		 layout.setPadding(new Insets(20, 20, 20, 20));
		 layout.getChildren().addAll(choiceBox, button);
		 
		 Scene scene = new Scene(layout, 200, 200);
		 window.setScene(scene);
		 window.show();
	}
	
	

}
