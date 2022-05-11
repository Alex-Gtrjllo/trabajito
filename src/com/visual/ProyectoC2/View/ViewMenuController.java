package com.visual.ProyectoC2.View;

import java.net.URL;
import java.util.ResourceBundle;

import com.visual.ProyectoC2.Main;
import com.visual.ProyectoC2.DAO.UserDAO;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewMenuController implements Initializable{

    @FXML
    private ImageView imageFondo;

    @FXML
    private ImageView imageLogo;

    @FXML
    private Label Menu;

    @FXML
    private Label welcome;

    @FXML
    private Button product;

    @FXML
    private Button ventas;

    @FXML
    private Button category;

    @FXML
    private Button suppliers;
    
    @FXML
    private Button salir;
    
    private UserDAO dao = new UserDAO();

    @FXML
    void botonCategory(MouseEvent event) {

    }

    @FXML
    void botonProduct(MouseEvent event) {
    	Main.closeStage(event);
    	Main.newStage("ViewProducto", "Producto");
    }

    @FXML
    void botonSalir(MouseEvent event) {
    	System.exit(0);
    }
 
    @FXML
    void botonSuppliers(MouseEvent event) {

    }

    @FXML
    void botonVentas(MouseEvent event) {
    	Main.closeStage(event);
    	Main.newStage("ViewVentas", "Ventas");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Menu.setText("Menu");
		welcome.setText("Bienvenido: "+dao.getUser(1).getLogin());
		imageFondo.setImage(new Image("Resources/fondoMenu.jpg"));
		imageLogo.setImage(new Image("Resources/Logo.png"));
		ventas.setText("Ventas");
		product.setText("Productos");
		category.setText("Categoria");
		suppliers.setText("Provedores");
		salir.setText("Salir");
		
		category.setVisible(false);
		suppliers.setVisible(false);
	}

}