package org.miguelio.view;
import java.util.List;
import java.util.Scanner;
import org.miguelio.model.Categoria;
public class CategoriaConsoleView {

    private final Scanner leer = new Scanner(System.in);
    public int mostrarMenu() {
        int opcion;
        System.out.println("--- GESTION DE CATEGORIAS ---");
        System.out.println("--- 1. CREAR nueva categoria ---");
        System.out.println("--- 2. LISTAR todas las categorias ---");
        System.out.println("--- 3. BUSCAR categoria por ID ---");
        System.out.println("--- 4. MODIFICAR categoria ---");
        System.out.println("--- 5. ELIMINAR categoria ---");
        System.out.println("--- 6. REGRESAR al menu principal ---");
        System.out.println("Seleccione una opcion --->");

        opcion = Integer.parseInt(leer.nextLine());

        return opcion;
    }
    public String solicitarIdCategoria() {

        System.out.println("Ingrese el ID de la categoria: ");

        return leer.nextLine();

    }
    public String solicitarNombreCategoria() {

        System.out.println("Ingrese el nombre de la categoria: ");

        return leer.nextLine();
    }

    public void mostrarCategoria(Categoria categoria) {

        System.out.println("--- Datos de la Categoria ---");

        System.out.println("ID: " + categoria.getIdCategoria());
        System.out.println("Nombre: " + categoria.getNombreCategoria());

    }
    public void mostrarListaCategorias(List<Categoria> categorias) {

        System.out.println("--- Lista de Categorias ---");

        System.out.printf("%-15s %-20s\n",
                "ID", "NOMBRE");
        for (Categoria categoria : categorias) {

            System.out.printf("%-15s %-20s\n",
                    categoria.getIdCategoria(),
                    categoria.getNombreCategoria());
        }
    }
    public void mostrarBuscarCategoria(Categoria categoria) {

        System.out.println("--- Categoria encontrada ---");
        System.out.println("ID: "
                + categoria.getIdCategoria());
        System.out.println("Nombre: "
                + categoria.getNombreCategoria());
    }
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}