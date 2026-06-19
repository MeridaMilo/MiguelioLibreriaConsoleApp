
package org.miguelio.dao;
import java.util.List;
import org.miguelio.model.Categoria;

public interface CategoriaDAO {
   ///firmas de metodos
    //CRUD
    boolean insertar(Categoria categoria);
    List<Categoria> listar();
    Categoria buscar(int cui);
    boolean actualizar(Categoria categoria);
    boolean eliminar(long cui);
}
