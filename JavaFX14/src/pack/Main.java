package pack;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class Main extends Application{

	Stage window;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Title of the page");
		
		//File Menu
		Menu fileMenu = new Menu("File");
		
		//Menu Items
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("New File"));
		fileMenu.getItems().add(newFile);
		
		fileMenu.getItems().add(new MenuItem("New project ..."));
		fileMenu.getItems().add(new MenuItem("New Model ..."));
		fileMenu.getItems().add(new MenuItem("Import projext ..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Save as..."));
		fileMenu.getItems().add(new MenuItem("Exit"));
		//Main menu bar
		
		//edit Menu
		Menu editMenu = new Menu("Edit");
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));

		MenuItem paste = new MenuItem("Paste");
		paste.setOnAction(e -> System.out.println("Pasting some crap"));
		paste.setDisable(false);
		editMenu.getItems().add(paste);
		
		//Help menu
		Menu helpMenu = new Menu("Help");
		CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
		showLines.setOnAction(e -> {
			if(showLines.isSelected()){
				System.out.println("Program will display line numbers");
			}else {
				System.out.println("Hiding line numbers");
			}
		});
		
		CheckMenuItem autoSave = new CheckMenuItem("Enable AutoSave");
		autoSave.setSelected(true);
		helpMenu.getItems().addAll(showLines, autoSave);
		
		// Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
		
		BorderPane layout =  new BorderPane();
		layout.setTop(menuBar);
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();
	}

}
