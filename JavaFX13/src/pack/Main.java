package pack;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application{

	Stage window;
	TableView<Product> table;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Title of the windowww");
		
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(100);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		
		TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(100);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll();
		
		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}
	
	// Get all the products
	public ObservableList<Product> getProduct(){
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 900, 20));
		products.add(new Product("Pigiama", 50, 10));
		products.add(new Product("Samba", 10, 5));
		products.add(new Product("Gesu", 33.666 , 2));
		return products;
	}

}
