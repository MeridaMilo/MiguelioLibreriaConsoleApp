
package org.miguelio.dao;
// Mi push 2026116
/**
 *
 * @author informatica
 */

import java.util.List;
import org.miguelio.model.Cliente;
        
public interface ClienteDAO {
    // FIRMAS DE METODOS
    
    boolean crear(Cliente  cliente);
    List<Cliente> listarTodos();
    Cliente buscarPorId(long cui);
    boolean actualizar(Cliente cliente);
    boolean eliminar(long cui);

    
    
}
