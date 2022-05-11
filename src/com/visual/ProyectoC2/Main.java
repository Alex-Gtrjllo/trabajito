package com.visual.ProyectoC2;
	
import java.io.IOException;

import com.visual.ProyectoC2.DAO.UserDAO;
import com.visual.ProyectoC2.View.RootController;
import com.visual.ProyectoC2.entitys.Product;
import com.visual.ProyectoC2.entitys.User;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
    private static Scene scene;
    private static Stage primaryStage;
    public static Stage secondStage;

	@Override
	public void start(Stage stage) {
		this.primaryStage = stage;
		try {
			//AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("View/root.fxml"));
			scene = new Scene(loadFXML("Root"));
			scene.setFill(Color.TRANSPARENT);
			//scene.getStylesheets().add(getClass().getResource("View/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			//stage.getIcons().add(e);
			//primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void setFXML(String fxml, String title) throws IOException {
		  scene.setRoot(loadFXML(fxml)); 
		  primaryStage.setResizable(false);
		  primaryStage.sizeToScene();
		  primaryStage.centerOnScreen();
		  primaryStage.setTitle(title);
		  
	  }
	  
	private static Parent loadFXML(String fxml) throws IOException { 
		  FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/"+ fxml + ".fxml"));
		  return fxmlLoader.load(); 
	  }
	 
	public static void newStage(String fxml, String title) {
	    	try {
				Parent node = loadFXML(fxml);
				secondStage = new Stage();
				Scene scene = new Scene(node);
				secondStage.setScene(scene);
				secondStage.setTitle(title);
				secondStage.initOwner(primaryStage);
				secondStage.initModality(Modality.WINDOW_MODAL);
				secondStage.centerOnScreen();
				secondStage.show();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} 
	
	public static void closeStage(MouseEvent event) {
		Parent source = (Parent) event.getSource();
		secondStage = (Stage) source.getScene().getWindow();
		secondStage.close();  
		
} 
	
	public static void main(String[] args) {
		launch(args);
	}
}
