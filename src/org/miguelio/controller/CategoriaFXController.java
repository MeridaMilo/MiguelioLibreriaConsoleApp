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
    @FXML
    private TableColumn<Categoria, Integer> colID;
    @FXML
    private TableColumn<Categoria, String> colNombre;
    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
    private final ObservableList<Categoria> listaCategoria
            = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarTabla();
        cargarTabla();
        seleccionarFila();
    }
    private void configurarTabla() {
        colID.setCellValueFactory(
                new PropertyValueFactory<>("idCategoria")
        );
        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombreCategoria")
        );
    }
    private void cargarTabla() {
        listaCategoria.setAll(categoriaDAO.listarTodos());
        tablaCategoria.setItems(listaCategoria);
    }
    private void seleccionarFila() {
        tablaCategoria.getSelectionModel()
     .selectedItemProperty()
    .addListener((obs, oldSelection, newSelection) -> {
     if (newSelection != null) {
     txtIdCategoria.setText(
                                String.valueOf(newSelection.getIdCategoria())
                        );

                        txtNombreCategoria.setText(
                                newSelection.getNombreCategoria()
                        );
                    }
                });
    }

        @FXML

    private void handleGuardar() {
        try {
            if (txtIdCategoria.getText().isEmpty()) {
                mostrarError("El nombre de la categoría es obligatorio.");
                return;
            }
            Categoria categoria = new Categoria();
            categoria.setNombreCategoria(txtIdCategoria.getText().trim());
 
            if (categoriaDAO.crear(categoria)) {

                lblMensaje.setText("Categoria registrada exitosamente.");

                cargarTabla();

                limpiarFormulario();
            } else {

                mostrarError("No se pudo registrar la categoria.");
            }
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

        lblMensaje.setText(
                "Tabla actualizada."
        );
    }
    @FXML
    public void handleVolver() {

        try {

            main.cambiarVista(
                    "/org/miguelio/view/MenuPrincipal.fxml"
            );

        } catch (Exception e) {

            mostrarError(
                    "Error al volver al menú: "
                    + e.getMessage()
            );
        }
    }

    private void limpiarFormulario() {

        txtIdCategoria.clear();
        txtNombreCategoria.clear();
    }

    private void mostrarError(String mensaje) {

        Alert alert = new Alert(
                Alert.AlertType.ERROR
        );

        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}
