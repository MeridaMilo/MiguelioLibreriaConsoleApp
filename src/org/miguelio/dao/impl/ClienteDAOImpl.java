package org.miguelio.dao.impl;

import java.util.ArrayList;
import org.miguelio.dao.ClienteDAO;
import org.miguelio.model.Cliente;

import java.util.List;
import org.miguelio.utils.Conexion;
import java.sql.CallableStatement;
  import java.sql.ResultSet;     
import java.sql.Connection;
import java.sql.SQLException;
    

public abstract class ClienteDAOImpl implements ClienteDAO {

    @Override
    public boolean insertar(Cliente cliente) {
        return false;
    }

    @Override
    public List<Cliente> ListarTodo() {
        
        List<Cliente> clientes = new ArrayList<>();
        String consulta = "{call sp_Listarclientes();}";
        
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta);
             ResultSet tablaResultado = consultaCall.executeQuery();) {   System.out.println("");
            
                    do {               
                    
                } while (tablaResultado.next()); {
             clientes.add(new Cliente ( 
             tablaResultado.getLong("cui"),
                     tablaResultado.getString("nombre_cliente"),
                      tablaResultado.getString("apellido_cliente"),
                      tablaResultado.getString("Correo_electronico")
             ));
             }
        } catch (SQLException e) {
            System.err.print("Error al listar Clientes:" + e.getMessage());
        }
        
        
        return clientes;
    }

    public Cliente buscar(long cui) {
        return null;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        return false;
    }

    @Override
    public boolean eliminar(long cui) {
        return false;
    }
}