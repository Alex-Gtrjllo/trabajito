package com.visual.ProyectoC2.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.ProyectoC2.Main;
import com.visual.ProyectoC2.DAO.UserDAO;
import com.visual.ProyectoC2.entitys.User;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ImageView fondo;

    @FXML
    private ImageView icon;

    @FXML
    private PasswordField contraseña;

    @FXML
    private TextField usuario;

    @FXML
    private Button botonLogin;

    @FXML
    private Button botonSalir;
    
    private String pUsuario;
    
    private String contra;
    
    private UserDAO dao = new UserDAO(); 
    
    public static User id;
    
    @FXML
    void BotonLogin(MouseEvent event) {
    	pUsuario = usuario.getText();
    	contra = contraseña.getText();
    	User user = dao.getUser(pUsuario);
    	id = user;
    	if (user != null) {
    		if (user.getPassword().equals(contra)) {
    			System.out.println("Exito");
    			try {
					Main.setFXML("ViewMenu", "Menu");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}else
    			System.out.println("Contraseña incorrecta");
    	}else
    		System.out.println("Incorrecto");
    	
    }

    @FXML
    void botonSalir(MouseEvent event) {
    	System.exit(0);
    }
    
    
    
    @FXML
    void initialize() {
        fondo.setImage(new Image("Resources/fondo.jpg"));
        icon.setImage(new Image("Resources/icon.png"));

    }
}