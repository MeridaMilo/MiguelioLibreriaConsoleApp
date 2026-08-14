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

import org.miguelio.dao.AutorDAO;
import org.miguelio.dao.impl.AutorDAOimpl;
import org.miguelio.model.Autor;
import org.miguelio.system.main;

public class AutorFXController implements Initializable {

    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtNacionalidad;
    @FXML
    private TextField txtBiografia;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Autor> tablaAutor;
    @FXML
    private TableColumn<Autor, Long> colId;
    @FXML
    private TableColumn<Autor, String> colNombre;
    @FXML
    private TableColumn<Autor, String> colNacionalidad;
    
      @FXML
    private TableColumn<Autor, String> colBiografia;

      @FXML
private TableColumn<Autor, String> colApellido; // Reemplaza 'Autor' por tu clase modelo

    private final AutorDAO autorDAO = new AutorDAOimpl();

    private final ObservableList<Autor> listaAutor =
            FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarTabla();
        cargarTabla();
        seleccionarFila();
    }

    private void configurarTabla() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        colApellido.setCellValueFactory(
                new PropertyValueFactory<>("apellido")
        );

        colNacionalidad.setCellValueFactory(
                new PropertyValueFactory<>("nacionalidad")
        );
                colBiografia.setCellValueFactory(
                new PropertyValueFactory<>("biografia")
        );
    }

    private void cargarTabla() {

        listaAutor.setAll(autorDAO.listarTodos());

        tablaAutor.setItems(listaAutor);
    }

    private void seleccionarFila() {

        tablaAutor.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldSelection, newSelection) -> {

                    if (newSelection != null) {

                        txtID.setText(
                                String.valueOf(newSelection.getId())
                        );

                        txtNombre.setText(
                                newSelection.getNombre()
                        );

                        txtApellido.setText(
                                newSelection.getApellido()
                        );

                        txtNacionalidad.setText(
                                newSelection.getNacionalidad()
                        );

                        txtBiografia.setText(
                                newSelection.getBiografia()
                        );
                    }
                });
    }

    @FXML
    public void handleGuardar() {

        try {

            if (txtID.getText().isEmpty()
                    || txtNombre.getText().isEmpty()
                    || txtApellido.getText().isEmpty()
                    || txtNacionalidad.getText().isEmpty()
                    || txtBiografia.getText().isEmpty()) {

                mostrarError(
                        "Todos los campos son obligatorios."
                );

                return;
            }

            Autor autor = new Autor();

            autor.setId(
                    Long.parseLong(txtID.getText().trim())
            );

            autor.setNombre(
                    txtNombre.getText().trim()
            );

            autor.setApellido(
                    txtApellido.getText().trim()
            );

            autor.setNacionalidad(
                    txtNacionalidad.getText().trim()
            );

            autor.setBiografia(
                    txtBiografia.getText().trim()
            );

            if (autorDAO.crear(autor)) {

                lblMensaje.setText(
                        "El autor se ha registrado exitosamente."
                );

                cargarTabla();
                limpiarFormulario();

            } else {

                mostrarError(
                        "No se pudo registrar el autor."
                );
            }

        } catch (NumberFormatException e) {

            mostrarError(
                    "El ID debe ser un número válido."
            );

        } catch (Exception e) {

            mostrarError(
                    "Error al guardar: " + e.getMessage()
            );
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
                    "/org/miguelio/view/MenuPrincipalFXView.fxml"
            );

        } catch (Exception e) {

            mostrarError(
                    "Error al volver al menú: "
                    + e.getMessage()
            );
        }
    }

    private void limpiarFormulario() {

        txtID.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtNacionalidad.clear();
        txtBiografia.clear();
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