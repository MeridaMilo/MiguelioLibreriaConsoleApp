
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
    
    boolean insertar(Cliente  cliente);
    List<Cliente> ListarTodo();
    Cliente bucar(long cui);
    boolean actualizar(Cliente cliente);
    boolean eliminar(long cui);
    
    
}
