package Evento1;
import java.util.*;
class Biblioteca {
    private ArrayList<Libro> libros;                  // Almacenamiento principal
    private HashMap<String, ArrayList<Libro>> categorias; // Libros por categoría
    private LinkedList<Libro> historial;              // Últimos consultados

    public Biblioteca() {
        libros = new ArrayList<>();
        categorias = new HashMap<>();
        historial = new LinkedList<>();
    }

    // CRUD
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        categorias.putIfAbsent(libro.getCategoria(), new ArrayList<>());
        categorias.get(libro.getCategoria()).add(libro);
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    public void buscarLibro(String clave) {
        boolean encontrado = false;
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(clave) ||
                l.getAutor().equalsIgnoreCase(clave) ||
                l.getIsbn().equalsIgnoreCase(clave)) {
                System.out.println(l);
                historial.addFirst(l); // Se guarda en historial
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron resultados.");
        }
    }

    public void eliminarLibro(String isbn) {
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro l = it.next();
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                it.remove();
                categorias.get(l.getCategoria()).remove(l);
                System.out.println("Libro eliminado.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    // Funciones extra
    public void prestarLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                if (l.isDisponible()) {
                    l.prestar();
                    System.out.println("Libro prestado con éxito.");
                } else {
                    System.out.println("El libro ya estaba prestado.");
                }
                return;
            }
        }
        System.out.println("No se encontró el libro.");
    }

    public void devolverLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                if (!l.isDisponible()) {
                    l.devolver();
                    System.out.println("Libro devuelto con éxito.");
                } else {
                    System.out.println("El libro ya estaba disponible.");
                }
                return;
            }
        }
        System.out.println("No se encontró el libro.");
    }

    public void listarPorCategoria(String categoria) {
        ArrayList<Libro> lista = categorias.get(categoria);
        if (lista != null && !lista.isEmpty()) {
            for (Libro l : lista) {
                System.out.println(l);
            }
        } else {
            System.out.println("No hay libros en esta categoría.");
        }
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay historial de consultas.");
        } else {
            System.out.println("Últimos libros consultados:");
            for (Libro l : historial) {
                System.out.println(l);
            }
        }
    }
}
