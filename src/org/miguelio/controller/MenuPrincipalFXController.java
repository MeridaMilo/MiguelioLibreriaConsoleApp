
package org.miguelio.controller;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.miguelio.system.main;

public class MenuPrincipalFXController {
    
    @FXML 
    public void handleEditorial(){
        try{
            main.cambiarVista("/org/miguelio/view/EditorialFXView.fxml");
        }catch(Exception e) {
            mostrarError("Error al cargar la vista de editoriales: ");
        }
}

    @FXML 
    public void handleNoDisponible(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modulo no disponible");
        alert.setHeaderText(null);
        alert.setContentText("Este modulo no esta disponible aun.");
        alert.showAndWait();
 }       
    @FXML 
    public void handleSalir(){
    Platform.exit();
    }
private void mostrarError(String mensaje) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
}

}


