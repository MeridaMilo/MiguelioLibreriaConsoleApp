package org.miguelio.system;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

    private static Stage escenarioPrincipal;

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            Principal.escenarioPrincipal = escenarioPrincipal;     
            cambiarEscena("/org/miguelio/view/InicioSesionView.fxml");
            escenarioPrincipal.setTitle("Librería");
        } catch (Exception e) {
            System.err.println("Error crítico al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void cambiarEscena(String rutaFXML) throws IOException {
        URL archivoURL = Principal.class.getResource(rutaFXML);
        
        if (archivoURL == null) {
            throw new IOException("No se encontró el archivo FXML: " + rutaFXML);
        }

        FXMLLoader loader = new FXMLLoader(archivoURL);
        Parent root = loader.load();
        
        Scene escena = new Scene(root); 
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        escenarioPrincipal.centerOnScreen();
        escenarioPrincipal.show();        
    }

    public static void cambiarVista(String fxmlPath) throws Exception {
        FXMLLoader loader = new FXMLLoader(Principal.class.getResource(fxmlPath));
        Parent root = loader.load();
        escenarioPrincipal.setScene(new Scene(root));
    }

    public static void main(String[] args) {
        launch(args);
    }
}





