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
import cr.ac.una.sidegi.model.dto.DireccionDto;
import cr.ac.una.sidegi.model.dto.EscolaridadDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import cr.ac.una.sidegi.model.dto.PacienteDto;
import cr.ac.una.sidegi.model.dto.PersonaDto;
import cr.ac.una.sidegi.model.dto.TipoContactoDto;
import cr.ac.una.sidegi.model.dto.TipoSeguroDto;
import cr.ac.una.sidegi.service.PersonaService;
import cr.ac.una.sidegi.util.Mensaje;
import cr.ac.una.sidegi.util.Respuesta;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.Property;
import javafx.scene.control.Alert;

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
    private JFXComboBox<String> cmbTipoSeguro;
    @FXML
    private JFXComboBox<String> cmbEscolaridad;
    @FXML
    private JFXTextArea txaDiagnosticoMedico;
    @FXML
    private JFXComboBox<String> cmbEstadoPaciente;
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
    private TipoSeguroDto tipoSeguro;
    private EscolaridadDto escolaridad;
    private DireccionDto direccion;
    private PersonaDto persona;
    private List<Node> requeridos = new ArrayList<>();
    @FXML
    private JFXTextField txtDireccion;
    

    @Override
    public void initialize() {
        persona = new PersonaDto();
        nuevaPersona();
    }
    
    private void nuevaPersona()
     {
         unbindExpediente();
         bindExpediente(true);
         txtNombre.clear();
         txtNombre.requestFocus();
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
    
    
    private void bindExpediente(Boolean nuevo){
//            txtDoctor.textProperty().bindBidirectional(paciente.pacDoctor);
//            dtpFechaDiagnostico.valueProperty().bindBidirectional(paciente.pacfechaDiagnostico);
//            dtpFechaReferencia.valueProperty().bindBidirectional(paciente.pacFechaReferencia);
//            txtProfesionalResponsable.textProperty().bindBidirectional(paciente.pacProfesionalResponsable);
//            txaDiagnosticoMedico.textProperty().bindBidirectional(paciente.pacDiagnostico);
//            dtpFechaRegistro.valueProperty().bindBidirectional(paciente.pacFechaRegistro);
//            cmbEstadoPaciente.valueProperty().bindBidirectional(paciente.pacEstado); 
            txtCedula.textProperty().bindBidirectional(persona.perCedula);
            txtNombre.textProperty().bindBidirectional(persona.perNombre);
            txtPrimerApellido.textProperty().bindBidirectional(persona.perPapellido);
            txtSegundoApellido.textProperty().bindBidirectional(persona.perSapellido);
            dtpFechaNacimeinto.valueProperty().bindBidirectional(persona.perFechaNacimiento);
//            cmbTipoSeguro.valueProperty().bindBidirectional(tipoSeguro.tipoSegDesc);
//            cmbEscolaridad.valueProperty().bindBidirectional(escolaridad.escDesc);
//            txtDireccion.textProperty().bindBidirectional(direccion.direcDesc);
    }
    
    private void unbindExpediente()
    {
//            txtDoctor.textProperty().unbind();
//            dtpFechaDiagnostico.valueProperty().unbind();
//            dtpFechaReferencia.valueProperty().unbind();
//            txtProfesionalResponsable.textProperty().unbind();
//            txaDiagnosticoMedico.textProperty().unbind();
//            dtpFechaRegistro.valueProperty().unbind();
//            cmbEstadoPaciente.valueProperty().unbind();
            txtCedula.textProperty().unbind();
            txtNombre.textProperty().unbind();
            txtPrimerApellido.textProperty().unbind();
            txtSegundoApellido.textProperty().unbind();
            dtpFechaNacimeinto.valueProperty().unbind();
//            cmbTipoSeguro.valueProperty().unbind();
//            cmbEscolaridad.valueProperty().unbind();
//            txtDireccion.textProperty().unbind();
    }
    
    @FXML
    private void onActionBtnLimpiar(ActionEvent event) {
    }

    @FXML
    private void onActionBtnGuardar(ActionEvent event) {
//        persona.setPerCedula("116860582");
//        persona.setPerNombre("Alberth");
//        persona.setPerPapellido("Gamboa");
//        persona.setPerSapellido("Alfaro");
//        persona.setPerFechaNacimiento(LocalDate.of(1997, Month.SEPTEMBER, 4));
        
//        PersonaService service = new PersonaService();
//        Respuesta respuesta = service.guardarPersona(persona);
//        Respuesta respuesta;
        
        try {
            String invalidos = validarRequeridos();
            if (!invalidos.isEmpty()) {
                new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar persona", getStage(), invalidos);
            } else {
                PersonaService service = new PersonaService();
                    Respuesta respuesta = service.guardarPersona(persona);
                    if (!respuesta.getEstado()) {
                        new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar persona", getStage(), respuesta.getMensaje());
                    } else {
                            unbindExpediente();
//                            persona = (PersonaDto) respuesta.guardarPersona(persona);
                            
                            bindExpediente(false);
                            new Mensaje().showModal(Alert.AlertType.INFORMATION, "Guardar persona", getStage(), "Persona actualizado correctamente.");
                    }  
            }
        } catch (Exception ex) {
            Logger.getLogger(ExpedienteViewController.class.getName()).log(Level.SEVERE, "Error guardando el producto.", ex);
            System.out.println(ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar persona", getStage(), "Ocurrio un error guardando el producto.");
        }
    }

    @FXML
    private void onActionBtnEliminar(ActionEvent event) {
    }
    
}
