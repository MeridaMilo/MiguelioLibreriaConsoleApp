package org.miguelio.controller;

import org.miguelio.dao.AutorDAO;
import org.miguelio.dao.impl.AutorDAOimpl;
import org.miguelio.view.AutorConsoleView;


public class AutorController {
    
    private final AutorDAO dao;
    private final AutorConsoleView vista;
    
    public AutorController(AutorConsoleView vista) {
        this.dao = new AutorDAOimpl();
        this.vista = vista;
    }
    
    public void iniciar (){
    int opcion;
    do {
        opcion = vista.mostrarMenu();
        if (opcion == 2) {
            listarTodos();
            
        }
    
    } while (opcion != 4 );
    
}
    
    private void listarTodos() {
        vista.mostrarListaAutor(dao.listarTodos());
    }
}