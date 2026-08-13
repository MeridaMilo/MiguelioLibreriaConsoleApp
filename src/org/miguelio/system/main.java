package org.miguelio.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    public static Stage escenarioPrincipal;
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        this.escenarioPrincipal = escenarioPrincipal;
        FXMLLoader loader = new FXMLLoader(
         getClass().getResource(
        "/org/miguelio/view/CategoriaFXView.fxml"
                )
        );
        Parent root = loader.load();
        Scene scene = new Scene(root);
        escenarioPrincipal.setTitle("Miguelio Libreria");
        escenarioPrincipal.setScene(scene);
        escenarioPrincipal.show();
    }

    public static void cambiarVista(String fxmlPath) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                main.class.getResource(fxmlPath)
        );
        Parent root = loader.load();
        escenarioPrincipal.setScene(
                new Scene(root)
        );
    }
    public static void main(String[] args) {
        launch(args);
    }
}