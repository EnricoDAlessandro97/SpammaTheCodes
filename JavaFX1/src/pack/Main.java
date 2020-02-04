package pack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler<ActionEvent>{
	
	Button button1; 
	Button button2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Title of the window");
		
		button1 = new Button();
		button1.setText("Click me");
		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("I love you when you touch me there");
			}
			
		});
		  
		StackPane layout = new StackPane();  
		layout.getChildren().add(button1);
		
		Scene scene = new Scene(layout, 500, 500);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}
	
	
	
	

}
