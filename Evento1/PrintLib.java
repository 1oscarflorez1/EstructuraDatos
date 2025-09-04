package Evento1;
import java.util.*;
public class PrintLib {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(" _______________________________________");
            System.out.println("|      === 📚 Biblioteca Digital ===    |\\");
            System.out.println("|                                       | |");
            System.out.println("| 1. Agregar libro                      | |");
            System.out.println("| 2. Listar todos los libros            | |");
            System.out.println("| 3. Buscar libro (título/autor/ISBN)   | |");
            System.out.println("| 4. Eliminar libro                     | |");
            System.out.println("| 5. Prestar libro                      | |");
            System.out.println("| 6. Devolver libro                     | |");
            System.out.println("| 7. Listar libros por categoría        | |");
            System.out.println("| 8. Ver historial de consultas         | |");
            System.out.println("| 9. Salir                              | |");
            System.out.println("|_______________________________________| |");
            System.out.println("|                                       | |");
            System.out.println("|     -= Selecciona una opción: =-      | |");
            System.out.println("|_______________________________________|_|");
            
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();
                    biblioteca.agregarLibro(new Libro(titulo, autor, isbn, categoria));
                    System.out.println("Libro agregado con éxito.");
                    break;
                case 2:
                    biblioteca.listarLibros();
                    break;
                case 3:
                    System.out.print("Ingresa título, autor o ISBN: ");
                    String clave = sc.nextLine();
                    biblioteca.buscarLibro(clave);
                    break;
                case 4:
                    System.out.print("ISBN del libro a eliminar: ");
                    String eliminar = sc.nextLine();
                    biblioteca.eliminarLibro(eliminar);
                    break;
                case 5:
                    System.out.print("ISBN del libro a prestar: ");
                    String prestar = sc.nextLine();
                    biblioteca.prestarLibro(prestar);
                    break;
                case 6:
                    System.out.print("ISBN del libro a devolver: ");
                    String devolver = sc.nextLine();
                    biblioteca.devolverLibro(devolver);
                    break;
                case 7:
                    System.out.print("Categoría: ");
                    String cat = sc.nextLine();
                    biblioteca.listarPorCategoria(cat);
                    break;
                case 8:
                    biblioteca.mostrarHistorial();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema... 👋");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 9);

        sc.close();
    }
}


