/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.controller;

import cr.ac.una.sidegi.util.Calendario;
import cr.ac.una.sidegi.util.CasillaCalendario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class AgendaViewController extends Controller {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imvPrevMonth;
    @FXML
    private Label lblMes;
    @FXML
    private Label lblAnnio;
    @FXML
    private ImageView imvNextMonth;
    @FXML
    private GridPane gpCalendario;
    private Calendario calendario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize() {
        //
        calendario=new Calendario();
        escribirMesAnnio();
        marcarCalendario();
        escribirDias();
    }
    private void escribirDias(){
        calendario.escribirDias(gpCalendario);
    }
    private void escribirMesAnnio(){
        lblMes.setText(calendario.getMesActualNombre());
        lblAnnio.setText(Integer.toString(calendario.getAnnioActual()));
    }
    private void marcarCalendario(){    // Salir cuando se complete el numero de dias
        
        for(int i=0;i<=5;i++){
            for(int j=0;j<=6;j++){
                CasillaCalendario casilla = new CasillaCalendario();
                gpCalendario.add(casilla.getRootCasilla(), j, i);
               // calendario.agregarListaContenedores(casilla, i, j);
            }         
        }
    }
    @FXML
    private void onMouseClickedPrevMonth(MouseEvent event) {   //Funcion para pasar al mes anterior
        System.out.println("MES ANTERIOR");
        calendario.mesAnterior();
        
        gpCalendario.getChildren().clear();           //cambiar esto
        marcarCalendario();
        
        escribirMesAnnio();
        escribirDias();
    }

    @FXML
    private void onMouseClickedNextMonth(MouseEvent event) {    //Funcion para pasar al mes siguiente
        System.out.println("MES SIGUIENTE");
        calendario.mesSiguiente();
        escribirMesAnnio();
        
        gpCalendario.getChildren().clear();           //cambiar esto
        marcarCalendario();
        
        escribirMesAnnio();
        escribirDias();
    }

    
    
}
