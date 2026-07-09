
package org.miguelio.view;

import java.util.List;
import java.util.Scanner;
import org.miguelio.model.Editorial;

public class EditorialConsoleView {
    private final Scanner leer = new Scanner(System.in);
    
    public int mostrarMenu(){
        int opcion = 0;
        
        System.out.println("--- GESTION DE EDITORIALES ---");
        System.out.println("----1.  CREAR nuevo editorial ---");
        System.out.println("--- 2. LISTAR todos los editoriales ---");
        System.out.println("--- 3. BUSCAR editorial por NIT ---");
        System.out.println("--- 4. MODIFICAR editorial ---");
        System.out.println("--- 5. ELIMINAR nuevo Editorial ---");
        System.out.println("--- 6. REGRESAR a menú principal ---");
        System.out.println("Seleccione una opcion --->");    
        opcion = Integer.parseInt(leer.nextLine());
        return opcion;
    }
    
    public String solicitarNit(){
        String Nit;
        System.out.println("Ingrese el NIT de editorial: ");
        Nit = leer.nextLine();
        return Nit;
//        return String.parseString(leer.nextline());
    }
    
    public String solicitarNombreEditorial(){
        System.out.println("Ingrese el Nombre Editorial ");
        return leer.nextLine();
    }
    public String solicitarTelefonoEditorial(){
        System.out.println("Ingrese el Telefono ");
        return leer.nextLine();
    }
    
     public String solicitarDireccionEditorial(){
        System.out.println("Ingrese la Direccion ");
        return leer.nextLine();
    }
     public void mostrarEditorial(Editorial editorial){
         System.out.println("---Datos de la Editorial---");
         System.out.println("Nit: " + editorial.getNit());
         System.out.println("Nombre: " + editorial.getNombre());
         System.out.println("Telefono: " + editorial.getTelefono());
         System.out.println("Direccion: " + editorial.getDireccion());
     }
     
     public void mostrarListaEditorial(List<Editorial> editorial){
         System.out.println("--- Lista de editoriales ---");   
         System.out.printf("%-10s %-10s %-10s", "NIT","NOMBRE","TELEFONO","DIRECCION");
         
         for (Editorial editorial : editorial ) {
             System.out.printf("%-10s %-10s %-10s",
                     editorial.getNit(),editorial.getNombre(),editorial.getTelefono(),editorial.getDireccion());
         }
     } 
     
     public void mostrarMensaje(String mensaje){
         System.out.println(mensaje);
     }
}
