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
import org.miguelio.dao.CategoriaDAO;
import org.miguelio.dao.impl.CategoriaDAOImpl;
import org.miguelio.model.Categoria;
import org.miguelio.system.main;

public class CategoriaFXController implements Initializable {

    @FXML
    private TextField txtIdCategoria;
    @FXML
    private TextField txtNombreCategoria;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Categoria> tablaCategoria;

    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
    private final ObservableList<Categoria> listaCategoria = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarTabla();
        seleccionarFila();
    }

    private void cargarTabla() {
        listaCategoria.setAll(categoriaDAO.listarTodos());
        tablaCategoria.setItems(listaCategoria);
    }

    private void seleccionarFila() {
        tablaCategoria.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtIdCategoria.setText(String.valueOf(newSelection.getIdCategoria()));
                        txtNombreCategoria.setText(newSelection.getNombreCategoria());
                    }
                });
    }

    @FXML
    public void handleGuardar() {
        try {
            if (txtIdCategoria.getText().isEmpty()
                    || txtNombreCategoria.getText().isEmpty()) {

                mostrarError("Los campos son necesarios y obligatorios.");
                return;
            }

            Categoria categoria = new Categoria();
            categoria.setIdCategoria(
                    Integer.parseInt(txtIdCategoria.getText().trim()));
            categoria.setNombreCategoria(
                    txtNombreCategoria.getText().trim());

            if (categoriaDAO.crear(categoria)) {
                lblMensaje.setText("La categoría se registró exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar la categoría.");
            }

        } catch (NumberFormatException e) {
            mostrarError("El ID debe ser un número válido.");
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
            main.cambiarVista("/org/miguelio/view/MenuPrincipal.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtIdCategoria.clear();
        txtNombreCategoria.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}