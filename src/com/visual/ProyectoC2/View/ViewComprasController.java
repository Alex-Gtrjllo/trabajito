package com.visual.ProyectoC2.View;

import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

import com.visual.ProyectoC2.Main;
import com.visual.ProyectoC2.DAO.ProductDAO;
import com.visual.ProyectoC2.DAO.SellDAO;
import com.visual.ProyectoC2.DAO.ShopDAO;
import com.visual.ProyectoC2.entitys.Product;
import com.visual.ProyectoC2.entitys.Sell;
import com.visual.ProyectoC2.entitys.Shop;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewComprasController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Fondo;

    @FXML
    private ImageView Logo;

    @FXML
    private ImageView User;

    @FXML
    private Button Comprar;
    
    @FXML
    private Button Editar;

    @FXML
    private TableView<Shop> Tabla;

    @FXML
    private TableColumn<Shop, String> productName;

    @FXML
    private TableColumn<Shop, Float> productPrice;

    @FXML
    private TableColumn<Shop, Integer> Cantidad;

    @FXML
    private TableColumn<Shop, Timestamp> Fecha;
    
    @FXML
    private Button Salir;
    
    private ObservableList<Shop> shops;
    
    private Shop shop;
    
    public static Shop editar;
    
    private ShopDAO dao = new ShopDAO();
    
    private SellDAO dao2 = new SellDAO();
        
    @FXML
    void botonSalir(MouseEvent event) {
    	Main.newStage("ViewProducto", "Menu");
    	Main.closeStage(event);
    }

    @FXML
    void botonEditar(MouseEvent event) {
    	editar = Tabla.getSelectionModel().getSelectedItem();
    	System.out.println(editar);  
    	Main.newStage("ViewEditCompra", "Editar");
    	Main.closeStage(event);
    }
    
    @FXML
    void botonComprar(MouseEvent event) {
    	Sell sell = new Sell();
    	int id=dao2.getAllProducts().size();
    	int contador = dao.getAllProducts().size();
    	for (int i = 1; i <= contador; i++) {
    		System.out.println(i);
    		shop = dao.getProduct(i);
    		id++;
    		sell.setFecha(shop.getFecha());
    		sell.setProductID(shop.getProductID());
    		sell.setStock(shop.getStock());
    		sell.setProductName(shop.getProductName());
    		sell.setSellID(id);
    		sell.setUserID(shop.getUserID());
    		sell.setCodigo(shop.getCodigo());
    		sell.setProductPrice(shop.getProductPrice());
    		dao2.insert(sell);
    		dao.delete(i);
    		shops.clear();
		}
    }
    
    private void inicializarDatos() {
    	
    	productName.setCellValueFactory(new PropertyValueFactory<Shop, String>("productName"));
    	productPrice.setCellValueFactory(new PropertyValueFactory<Shop, Float>("productPrice"));
		Cantidad.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("Stock"));
		Fecha.setCellValueFactory(new PropertyValueFactory<Shop, Timestamp>("Fecha"));
		
		shops = FXCollections.observableArrayList();
		
		for (int i = 1; i <= dao.getAllProducts().size(); i++) {
    		shop = dao.getProduct(i);
    		shops.add(shop);
		}
		
		Tabla.setItems(shops);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			
			inicializarDatos();
			Salir.setText("Volver al Menu");
			Comprar.setText("Comprar");
			productName.setText("Nombre");
			productPrice.setText("Precio");
			Cantidad.setText("Cantidad");
			Editar.setText("Editar");
			Fecha.setText("Fecha");
			Logo.setImage(new Image("Resources/Logo.png"));
			Fondo.setImage(new Image("Resources/fondoProducto.jpg"));			
	
		    
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

   
}