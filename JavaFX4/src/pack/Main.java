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
	
	public void closeProgram() {
		Boolean answer = ConfirmBox.display("Title", "Are you sure to exit??");
		if(answer == true) {
			window.close();
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		window = primaryStage;
		window.setTitle("theNewButton");
		
		window.setOnCloseRequest(e->{
			e.consume();
			closeProgram();
		});
		
		button = new Button("Close the program");
		button.setOnAction(e -> closeProgram());
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 500,500);
		window.setScene(scene);
		
		window.show();
	}

}

