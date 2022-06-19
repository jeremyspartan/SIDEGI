/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author esteb
 */
public class ExpedienteViewController extends Controller {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnLimpiar;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXButton btnEliminar;
    @FXML
    private JFXTextField txtCedula;
    @FXML
    private JFXTextField txtNombre;
    @FXML
    private JFXTextField txtPrimerApellido;
    @FXML
    private JFXTextField txtSegundoApellido;
    @FXML
    private JFXDatePicker dtpFechaNacimeinto;
    @FXML
    private JFXComboBox<?> cmbTipoSeguro;
    @FXML
    private JFXComboBox<?> cmbEscolaridad;
    @FXML
    private JFXTextArea txaDiagnosticoMedico;
    @FXML
    private JFXComboBox<?> cmbEstadoPaciente;
    @FXML
    private JFXDatePicker dtpFechaReferencia;
    @FXML
    private JFXTextField txtProfesionalResponsable;
    @FXML
    private JFXTextField txtDoctor;
    @FXML
    private JFXDatePicker dtpFechaDiagnostico;
    @FXML
    private JFXDatePicker dtpFechaRegistro;

    @Override
    public void initialize() {
        
    }

    @FXML
    private void onActionBtnLimpiar(ActionEvent event) {
    }

    @FXML
    private void onActionBtnGuardar(ActionEvent event) {
    }

    @FXML
    private void onActionBtnEliminar(ActionEvent event) {
    }
    
}
