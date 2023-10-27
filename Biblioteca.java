import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;
    private List<Midia> midias;
    private List<Pessoa> pessoas;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.midias = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarMidia(Midia midia) {
        midias.add(midia);
    }

    public void listarLivrosDisponiveis() {
        System.out.println("Livros disponíveis na biblioteca '" + nome + "':");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro.getTitulo() + " - Autor: " + livro.getAutor().getNome());
            }
        }
    }

    public void listarMidiasDisponiveis() {
        System.out.println("Mídias disponíveis na biblioteca '" + nome + "':");
        for (Midia midia : midias) {
            if (midia.isDisponivel()) {
                System.out.println(midia.getTitulo());
            }
        }
    }

    public boolean emprestarLivro(Livro livro) {
        if (livros.contains(livro) && livro.isDisponivel()) {
            livro.emprestar();
            return true;
        }
        return false;
    }

    public boolean devolverLivro(Livro livro) {
        if (livros.contains(livro) && !livro.isDisponivel()) {
            livro.devolver();
            return true;
        }
        return false;
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }
}
