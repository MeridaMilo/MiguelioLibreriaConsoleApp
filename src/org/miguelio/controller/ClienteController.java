package org.miguelio.controller;

import org.miguelio.dao.ClienteDAO;
import org.miguelio.dao.impl.ClienteDAOImpl;
import org.miguelio.model.Cliente;
import org.miguelio.view.ClienteConsolerView;

public class ClienteController {
    
     private final ClienteDAO dao;
    private final ClienteConsolerView vista;
    
    public ClienteController(ClienteConsolerView vista) {
        this.dao = new ClienteDAOImpl();
        this.vista = vista;
    }
    
    public void iniciar (){
    int opcion;
    do {
        opcion = vista.mostrarMenu();
        if (opcion == 2); {
            listarTodos();
            
        }
    } while (opcion != 4 );
}
    
    private void listarTodos() {
        vista.mostrarListaClientes(dao.listarTodos());
}
}