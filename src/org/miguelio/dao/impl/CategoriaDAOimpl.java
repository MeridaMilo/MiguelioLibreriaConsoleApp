package org.miguelio.dao.impl;

import org.miguelio.utils.Conexion;
import org.miguelio.model.Categoria;
import org.miguelio.dao.CategoriaDAO;
import java.util.List;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> ListarTodos() {

        // Crear lista
        List<Categoria> categoria = new ArrayList<>();

        // Crear consulta
        String consulta = "{ call sp_listarcategorias() }";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement consultaCall = conexion.prepareCall(consulta);
                ResultSet tablaResultado = consultaCall.executeQuery();) {

            while (tablaResultado.next()) {

                categoria.add(new Categoria(
                        tablaResultado.getInt("id_categoria"),
                        tablaResultado.getString("nombre_categoria")
                ));
            }

        } catch (SQLException e) {

            System.err.println("Error al listar Categoria: " + e.getMessage());

        }

        return categoria;
    }

    @Override
    public boolean crear(Categoria categoria) {
        return false;
    }

    @Override
    public Categoria buscar(int idCategoria) {
        return null;
    }

    @Override
    public boolean actualizar(Categoria categoria) {
        return false;
    }

    @Override
    public boolean eliminar(int idCategoria) {
        return false;
    }
}