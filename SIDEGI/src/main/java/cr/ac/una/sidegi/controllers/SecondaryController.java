package cr.ac.una.sidegi.controllers;

import cr.ac.una.sidegi.App;
import cr.ac.una.sidegi.util.FlowController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SecondaryController extends Controller implements Initializable {

    @FXML
    private void switchToPrimary() throws IOException {
        FlowController.getInstance().goView("primary");
    }

    @Override
    public void initialize() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}