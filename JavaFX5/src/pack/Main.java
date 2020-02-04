package pack;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Main extends Application {
	
	Stage window;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		primaryStage.setTitle("Title of the window");
		
		HBox topMenu = new HBox();
		Button buttonA = new Button("File");
		Button buttonB = new Button("Edit");
		Button buttonC = new Button("View");
		topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
		
		VBox leftMenu = new VBox();
		Button buttonD = new Button("D");
		Button buttonE = new Button("E");
		Button buttonF = new Button("F");
		leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
		
		VBox righteMenu = new VBox();
		Button buttonG = new Button("G");
		Button buttonH = new Button("H");
		Button buttonI = new Button("I");
		righteMenu.getChildren().addAll(buttonG, buttonH, buttonI);
		
		VBox centralMenu = new VBox();
		Button buttonL = new Button("L");
		Button buttonM = new Button("M");
		Button buttonN = new Button("N");
		centralMenu.getChildren().addAll(buttonL, buttonM, buttonN);
		
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		borderPane.setRight(righteMenu);
		borderPane.setCenter(centralMenu);
				
		Scene scene = new Scene(borderPane, 300, 250);
		window.setScene(scene);
		window.show();
	}
	

}