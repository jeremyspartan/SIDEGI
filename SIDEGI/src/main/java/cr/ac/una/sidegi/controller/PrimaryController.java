package cr.ac.una.sidegi.controller;

import com.jfoenix.controls.JFXButton;
import cr.ac.una.sidegi.util.FlowController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PrimaryController extends Controller implements Initializable {

    @FXML
    private Button primaryButton;
    @FXML
    private JFXButton JFXBtn;


    @FXML
    private void switchToSecondary() throws IOException {
        FlowController.getInstance().goView("secondary");
    }

    @FXML
    private void onActionBtn(ActionEvent event) {
        System.out.println("Culo");
    }

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void initialize() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
