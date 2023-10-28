public class Livro {
    private String titulo;
    private Autor autor;
    private boolean emprestado;

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return !emprestado;
    }

    public void emprestar() {
        if (!emprestado) {
            emprestado = true;
        } else {
            System.out.println("O livro já está emprestado.");
        }
    }

    public void devolver() {
        if (emprestado) {
            emprestado = false;
        } else {
            System.out.println("O livro não está emprestado.");
        }
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor.getNome() +
                ", emprestado=" + emprestado +
                '}';
    }
}
