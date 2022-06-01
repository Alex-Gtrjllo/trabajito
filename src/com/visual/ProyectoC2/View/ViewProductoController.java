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

public class ViewProductoController implements Initializable {

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
    private Button Nuevo;

    @FXML
    private Button Baja;

    @FXML
    private Button Reporte;
    
    @FXML
    private Button Actualizar;
    
    @FXML
    private Button Compras;
    
    @FXML
    private ImageView Carrito;

    @FXML
    private TableView<Product> Tabla;

    @FXML
    private TableColumn<Product, String> Nombre;

    @FXML
    private TableColumn<Product, Float> Precio;

    @FXML
    private TableColumn<Product, Integer> Cantidad;

    @FXML
    private TableColumn<Product, String> Codigo;
    
    @FXML
    private Button Salir;
    
    private ObservableList<Product> products;
    
    private Product product;
    
    public static Product actualizar;
    
    public static Product comprar;
    
    private ProductDAO dao = new ProductDAO();
    
    public static int productid;
        
    @FXML
    void botonSalir(MouseEvent event) {
    	Main.newStage("ViewMenu", "Menu");
    	Main.closeStage(event);
    }

    @FXML
    void botonActualizar(MouseEvent event) {
        actualizar = Tabla.getSelectionModel().getSelectedItem();
        System.out.println(actualizar);
        if (actualizar != null) {
            Main.newStage("ViewEdit", "Editar");
            Main.closeStage(event);
        } else {
            System.out.println("no se seleccionó un producto");
        }
    }
    
    @FXML
    void botonBaja(MouseEvent event) {
    	Product product = Tabla.getSelectionModel().getSelectedItem();
    	System.out.println(product);  
    	
    	dao.delete(product.getProductID());
    	products.remove(product.getProductID()-1);
    }

    @FXML
    void botonNuevo(MouseEvent event) {
    	Main.newStage("ViewRegistro", "Registro");
    	Main.closeStage(event);
    }

    @FXML
    void botonReporte(MouseEvent event) {
    	
    }    
    
    @FXML
    void botonCompras(MouseEvent event) {
    	ShopDAO dao2 = new ShopDAO();
    	Shop shop = new Shop();
    	int id=dao2.getAllProducts().size();
    	id++;
    	Timestamp time = new Timestamp(System.currentTimeMillis());
    	comprar = Tabla.getSelectionModel().getSelectedItem();
    	System.out.println(comprar); 
    	shop.setFecha(time);
		shop.setProductID(comprar.getProductID());
		shop.setStock(comprar.getStock());
		shop.setProductName(comprar.getName());
		shop.setSellID(id);
		shop.setUserID(comprar.getUserID());
		shop.setCodigo(comprar.getCodigo());
		shop.setProductPrice(comprar.getPrice());
		
		dao2.insert(shop);
    }
    
    @FXML
    void botonCarrito(MouseEvent event) {
    	Main.newStage("ViewCompras", "Compras");
    	Main.closeStage(event);
    	
    }
    
    private void inicializarDatos() {
    	
    	Nombre.setCellValueFactory(new PropertyValueFactory<Product, String>("Name"));
		Precio.setCellValueFactory(new PropertyValueFactory<Product, Float>("Price"));
		Cantidad.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Stock"));
		Codigo.setCellValueFactory(new PropertyValueFactory<Product, String>("Codigo"));
		
		products = FXCollections.observableArrayList();
		
		for (int i = 1; i < dao.getAllProducts().size()+1; i++) {
			product = dao.getProduct(i);
			productid = dao.getProduct(i).getProductID();
			products.add(product);
		}
		
		Tabla.setItems(products);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			
			inicializarDatos();
			
			Salir.setText("Volver al Menu");
			Nuevo.setText("Nuevo");
			Baja.setText("Baja");
			Compras.setText("Comprar");
			Actualizar.setText("Actualizar");
			Reporte.setText("Reporte");
			Nombre.setText("Nombre");
			Precio.setText("Precio");
			Cantidad.setText("Cantidad");
			Codigo.setText("Codigo");
			Carrito.setImage(new Image("Resources/IconoCarrito2.png"));
			Logo.setImage(new Image("Resources/Logo.png"));
			Fondo.setImage(new Image("Resources/fondoProducto.jpg"));
		    
			Reporte.setVisible(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

   
}