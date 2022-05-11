package com.visual.ProyectoC2.View;

import java.net.URL;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

import com.visual.ProyectoC2.Main;
import com.visual.ProyectoC2.Adapter.MariaDBAdapter;
import com.visual.ProyectoC2.DAO.SellDAO;
import com.visual.ProyectoC2.entitys.Sell;

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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ViewVentasController implements Initializable {

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
    private Button Reporte;

    @FXML
    private TableView<Sell> Tabla;

    @FXML
    private TableColumn<Sell, Timestamp> Fecha;

    @FXML
    private TableColumn<Sell, Integer> Stock;

    @FXML
    private TableColumn<Sell, String> ProductName;

    @FXML
    private TableColumn<Sell, Float> ProductPrice;
    
    @FXML
    private Button Salir;
    
    private ObservableList<Sell> products;
    
    private Sell sell;
    
    public static Sell actualizar;
    
    private SellDAO dao = new SellDAO();
    
    public static int sellid;
        
    @FXML
    void botonSalir(MouseEvent event) {
    	Main.newStage("ViewMenu", "Menu");
    	Main.closeStage(event);
    }

    @FXML
    void botonReporte(MouseEvent event) {
    	MariaDBAdapter conector = MariaDBAdapter.getInstancia();
    	Connection connection = conector.getConnection();
    	JasperPrint jasperprintwindow;
    	try {
			jasperprintwindow = JasperFillManager.fillReport(
					"Reportes/Ventas.jasper", null,connection);
			JasperExportManager.exportReportToPdfFile(jasperprintwindow, "Informes/informeVenta.pdf");
			JasperViewer.viewReport(jasperprintwindow, false);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }    
    
    
    private void inicializarDatos() {
    	
    	Fecha.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
		Stock.setCellValueFactory(new PropertyValueFactory<>("Stock"));
		ProductName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
		ProductPrice.setCellValueFactory(new PropertyValueFactory<>("ProductPrice"));
		
		products = FXCollections.observableArrayList();
		
		for (int i = 1; i < dao.getAllProducts().size()+1; i++) {
			sell = dao.getProduct(i);
			sellid = dao.getProduct(i).getProductID();
			products.add(sell);
		}
		
		Tabla.setItems(products);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			
			inicializarDatos();
			Salir.setText("Volver al Menu");
			Reporte.setText("Reporte");
			Fecha.setText("Fecha");
			Stock.setText("Cantidad");
			ProductName.setText("Nombre");
			ProductPrice.setText("Precio");
			Logo.setImage(new Image("Resources/Logo.png"));
			Fondo.setImage(new Image("Resources/fondoProducto.jpg"));			
	
		    
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

   
}