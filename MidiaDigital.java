public class MidiaDigital extends Midia {
    private String album;

    public MidiaDigital(String titulo, String album) {
        super(titulo);
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "Mídia Digital{" +
                "titulo='" + getTitulo() + '\'' +
                ", disponivel=" + isDisponivel() +
                ", album='" + album + '\'' +
                '}';
    }
}
