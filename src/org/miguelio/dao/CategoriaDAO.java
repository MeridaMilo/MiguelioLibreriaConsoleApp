package org.miguelio.dao;

import java.util.List;
import org.miguelio.model.Categoria;

public interface CategoriaDAO {

    // Firmas de métodos
    // CRUD

    boolean crear(Categoria categoria);

    List<Categoria> ListarTodos();

    Categoria buscar(int idCategoria);

    boolean actualizar(Categoria categoria);

    boolean eliminar(int idCategoria);
}