
package org.miguelio.controller;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.miguelio.dao.UsuarioDAO;
import org.miguelio.model.Usuario;
import org.miguelio.system.Principal;
import org.miguelio.utils.SesionContext;
import org.miguelio.utils.ValidacionException;

public class InicioSesionController implements Initializable{
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
        //btnIniciarSesion.setOnAction(e -> eventoInicioSesion());

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
            //alerta
            mostrarAlerta(Alert.AlertType.WARNING, e.getMessage());
            lblMensaje.setText(e.getMessage());
        }        
    }
    //metodo para boton registrarse
    public void eventoRegistrarse(ActionEvent evento){
        try {
            Principal.cambiarEscena("/org/ac/view/RegistrarUsuarioView.fxml");
        } catch (IOException e) {
            System.err.println("Error al carger registro:  " +  e.getMessage());
            lblMensaje.setText("Error interno");
        }
    }
    
    
    
    private void abrirDashboard(Usuario usuario) {
        SesionContext.getInstancia().setUsuairoActual(usuario);
        String rutaFXML = "";        
        
        switch (usuario.getRol().toLowerCase()) {
            case "admin":
                rutaFXML = "/org/ac/view/AdminDashboradView.fxml";
                
                break;
            case "empleado":
                rutaFXML = "/org/ac/view/EmpleadoDashboradView.fxml";
                break;
            
        }
        try {
            Principal.cambiarEscena(rutaFXML);
            
        } catch (IOException e) {
            System.err.println("Error al cargar la vista:" + rutaFXML + e.getMessage());
            lblMensaje.setText("Error interno");
        }
    }
    
    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alerta = new Alert(tipo, mensaje, ButtonType.OK);
        alerta.show();
    }
    
}
}

