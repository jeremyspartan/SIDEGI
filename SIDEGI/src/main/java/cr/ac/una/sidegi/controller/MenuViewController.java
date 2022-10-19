/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import cr.ac.una.sidegi.util.FlowController;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author esteb
 */
public class MenuViewController extends Controller {

    @FXML
    private BorderPane root;
    @FXML
    private JFXButton btnCerrarSesion;
    @FXML
    private JFXButton btnEntrevista;
    @FXML
    private VBox bpCenter;
    @FXML
    private JFXButton btnRegistro;
    @FXML
    private JFXButton btnAgenda;
    @FXML
    private JFXButton btnReportes;

    /**
     * Initializes the controller class.
     */
   
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void onActionBtnCerrarSesion(ActionEvent event) {
    }

    @FXML
    private void onActionBtnEntrevista(ActionEvent event) {
        FlowController.getInstance().goView("ExpedienteView");
    }


    @Override
    public void initialize() {
    
    }

    @FXML
    private void onActionBtnRegistro(ActionEvent event) {
        FlowController.getInstance().goView("RegistroView");
    }

    @FXML
    private void onActionBtnAgenda(ActionEvent event) {
    }

    @FXML
    private void onActionBtnReportes(ActionEvent event) {
    }
    
}
