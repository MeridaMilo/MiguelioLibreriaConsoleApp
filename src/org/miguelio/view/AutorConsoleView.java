package org.miguelio.view;

import java.util.List;
import java.util.Scanner;
import org.miguelio.model.Autor;

public class AutorConsoleView {

    private final Scanner leer = new Scanner(System.in);

   
    public int mostrarMenu() {
        int opcion = 0;
        // todo el menu
        System.out.println("--- GESTION DE AUTOR ---");
        System.out.println("-1 CREAR nuevo autor ---");
        System.out.println("-2 LISTAR todos los autor ---");
        System.out.println("-3 BUSCAR autor por ID ---");
        System.out.println("-4 MODIFICAR autor ---");
        System.out.println("-5 ELIMINAR nuevo autor ---");
        System.out.println("-6 REGRESAR a menú PRIMCIPAL ---");
        System.out.print("SELECCIONE UNA OPCION -->");
        opcion = Integer.parseInt(leer.nextLine());
        return opcion;
    }

    public long solicitarId() {
        System.out.println("Ingrese el CUI del autor: ");
        return Long.parseLong(leer.nextLine());
    }

   
    public String solicitarNombreAutor() {
        String nombre;
        System.out.println("Ingrese el NOMBRE del autor");
        nombre = leer.nextLine();
        return nombre;
    }

  
    public String solicitarApellidoAutor() {
        System.out.println("Ingrese el APELLIDO del autor");
        return leer.nextLine();
    }

    
    public String solicitarNacionalidad() {
        System.out.println("Ingrese el Nacionalidaddel autor");
        return leer.nextLine();
    }
    
     public String solicitarBiogarfia() {
        System.out.println("Ingrese Biografia  del autor");
        return leer.nextLine();
    }
     
   
    public void mostrarAutor(Autor autor){
        System.out.println("--- DATOS DEL Autor ---");
        System.out.println("ID: " + autor.getId());
        System.out.println("NOMBRE: " + autor.getNombre());
        System.out.println("APELLIDO: " + autor.getApellido());
        System.out.println("NACIONALIDAD: "+ autor.getNacionalidad());
          System.out.println("BIOGRAFIA: "+ autor.getBiografia());
        System.out.println("---\n");
    }
    
 
    public void mostrarListAutores(List<Autor> Autores){
        System.out.println("--- LISTA DE AUTORES ---");
   
        System.out.printf("%-15s %-10s %-10s %-10s\n", "ID","NOMBRE","APELLIDO","NACIONALIDAD","BIOGRAFIA");
        
        for (Autor autor : Autores) {
            System.out.printf("%-10s %-10s %-10s %-10s\n",
                    autor.getId(), autor.getNombre(), autor.getApellido (), autor.getNacionalidad(), autor.getBiografia());
        }
        System.out.println(" --- fin de autor ---\n");
    }
    

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public void mostrarListaAutor(List<Autor> listarTodos) {
    }
    
}
