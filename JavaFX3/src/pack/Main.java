package pack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	Stage window;
	Button button;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		window = primaryStage;
		window.setTitle("theNewButton");
		
		window.setMinHeight(500);
		window.setMinWidth(500);
		
		button = new Button("Click me");
		button.setOnAction(e -> {
			boolean resutl = ConfirmBox.display("Title of the window", "Are you sure you wanna quit??");
			System.out.println(resutl);
		});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 200,250);
		window.setScene(scene);
		
		window.show();
	}

}
