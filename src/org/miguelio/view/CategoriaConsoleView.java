
package org.miguelio.view;

import java.util.List;
import java.util.Scanner;
import org.miguelio.model.Categoria;

public class CategoriaConsoleView {

    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {

        int opcion;

        System.out.println("--- GESTION DE CATEGORIA ---");
        System.out.println("1. Crear nueva categoría");
        System.out.println("2. Listar categorías");
        System.out.println("3. Buscar categoría por ID");
        System.out.println("4. Modificar categoría");
        System.out.println("5. Eliminar categoría");
        System.out.print("Seleccione una opción: ");

        opcion = leer.nextInt();

        return opcion;
    }
    
    public int solicitarIdCategoria(){
        System.out.println("Ingrese el id de categoria: ");
        return Integer.parseInt(leer.nextLine());
    }
    public String solicitarNombreCategoria(){
        System.out.println("Ingrese el nombre de categoria: ");       
        return leer.nextLine(); 
}
    //mostrar el detalle de una categoria 
    public void mostrarCategoria(Categoria categoria){
        System.out.println("--- DATOS DE CATEGORIA---");
        System.out.println("id_categoria" + categoria.getIdCategoria());
        System.out.println("nombre_categoria" + categoria.getNombreCategoria());
        System.out.println("");
    }
    // mostrar la vista de Categoria -- lista de objeto  List<T>, ArrayList<Categoria>
    public void mostrarListaCategoria(List<Categoria> categorias){
        System.out.println("--- LISTA DE CATEGORIA---");
        //tabla usando la propiedad %-[tamaño de columnas)s 
        System.out.printf("%-10s %-10s", " | ID | " , " | NOMBRE  | \n " );       
        for (Categoria categoria : categorias){
        System.out.printf("%-10s %-10s\n " ,
                categoria.getIdCategoria() , categoria.getNombreCategoria());
    }

        }
 
public void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
} 
    }
    

