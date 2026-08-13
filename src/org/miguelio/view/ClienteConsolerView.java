package org.miguelio.view;

import java.util.List;
import java.util.Scanner;
import org.miguelio.model.Cliente;

public class ClienteConsolerView {
    private final Scanner leer = new Scanner(System.in);
    
    public int mostrarMenu(){
        int opcion = 0;
        
        System.out.println("--- GESTION DE GLIENTES ---");
        System.out.println("----1. CREAR nuevo Cliente  ---");
        System.out.println("--- 2. LISTAR todos los Clientes  ---");
        System.out.println("--- 3. BUSCAR Cliente por ID---");
        System.out.println("--- 4. MODIFICAR Cliente ---");
        System.out.println("--- 5. ELIMINAR nuevo Cliente  ---");
        System.out.println("--- 6. REGRESAR a menú PRIMCIPAL  ---");
        System.out.println("Seleccione una opcion --->");    
        opcion = Integer.parseInt(leer.nextLine().trim());
        return opcion;
    }
    
      public long solicitarCUI() {
        System.out.println("Ingrese el CUI del cliente: ");
        return Long.parseLong(leer.nextLine().trim());
    }

    //nombreCliente
    public String solicitarNombreCliente() {
        String nombre;
        System.out.println("Ingres el NOMBRE del cliente");
        nombre = leer.nextLine();
        return nombre;
        //return leer.nextLine();
    }

    //apellidoCliente
    public String solicitarApellidoCliente() {
        System.out.println("Ingres el APELLIDO del cliente");
        return leer.nextLine();
    }

    //correoEctronico
    public String solicitarCorreoElectronico() {
        System.out.println("Ingres el CORREO electrónico del cliente");
        return leer.nextLine();
    }
    
    //mostrar el detalle de un CLIENTE
    public void mostrarCliente(Cliente cliente){
        System.out.println("--- DATOS DEL CLIENTE ---");
        System.out.println("CUI: " + cliente.getCui());
        System.out.println("NOMBRE: " + cliente.getNombre());
        System.out.println("APELLIDO: " + cliente.getApellido());
        System.out.println("CORREO E: "+ cliente.getCorreoElectronico());
        System.out.println("---\n");
    }
    
    //mostrar la lista de CLIENTES -- lista de objeto List<T>, ArrayList<Cliente>
    public void mostrarListaClientes(List<Cliente> clientes){
        System.out.println("--- LISTA DE CLIENTES ---");
        //tabla usando la propiedad %-[tamaño de columa]s
        System.out.printf("%-15s %-10s %-10s %-10s\n", "CUI","NOMBRE","APELLIDO","CORREO");
        
        for (Cliente cliente : clientes) {
            System.out.printf("%-10s %-10s %-10s %-10s\n",
                    cliente.getCui(), cliente.getNombre(), cliente.getApellido(), cliente.getCorreoElectronico());
        }
        System.out.println(" --- fin de clientes ---\n");
    }
     
     public void mostrarMensaje(String mensaje){
         System.out.println(mensaje);
     }

}




