
package org.miguelio.system;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

    private static Stage escenarioPrincipal;

    public static void cambiarEscena(String rutaFXML) throws IOException {
        //Parent raiz = FXMLLoader.load(getClass().getResource(rutaFXML));
        Parent raiz = FXMLLoader.load(Principal.class.getResource(rutaFXML));                
        Scene escena = new Scene(raiz); 
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        escenarioPrincipal.centerOnScreen();
        escenarioPrincipal.show();        
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        //convertir .fxml en nodo raiz
        Principal.escenarioPrincipal = escenarioPrincipal;     
        cambiarEscena("/org/ac/view/InicioSesionView.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}