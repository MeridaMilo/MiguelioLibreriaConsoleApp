package org.miguelio.dao.impl;

import org.miguelio.dao.CategoriaDAO;
import org.miguelio.model.Categoria;
import org.miguelio.utils.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public boolean crear(Categoria categoria) {
        return false;
    }

    @Override
    public List<Categoria> listarTodos() {

        List<Categoria> categorias = new ArrayList<>();

        String consulta = "{call sp_listarcategorias()}";

        try (
                Connection conexion = Conexion.getInstancia().conectar();
                CallableStatement consultaCall = conexion.prepareCall(consulta);
                ResultSet tablaResultado = consultaCall.executeQuery()
                ) {

            while (tablaResultado.next()) {

                categorias.add(new Categoria(
                        tablaResultado.getInt("id_categoria"),
                        tablaResultado.getString("nombre_categoria")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar categorias: " + e.getMessage());
        }

        return categorias;
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