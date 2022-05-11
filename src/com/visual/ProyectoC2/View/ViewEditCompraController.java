package com.visual.ProyectoC2.View;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import com.visual.ProyectoC2.Main;
import com.visual.ProyectoC2.DAO.ProductDAO;
import com.visual.ProyectoC2.DAO.SellDAO;
import com.visual.ProyectoC2.DAO.ShopDAO;
import com.visual.ProyectoC2.entitys.Product;
import com.visual.ProyectoC2.entitys.Sell;
import com.visual.ProyectoC2.entitys.Shop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewEditCompraController implements Initializable {

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
    
    public static Shop shop;
    
    private ShopDAO dao = new ShopDAO();
    
    private int id = ViewComprasController.editar.getSellID();
    
    @FXML
    void botonCancelar(MouseEvent event) {
    	Main.newStage("ViewProducto", "Producto");
    	Main.closeStage(event);
    }
    
    @FXML
    void botonAgregar(MouseEvent event) {
    	try {
			System.out.println(id);
			shop = new Shop(id, ViewComprasController.editar.getFecha(), ViewComprasController.editar.getProductID(), NombreText.getText(), Float.parseFloat(PrecioText.getText()),
					Integer.parseInt(CantidadText.getText()), CodigoText.getText(), RootController.id.getIdUser());

			dao.update(shop);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Main.closeStage(event);
    	Main.newStage("ViewCompras", "Producto");
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
		NombreText.setText(ViewComprasController.editar.getProductName());
		CantidadText.setText(String.valueOf(ViewComprasController.editar.getStock()));
		PrecioText.setText(String.valueOf(ViewComprasController.editar.getProductPrice()));
		CodigoText.setText(ViewComprasController.editar.getCodigo());
		
	}

}