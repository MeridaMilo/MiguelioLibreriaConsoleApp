package org.miguelio.dao;

import java.util.List;
import org.miguelio.model.Categoria;

public interface CategoriaDAO {

    boolean crear(Categoria categoria);

    List<Categoria> listarTodos();

    Categoria buscar(int idCategoria);

    boolean actualizar(Categoria categoria);

    boolean eliminar(int idCategoria);
}