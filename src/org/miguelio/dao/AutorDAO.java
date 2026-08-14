package org.miguelio.dao;
import java.util.List;
import org.miguelio.model.Autor;


public interface AutorDAO {
    //FIRMAS DE METODOS
    //Crud
    boolean crear( Autor  autor);
    List< Autor> listarTodos();
     Autor buscar(String id);
    boolean actualizar( Autor  autor);
    boolean eliminar(String id);
}






