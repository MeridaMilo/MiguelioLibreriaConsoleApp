
package org.miguelio.controller;

import org.miguelio.dao.EditorialDAO;
import org.miguelio.dao.impl.EditorialDAOimpl;
import org.miguelio.view.EditorialConsoleView;

public class EditorialController {
    
    private final EditorialDAO dao;
    private final EditorialConsoleView vista;
    
    public EditorialController(EditorialConsoleView vista) {
        this.dao = new EditorialDAOimpl();
        this.vista = vista;
    }
    
    public void iniciar (){
    int opcion;
    do {
        opcion = vista.mostrarMenu();
        if (opcion = 2) {
            listar();
            
        }
    } while (opcion = 4 );
}
    private void listar() {
        vista.mostrarListaEditorial(dao.listarTodos());
    }
}
