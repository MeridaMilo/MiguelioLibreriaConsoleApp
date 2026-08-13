package org.miguelio.dao.impl;
 
import java.util.ArrayList;
import org.miguelio.dao.AutorDAO;
import org.miguelio.model.Autor;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import org.miguelio.utils.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class AutorDAOimpl implements AutorDAO{
 
    @Override
    public boolean crear(Autor autor) {
        return false;
    }
 
    @Override
    public List<Autor> listarTodos() {
        List<Autor> Autores = new ArrayList<>();
        String consulta = "{call sp_listarautores()}";
        try  (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta);
              ResultSet tablaResultado = consultaCall.executeQuery();) {

              while (tablaResultado.next()) {
                  Autores.add(new Autor(
                          tablaResultado.getLong("id_autor"),
                          tablaResultado.getString("nombre_autor"),
                          tablaResultado.getString("apellido_autor"),
                          tablaResultado.getString("nacionalidad"),
                          tablaResultado.getString("biografia")
                  ));
            }

        } catch (SQLException e) {
            System.err.print("Error al Listar Autores " + e.getMessage());
        }
         return Autores;
    }
 
    @Override
    public Autor buscar(String Nit) {
             Autor autor = new Autor();
 
        //consulta
        String consultaSQL = "{call sp_buscareditorial(?)}";
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consultaSQL);) {
            consultaCall.setString(1, Nit);
            ResultSet tablaResultado = consultaCall.executeQuery();
            if (tablaResultado.next()) {
                autor.setId(tablaResultado.getLong("Id"));
                autor.setNombre(tablaResultado.getString("nombre_autor"));
                autor.setApellido(tablaResultado.getString("apellido_autor"));
                autor.setNacionalidad(tablaResultado.getString("Nacionalidad"));
                autor.setBiografia(tablaResultado.getString("Biografia"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.print("Error al buscar Autor: " + e.getMessage());
        }
        //retornamos el objeto
        return autor;
    }
 
    @Override
    public boolean actualizar(Autor Autor) {
        return false;
    }
 
    @Override
    public boolean eliminar(String Id) {
        return false;
    }
}