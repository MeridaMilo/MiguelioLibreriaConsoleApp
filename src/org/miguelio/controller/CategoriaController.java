package org.miguelio.controller;

import org.miguelio.dao.CategoriaDAO;
import org.miguelio.dao.impl.CategoriaDAOImpl;
import org.miguelio.view.CategoriaConsoleView;

public class CategoriaController {

    private final CategoriaDAO dao;
    private final CategoriaConsoleView vista;

    public CategoriaController(CategoriaConsoleView vista) {
        this.dao = new CategoriaDAOImpl();
        this.vista = vista;
    }

    public void iniciar() {

        int opcion;

        do {

            opcion = vista.mostrarMenu();

            if (opcion == 2) {
                listarTodos();
            }

        } while (opcion != 4);

    }

    private void listarTodos() {
        vista.mostrarListaCategorias(dao.listarTodos());
    }
}