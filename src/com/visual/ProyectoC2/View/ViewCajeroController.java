package com.visual.ProyectoC2.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.visual.ProyectoC2.Main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ViewCajeroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Salir;

    @FXML
    private Button Nueva;

    @FXML
    void botonNueva(MouseEvent event) {
    	Main.newStage("ViewPrueba", "Ventana3");
    }

    @FXML
    void botonSalir(MouseEvent event) {
    	System.exit(1);
    }

    @FXML
    void initialize() {
        assert Salir != null : "fx:id=\"Salir\" was not injected: check your FXML file 'ViewCajero.fxml'.";
        assert Nueva != null : "fx:id=\"Nueva\" was not injected: check your FXML file 'ViewCajero.fxml'.";

    }
}