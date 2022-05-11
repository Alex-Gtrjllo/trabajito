package com.visual.ProyectoC2.View;

import java.net.URL;
import java.util.ResourceBundle;

import com.visual.ProyectoC2.Main;
import com.visual.ProyectoC2.DAO.ProductDAO;
import com.visual.ProyectoC2.entitys.Product;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewEditController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Fondo;

    @FXML
    private ImageView Logo;

    @FXML
    private Label Registro;

    @FXML
    private Label Nombre;

    @FXML
    private Label Cantidad;

    @FXML
    private Label Precio;

    @FXML
    private Label Codigo;

    @FXML
    private TextField NombreText;

    @FXML
    private TextField PrecioText;

    @FXML
    private TextField CantidadText;

    @FXML
    private TextField CodigoText;
    
    @FXML
    private Button Agregar;
    
    @FXML
    private Button Cancelar;
    
    public static Product product;
    
    private ProductDAO dao = new ProductDAO();
    
    private int id = ViewProductoController.actualizar.getProductID();
    
    @FXML
    void botonCancelar(MouseEvent event) {
    	Main.newStage("ViewProducto", "Producto");
    	Main.closeStage(event);
    }
    
    @FXML
    void botonAgregar(MouseEvent event) {
    	try {
			System.out.println(id);
			product = new Product(id, NombreText.getText(), Float.parseFloat(PrecioText.getText()),
					Integer.parseInt(CantidadText.getText()), CodigoText.getText(), RootController.id.getIdUser());

			dao.update(product);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Main.closeStage(event);
    	Main.newStage("ViewProducto", "Producto");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Fondo.setImage(new Image("Resources/fondoRegistro.jpg"));
		Logo.setImage(new Image("Resources/Logo.png"));
		Cancelar.setText("Cancelar");
		Registro.setText("Modificar");
		Nombre.setText("Nombre: ");
		Cantidad.setText("Cantidad:");
		Precio.setText("Precio:");
		Codigo.setText("Codigo:");
		Agregar.setText("Actualizar");
		NombreText.setText(ViewProductoController.actualizar.getName());
		CantidadText.setText(String.valueOf(ViewProductoController.actualizar.getStock()));
		PrecioText.setText(String.valueOf(ViewProductoController.actualizar.getPrice()));
		CodigoText.setText(ViewProductoController.actualizar.getCodigo());
		
	}

}