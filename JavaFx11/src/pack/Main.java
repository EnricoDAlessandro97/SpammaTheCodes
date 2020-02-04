package pack;

import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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
		
		ListView<String> listView;
		Button button = new Button("Submit");
		
		listView = new ListView();
		listView.getItems().addAll("Iron man", "Titanic", "Contact", "Surrogates");
		
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		button.setOnAction(e -> buttonClick(listView));
		
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		layout.getChildren().addAll(listView, button);
		Scene scene = new Scene(layout, 200, 200);
		window.setScene(scene);
		window.show();
	}
	
	private void buttonClick(ListView listView) {
		String message = "";
		ObservableList<String> movies;
		
		movies = listView.getSelectionModel().getSelectedItems();
		
		for(String m: movies) {
			message += m + "\n";
		}
		
		System.out.println(message);
	}
	

}

