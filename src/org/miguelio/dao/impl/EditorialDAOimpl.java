package org.miguelio.dao.impl;

import org.miguelio.dao.EditorialDAO;
import org.miguelio.model.Editorial;

import java.util.List;

public class EditorialDAOimpl implements EditorialDAO{

    @Override
    public boolean insertar(Editorial editorial) {
        return false;
    }

    @Override
    public List<Editorial> listar() {
        return null;
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
