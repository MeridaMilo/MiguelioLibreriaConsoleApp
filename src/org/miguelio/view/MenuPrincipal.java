package org.miguelio.view;

import java.util.Scanner;
import org.miguelio.controller.CategoriaController;

public class MenuPrincipal {

    Scanner leer = new Scanner(System.in);

    public void iniciar() {
        int opcion = 0;

        do {
            System.out.println("Bienvenido, seleccione una opcion!");
            System.out.println("1. Modulo Cliente");
            System.out.println("2. Modulo Autores");
            System.out.println("3. Modulo Categorias");
            System.out.println("4. modulo Editoriales");
            System.out.println("0. Salir");

            opcion = Integer.parseInt(leer.nextLine());

            switch (opcion) {
                case 1:
                    break;

                case 2:
                    System.out.println("Autor");
                    break;

                case 3:
                    CategoriaConsoleView vistaCategoria = new CategoriaConsoleView();
        CategoriaController controladorCategoria = new CategoriaController(vistaCategoria);
                    controladorCategoria.iniciar();
                    break;

                case 4:
                    System.out.println("Editoriales");
                    break;

                case 5:
                    System.out.println("Editoriales");
                    break;

                default:
                    System.out.println("NO existe esta opción");
            }
        } while (opcion != 0);
    }
}

 