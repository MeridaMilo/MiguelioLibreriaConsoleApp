
package org.miguelio.dao.impl;
import org.miguelio.utils.Conexion;
import org.miguelio.model.Categoria;
import org.miguelio.dao.CategoriaDAO;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CategoriaDAOimpl implements CategoriaDAO {

    @Override
    public boolean insertar(Categoria categoria) {
        return false;
    }

    @Override
    public List<Categoria> listar() {
       return null;
    }

    @Override
    public Categoria buscar(int cui) {
        return null;
    }

    @Override
    public boolean actualizar(Categoria categoria) {
        return false;
    }

    @Override
    public boolean eliminar(long cui) {
        return false;
    }
    
}
