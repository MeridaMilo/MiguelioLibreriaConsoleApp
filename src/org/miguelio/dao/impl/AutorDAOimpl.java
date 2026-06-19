
package org.miguelio.dao.impl;

import org.miguelio.model.Autor;
import org.miguelio.dao.AutorDAO;

import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Conexion;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class AutorDAOimpl implements AutorDAO{

    @Override
    public boolean insertar(Autor autor) {
        return false;
    }

    @Override
    public List<Autor> listar() {
        return null;
    }

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
