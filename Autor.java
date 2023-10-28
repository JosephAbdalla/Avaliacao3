public class Autor {
    private String nome;
    private String nacionalidade;

    public Autor(String nome) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public String toString() {
        return "Autor: " + nome;
    }
}
