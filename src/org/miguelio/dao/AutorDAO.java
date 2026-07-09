
package org.miguelio.dao.impl;
import java.util.ArrayList;
import org.miguelio.model.Autor;
import org.miguelio.dao.AutorDAO;
import java.util.List;
 // segundo
 
public class AutorDAOimpl implements AutorDAO {
 
    @Override
    public boolean insertar(Autor autor) {
        return false;
    }
 
    @Override
    public List<Autor> listar(){
        //crear lista
        List<Autor> Autor = new ArrayList ();//nuññ
        //crear nuestras consulta
       String consulta = "{call sp_listarcategoria()}"; 
    //mapear el resultado de la consulta a objeto y lo agregamos
   try (conexion){
   }catch (Exception e){
   }

// retornamos una lista 
       return null;

 
    @Override
    public Autor buscar(int cui) {
        return null;
    }
 
    @Override
    public boolean actualizar(Autor autor) {
        return false;
    }
 
    @Override
    public boolean eliminar(long cui) {
        return false;
    }
}






















