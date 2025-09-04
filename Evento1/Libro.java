package Evento1;

class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private String categoria;
    private boolean disponible;

    public Libro(String titulo, String autor, String isbn, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.disponible = true;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public String getCategoria() { return categoria; }
    public boolean isDisponible() { return disponible; }

    public void prestar() { disponible = false; }
    public void devolver() { disponible = true; }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (ISBN: " + isbn + ") [" + categoria + "] " +
               (disponible ? "Disponible" : "Prestado");
    }
}