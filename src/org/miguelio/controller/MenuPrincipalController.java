
package org.miguelio.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import org.miguelio.system.Principal;

//falta el extends initilize
/// hhh
public class MenuPrincipalController {

    @FXML
    private void handleClientes() {
        try {
            Principal.cambiarVista("/org/miguelio/view/ClienteView.fxml");
        } catch (Exception e) {
            mostrarError("Error al cargar la vista de clientes:\n" + e.getMessage());
        }
    }

    @FXML
    private void handleNoDisponible() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Módulo no disponible");
        alert.setHeaderText(null);
        alert.setContentText("Este módulo no está disponible aún.");
        alert.showAndWait();
    }

    @FXML
    private void handleSalir() {
        Platform.exit();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}

