package org.miguelio.dao;
import java.util.List;
import org.miguelio.model.Editorial;


public interface EditorialDAO {
    //FIRMAS DE METODOS
    //Crud
    boolean insertar(Editorial editorial);
    List<Editorial> listar();
    Editorial buscar(String Nit);
    boolean actualizar(Editorial editorial);
    boolean eliminar(String Nit);
}
