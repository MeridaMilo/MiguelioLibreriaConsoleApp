
package org.miguelio.controller;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;
import org.miguelio.model.Usuario;
import org.miguelio.utils.SesionContext;

    import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.miguelio.model.Usuario;
import org.miguelio.util.SesionContext;

public class AdminDashboradController implements Initializable {

    @FXML private Label lblBienvenida;
    private Usuario usuarioActual;
    
    public void initialize(URL url, ResourceBundle rb) {
         usuarioActual = SesionContext.getInstancia().getUsuairoActual();
    }

    public void iniciarUsuario(Usuario usuario){        
        lblBienvenida.setText("Bienvenido administrador " + usuario.getUsername());
        //instrucciones
    }
    
    
}
}
