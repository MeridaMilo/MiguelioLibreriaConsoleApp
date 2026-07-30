package org.miguelio.dao.impl;

import java.util.ArrayList;
import org.miguelio.dao.EditorialDAO;
import org.miguelio.model.Editorial;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import org.miguelio.utils.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditorialDAOimpl implements EditorialDAO{

    @Override
    public boolean crear(Editorial editorial) {
        return false;
    }

    @Override
    public List<Editorial> listarTodos() {
       
        List<Editorial> editoriales = new ArrayList<>();
        
        String consulta = "{call sp_listareditoriales()}";
        
        try  (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta);
              ResultSet tablaResultado = consultaCall.executeQuery();) {
                
                
              while (tablaResultado.next()) {
                  editoriales.add(new Editorial(
                          tablaResultado.getString("Nit"),
                          tablaResultado.getString("nombre_editorial"),
                          tablaResultado.getString("telefono_editorial"),
                          tablaResultado.getString("direccion_editorial")
                                  ));
            }
         
              
        } catch (SQLException e) {
            System.err.print("Error al Listar Editoriales " + e.getMessage());
        }
      
         return editoriales;
    }

    @Override
    public Editorial buscar(String Nit) {
             Editorial cliente = new Editorial();

        //consulta
        String consultaSQL = "{call sp_buscareditorial(?)}";
        //mapeamos el ResultSet al Objeto(Cliente) segun sus atributos y la fila devulta
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consultaSQL);) {
            consultaCall.setString(1, Nit);
            ResultSet tablaResultado = consultaCall.executeQuery();
            if (tablaResultado.next()) {
                cliente.setNit(tablaResultado.getString("Nit"));
                cliente.setNombre(tablaResultado.getString("nombre_editorial"));
                cliente.setTelefono(tablaResultado.getString("Telefono"));
                cliente.setDireccion(tablaResultado.getString("Direccion"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.print("Error al buscar Editorial: " + e.getMessage());
        }
        //retornamos el objeto
        return cliente;
    }

    @Override
    public boolean actualizar(Editorial editorial) {
        return false;
    }

    @Override
    public boolean eliminar(String Nit) {
        return false;
    }
    
}
