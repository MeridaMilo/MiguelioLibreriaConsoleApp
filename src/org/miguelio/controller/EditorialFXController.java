
package org.miguelio.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.miguelio.dao.EditorialDAO;
import org.miguelio.dao.impl.EditorialDAOimpl;
import org.miguelio.model.Editorial;
import org.miguelio.system.main;

public class EditorialFXController implements Initializable {

    @FXML
    private TextField txtNIT;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Editorial> tablaEditorial;
   
    private final EditorialDAO editorialDAO = new EditorialDAOimpl();
    private final ObservableList<Editorial> listaEditorial = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarTabla();
        seleccionarFila();
    }

    private void cargarTabla() {
        listaEditorial.setAll(editorialDAO.listarTodos());
        tablaEditorial.setItems(listaEditorial);
    }

    private void seleccionarFila() {
        tablaEditorial.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtNIT.setText(String.valueOf(newSelection.getNit()));
                        txtNombre.setText(newSelection.getNombre());
                        txtDireccion.setText(newSelection.getDireccion());
                        txtTelefono.setText(newSelection.getTelefono());
                    }
                });
    }

    @FXML
    public void handleGuardar() {
        try {
            if (txtNIT.getText().isEmpty() || txtNombre.getText().isEmpty()
                    || txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
                mostrarError("Los campos son necesarios y obligatorios.");
                return;
            }

            Editorial editorial = new Editorial();
            editorial.setNit((txtNIT.getText().trim()));
            editorial.setNombre(txtNombre.getText().trim());
            editorial.setDireccion(txtDireccion.getText().trim());
            editorial.setTelefono(txtTelefono.getText().trim());

            if (editorialDAO.crear(editorial)) {
                lblMensaje.setText("El Editorial se ha registrado exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar el editorial.");
            }
        } catch (NumberFormatException e) {
            mostrarError("Su Nit debe ser un número válido.");
        } catch (Exception e) {
            mostrarError("Error al guardar: " + e.getMessage());
        }
    }

    @FXML
    public void handleLimpiar() {
        limpiarFormulario();
        lblMensaje.setText("");
    }

    @FXML
    public void handleActualizar() {
        cargarTabla();
        lblMensaje.setText("Tabla actualizada.");
    }

    @FXML
    public void handleVolver() {
        try {
            main.cambiarVista("/org/miguelio/view/MenuPrincipalFXView.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtNIT.clear();
        txtNombre.clear();
        txtDireccion.clear();
        txtTelefono.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
