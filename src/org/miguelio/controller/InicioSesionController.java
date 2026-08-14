
package org.miguelio.controller;
import java.io.IOException;
import org.miguelio.dao.UsuarioDAO;
import org.miguelio.util.SecurityUtil;
import org.miguelio.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import org.miguelio.system.Principal;
import org.miguelio.util.SesionContext;
import org.miguelio.util.ValidacionException;

public class InicioSesionController implements Initializable {
    
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Label lblMensaje;
    
    private UsuarioDAO usuarioDAO;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarioDAO = new UsuarioDAO();
        lblMensaje.setText("");
    }
    
    @FXML
    public void eventoInicioSesion(ActionEvent evento) {
        try {
            ValidacionException.validarNoVacio(txtUsuario.getText(), "usuario");
            ValidacionException.validarNoVacio(txtPassword.getText(), "contraseña");
            
            String usuario = txtUsuario.getText();
            String password = txtPassword.getText();
            String passwordHash = SecurityUtil.hashSHA256(password);
            Usuario usuarioIniciado = usuarioDAO.iniciarSesion(usuario, passwordHash);            
            
            if (usuarioIniciado != null) {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Inicio correcto");
                abrirDashboard(usuarioIniciado);
            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Usuario o contraseña incorrectos");
            }
            
        } catch (ValidacionException e) {
            mostrarAlerta(Alert.AlertType.WARNING, e.getMessage());
            lblMensaje.setText(e.getMessage());
        }        
    }

    
    @FXML
    public void eventoRegistrarse(ActionEvent evento){
        try {
            Principal.cambiarEscena("/org/miguelio/view/RegistrarUsuarioView.fxml");
        } catch (IOException e) {
            System.err.println("Error al cargar registro: " + e.getMessage());
            lblMensaje.setText("Error interno");
        }
    }
    
    private void abrirDashboard(Usuario usuario) {
        SesionContext.getInstancia().setUsuairoActual(usuario);
        String rutaFXML = "";        
        
        
        if (usuario.getUsername() != null) {
            switch (usuario.getUsername().toLowerCase()) {
                case "Menu Principal": 
                    rutaFXML = "/org/miguelio/view/MenuPrincipal.fxml";
                    break;
                default:
                    rutaFXML = "/org/miguelio/view/MenuPrincipal.fxml";
                    break;
            }
        }

        try {
            Principal.cambiarEscena(rutaFXML);
        } catch (IOException e) {
            System.err.println("Error al cargar la vista: " + rutaFXML + " - " + e.getMessage());
            lblMensaje.setText("Error interno al abrir la ventana");
        }
    }
    
    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alerta = new Alert(tipo, mensaje, ButtonType.OK);
        alerta.show();
    }
}