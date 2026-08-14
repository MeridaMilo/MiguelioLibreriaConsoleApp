
package org.miguelio.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.miguelio.dao.EditorialDAO;
import org.miguelio.dao.impl.EditorialDAOimpl;
import org.miguelio.model.Editorial;
import org.miguelio.system.Principal;

public class EditorialFXController implements Initializable {

    @FXML
    private TextField txtnit;
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
    @FXML TableColumn colNIT;
    @FXML TableColumn colNombre;
    @FXML TableColumn colTelefono;
    @FXML TableColumn colDireccion;
    
    private final EditorialDAO editorialDAO = new EditorialDAOimpl();
    private final ObservableList<Editorial> listaEditorial = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarTabla();        
        cargarTabla();
        seleccionarFila();
    }
    
    private void configurarTabla() {
        //CellValueFactory, propertyValueFactory
        //Valor de fabrica de celda, propiedad de fabrica de celda
        colNIT.setCellValueFactory(new PropertyValueFactory<Editorial,String>("nit"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Editorial,String>("Nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<Editorial,String>("Telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<Editorial,String>("Direccion"));  
    }
   
    private void cargarTabla() {
        listaEditorial.setAll(editorialDAO.listarTodos());
        tablaEditorial.setItems(listaEditorial);
    }

    private void seleccionarFila() {
        tablaEditorial.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtnit.setText(String.valueOf(newSelection.getNit()));
                        txtNombre.setText(newSelection.getNombre());
                        txtDireccion.setText(newSelection.getDireccion());
                        txtTelefono.setText(newSelection.getTelefono());
                    }
                });
    }

    @FXML
    public void handleGuardarEditorial() {
        try {
            if (txtnit.getText().isEmpty() || txtNombre.getText().isEmpty()
                    || txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
                mostrarError("Los campos son necesarios y obligatorios.");
                return;
            }

            Editorial editorial = new Editorial();
            editorial.setNit((txtnit.getText().trim()));
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
    public void handleLimpiarEditorial() {
        limpiarFormulario();
        lblMensaje.setText("");
    }

    @FXML
    public void handleActualizarEditorial() {
        cargarTabla();
        lblMensaje.setText("Tabla actualizada.");
    }

    @FXML
    public void handleVolverEditorial() {
        try {
            Principal.cambiarVista("/org/miguelio/view/MenuPrincipal.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtnit.clear();
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
