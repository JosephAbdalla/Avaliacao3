public class Midia {
    private String titulo;
    private boolean disponivel;

    public Midia(String titulo) {
        this.titulo = titulo;
        this.disponivel = true; // Inicialmente, a mídia está disponível
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
        } else {
            System.out.println("A mídia já está emprestada.");
        }
    }

    public void devolver() {
        if (!disponivel) {
            disponivel = true;
        } else {
            System.out.println("A mídia não está emprestada.");
        }
    }

    @Override
    public String toString() {
        return "Mídia{" +
                "titulo='" + titulo + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}
