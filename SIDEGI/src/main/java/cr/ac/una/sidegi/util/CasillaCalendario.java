/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.util;

import static java.awt.Color.black;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Usuario
 */
public class CasillaCalendario {
    private HBox rootCasilla;
    private VBox vboxFecha;
    private VBox vboxTareas;
    private Label lblFecha;

    public CasillaCalendario() {
        this.lblFecha=new Label();
        this.vboxFecha = new VBox(lblFecha);
        this.vboxTareas = new VBox();
        this.rootCasilla = new HBox(vboxFecha,vboxTareas);    
        
        this.vboxTareas.alignmentProperty().set(Pos.TOP_CENTER);
        this.rootCasilla.setId("rootCasilla");
        //this.rootCasilla.getStylesheets().add(getClass().getResource("@../resources/style.css").toExternalForm());
        //this.rootCasilla.getStyleClass().add("")
                                                //Ver si se puede cambiar a clase
        this.rootCasilla.setStyle("-fx-padding: 1;"/* + "-fx-border-style: solid inside;"*/
/*        + "-fx-border-width: 1;" */+ "-fx-border-insets: 0;"
        + "-fx-border-radius: 1;" + "-fx-border-color: black;");
       // this.rootCasilla.setBorder(new Border(new BorderStroke(Color.valueOf(black.toString()))));
    }

    public HBox getRootCasilla() {
        return rootCasilla;
    }

    public Label getLblFecha() {
        return lblFecha;
    }
      
}
