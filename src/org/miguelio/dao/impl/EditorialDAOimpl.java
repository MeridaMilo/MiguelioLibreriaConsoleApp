package org.miguelio.dao.impl;

import java.util.ArrayList;
import org.miguelio.dao.EditorialDAO;
import org.miguelio.model.Editorial;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import org.miguelio.utils.Conexion;
import java.sql.ResultSet;

public class EditorialDAOimpl implements EditorialDAO{

    @Override
    public boolean crear(Editorial editorial) {
        return false;
    }

    @Override
    public List<Editorial> listarTodos() {
       
        List<Editorial> editorial = new ArrayList<>();
        
        String consulta = "{call sp_listareditoriales()}";
        
        try  (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta);
              ResultSet tablaResultado = consultaCall.executeQuery();) {
                
                
              while (tablaResultado.next()) {
                  editorial.add(new Editorial(
                          tablaResultado.getString("Nit"),
                          tablaResultado.getString("nombre_editorial"),
                          tablaResultado.getString("telefono_editorial"),
                          tablaResultado.getString("direccion_editorial")
                                  ));
            }
         
              
        } catch (Exception e) {
            
        }
      
         return editorial;
    }

    @Override
    public Editorial buscar(String Nit) {
        return null;
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
