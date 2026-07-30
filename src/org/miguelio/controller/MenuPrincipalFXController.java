
package org.miguelio.controller;

import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;




public class MenuPrincipalFXController {
    
    @FXML 
    private void handleEditorial(){
        try{
            Main.cambiarVista("/org/miguelio/view/EditorialFXView.fxml");
        }catch(Exception e) {
            mostrarError("Error al cargar la vista de editoriales: ");
        }
}

    @FXML 
    private void handleNoDisponible(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modulo no disponible");
        alert.setHeaderText(null);
        alert.setContentText("Este modulo no esta disponible aun.");
        alert.showAndWait();
 }       
    @FXML 
    private void handleSalir(){
    Platform.exit();
    }
private void mostrarError(String mensaje) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
}

}


