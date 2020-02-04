package pack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;


public class Main extends Application{

	Stage window;
	TreeView<String> tree;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		window = primaryStage;
		window.setTitle("Title of the window");
		
		TreeItem<String> root, bucky, megan;
		
		//Root
		root = new TreeItem<>();
		root.setExpanded(false);
		
		//Bucky
		bucky = makeBranch("Bucky", root);
		makeBranch("thenewBoston", bucky);
		makeBranch("thenewBoston", bucky);
		makeBranch("chicken", bucky);
		
		//Megan
		megan = makeBranch("Bucky", root);
		makeBranch("glitter", megan);
		makeBranch("makeup", megan);
		
		//Create tree
		tree = new TreeView<>(root);
		tree.setShowRoot(true);
		tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			
				if(newValue != null)
					System.out.println(newValue.getValue());
		});
		
		//Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(tree);
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();
	}
	
	public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}

}
