/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.sidegi.util;

import cr.ac.una.sidegi.App;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import cr.ac.una.sidegi.controller.Controller;
import javafx.stage.StageStyle;
import java.util.logging.Logger;
import java.util.logging.Level;
public class FlowController {

    private static FlowController INSTANCE = null;
    private static Stage mainStage;
    private static Stage Stage2;
    private static Stage mainPantallaEmergente;
    private static Stage pantallaEmergente;
    private static ResourceBundle idioma;
    private static HashMap<String, FXMLLoader> loaders = new HashMap<>();

    public FlowController() {
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            synchronized (FlowController.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FlowController();
                }
            }
        }
    }

    public static FlowController getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void InitializeFlow(Stage stage, ResourceBundle idioma) {
        getInstance();
        this.mainStage = stage;
        this.mainPantallaEmergente = stage;
        this.idioma = idioma;
    }

    public void CloseMainStage() {
        
//        this.mainStage.initStyle(StageStyle.UNDECORATED);
    }
    private FXMLLoader getLoader(String name) {
        FXMLLoader loader = loaders.get(name);
        if (loader == null) {
            synchronized (FlowController.class) {
                if (loader == null) {
                    try {
                        loader = new FXMLLoader(App.class.getResource("views/" + name + ".fxml"), this.idioma);
                        loader.load();
                        loaders.put(name, loader);
                    } catch (Exception ex) {
                        loader = null;
                        java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Creando loader [" + name + "].", ex);
                    }
                }
            }
        }
        return loader;
    }

    public void goMain() {
        try {
            //this.mainStage.initStyle(StageStyle.UNDECORATED);
            this.mainStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("views/root.fxml"), this.idioma)));
            this.mainStage.setResizable(true);
           // this.mainStage.getIcons().add(new Image(App.class.getResource("resources/Television.png").toString()));
            this.mainStage.setTitle("SDEGI");
            ResizeHelper.addResizeListener(this.mainStage);
//            this.mainStage.setHeight(400);
//            this.mainStage.setWidth(600);
            this.mainStage.setMinWidth(1188);
            this.mainStage.setMinHeight(700);
            this.mainStage.show();
            
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Error inicializando la vista base.", ex);
        }
    }

    public void goView(String viewName) {
        goView(viewName, "Center", null);
    }

    public void goView(String viewName, String accion) {
        goView(viewName, "Center", accion);
    }

    public void goView(String viewName, String location, String accion) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setAccion(accion);
        controller.initialize();
        Stage stage = controller.getStage();
        if (stage == null) {
            stage = this.mainStage;
            controller.setStage(stage);
        }
        switch (location) {
            case "Center":
                try{
                    Scene pane = ((Scene) stage.getScene());
                   System.out.println("hmmm "+ stage.getScene().toString()); 
                }
                catch (NullPointerException e)
                {
                    System.out.println(e.getMessage()+" error");
                }
                ((VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()).getChildren().clear();
                ((VBox) ((BorderPane) stage.getScene().getRoot()).getCenter()).getChildren().add(loader.getRoot());
                break;
            case "Top":
                break;
            case "Bottom":
                break;
            case "Right":
                break;
            case "Left":
                break;
            default:
                break;
        }
    }

    public void goViewInStage(String viewName, Stage stage) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setStage(stage);
        stage.getScene().setRoot(loader.getRoot());
    }

    public void goViewInWindow(String viewName) {
        
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.initialize();
        Stage stage = new Stage();
        
        //stage.getIcons().add(new Image(App.class.getResource("resources/Television.png").toString()));
        stage.setTitle("SIDEGI");
        
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        controller.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setHeight(600);
        stage.setWidth(800);
        stage.setMinWidth(800);
        stage.setMinHeight(600);

        pantallaEmergente=stage;
        
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        ResizeHelper.addResizeListener(stage);
//         stage.setMinWidth(scene.getWidth());
//        stage.setMinHeight(scene.getHeight());
        stage.centerOnScreen();
        this.mainPantallaEmergente = stage;
        stage.show();

    }
    
    public void goViewMenu(String viewName) {
        
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.initialize();
        Stage stage = new Stage();
        
        stage.getIcons().add(new Image(App.class.getResource("resources/Television.png").toString()));
        stage.setTitle("RelojUna");
        
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        controller.setStage(stage);
        stage.initStyle(StageStyle.UNDECORATED);
//        stage.setHeight(600);
//        stage.setWidth(800);
        stage.setMinWidth(1188);
        stage.setMinHeight(700);
        Stage2=stage;
        
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        ResizeHelper.addResizeListener(stage);
//         stage.setMinWidth(scene.getWidth());
//        stage.setMinHeight(scene.getHeight());
        stage.centerOnScreen();
        this.mainStage = stage;
        stage.show();

    }
    public void goViewInWindowModal(String viewName, Stage parentStage, Boolean resizable) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.initialize();
        Stage stage = new Stage();
        //stage.getIcons().add(new Image(App.class.getResource("resources/Television.png").toString()));
        stage.setTitle("SIDEGI");
        stage.setResizable(resizable);
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        controller.setStage(stage);
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
                stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parentStage);
        stage.centerOnScreen();
        stage.showAndWait();

    }
   
    public Controller getController(String viewName) {
        return getLoader(viewName).getController();
    }

    public static void setIdioma(ResourceBundle idioma) {
        FlowController.idioma = idioma;
    }
    
    public void initialize() {
        this.loaders.clear();
    }

    public void salir() {
        this.mainStage.close();
        this.Stage2.close();
    }
    
    public void salirEmergente(){
        this.mainPantallaEmergente.close();
//        this.pantallaEmergente.close();
    }
    
}
