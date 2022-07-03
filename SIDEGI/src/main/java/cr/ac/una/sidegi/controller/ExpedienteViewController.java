/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import cr.ac.una.sidegi.model.dto.PacienteDto;

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
    private PacienteDto paciente;
    
    private List<Node> requeridos = new ArrayList<>();

    @Override
    public void initialize() {
        
    }
    
        public void indicarRequeridos()
    {
        requeridos.clear();
        requeridos.addAll(Arrays.asList(txtNombre,txtPrimerApellido,txtSegundoApellido,txtCedula,dtpFechaNacimeinto,cmbTipoSeguro,cmbEscolaridad));
    }
    
    public String validarRequeridos()
    {
        boolean validos = true;
        String invalidos = "";
        for(Node node : requeridos)
        {
            if(node instanceof JFXTextField)
            {
                if(((JFXTextField) node).getText() == null || ((JFXTextField) node).getText().isEmpty())
                {
                  if(validos)
                  {
                    invalidos += ((JFXTextField) node).getPromptText();
                    validos = false;
                  }
                  else                                                                          
                  {
                    invalidos += "," + ((JFXTextField) node).getPromptText();
                  }   
                }
            }
            else if(node instanceof JFXPasswordField )
            {
                if(((JFXPasswordField) node).getText() == null || ((JFXPasswordField) node).getText().isEmpty())
                {
                  if(validos)
                  {
                    invalidos += ((JFXPasswordField) node).getPromptText();
                    validos = false;
                  }
                  else
                  {
                    invalidos += "," + ((JFXPasswordField) node).getPromptText();
                  }
                }
            }
            
            else if(node instanceof JFXDatePicker)
            {
                if( ((JFXDatePicker) node).getValue() == null )
                {
                  if(validos)
                  {
                    invalidos += "fecha";
                    validos = false;
                  }
                  else
                  {
                    invalidos += "," + "fecha";
                  }
                }
            }
         }
        if(validos)
        {
            return "";
        }
        else
        {
            return "Los siguientes campos son requeridos o tienen problemas de formato[" + invalidos + "].";
        }
    }
    
    
    private void bindUsuario(Boolean nuevo){
            txtDoctor.textProperty().bindBidirectional(paciente.pacDoctor);
            
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
