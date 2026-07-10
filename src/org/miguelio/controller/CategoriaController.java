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

            switch (opcion) {

                case 1:
                    System.out.println("Crear categoría");
                    break;

                case 2:
                    dao.ListarTodos().forEach(categoria ->
                        System.out.println(
                            categoria.getIdCategoria() + " - " +
                            categoria.getNombreCategoria()));
                    break;

                case 3:
                    System.out.println("Buscar categoría");
                    break;

                case 4:
                    System.out.println("Modificar categoría");
                    break;

                case 5:
                    System.out.println("Eliminar categoría");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}