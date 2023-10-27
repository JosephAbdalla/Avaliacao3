
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Autor> autores = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        Biblioteca biblioteca = null;

        while (true) {
            System.out.println("\nMenu de Operações:");
            System.out.println("1. Criar Biblioteca");
            System.out.println("2. Criar Autor");
            System.out.println("3. Criar Livro");
            System.out.println("4. Adicionar Livro à Biblioteca");
            System.out.println("5. Emprestar Livro");
            System.out.println("6. Devolver Livro");
            System.out.println("7. Listar Livros Disponíveis");
            System.out.println("8. Criar Pessoa");
            System.out.println("9. Criar Mídia");
            System.out.println("10. Listar Mídias Disponíveis");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Digite o nome da Biblioteca: ");
                    String nomeBiblioteca = scanner.nextLine();
                    biblioteca = new Biblioteca(nomeBiblioteca);
                    System.out.println("Biblioteca '" + nomeBiblioteca + "' criada.");
                    break;
                case 2:
                    System.out.print("Digite o nome do autor: ");
                    String nomeAutor = scanner.nextLine();
                    Autor novoAutor = new Autor(nomeAutor);
                    autores.add(novoAutor);
                    System.out.println("Autor criado: " + novoAutor);
                    break;
                case 3:
                    if (autores.isEmpty()) {
                        System.out.println("Crie um autor primeiro.");
                    } else {
                        System.out.print("Digite o título do livro: ");
                        String tituloLivro = scanner.nextLine();
                        System.out.println("Escolha um autor pelo número:");
                        for (int i = 0; i < autores.size(); i++) {
                            System.out.println(i + ". " + autores.get(i).getNome());
                        }
                        int autorEscolhido = scanner.nextInt();
                        scanner.nextLine(); 
                        if (autorEscolhido >= 0 && autorEscolhido < autores.size()) {
                            Autor autor = autores.get(autorEscolhido);
                            Livro livro = new Livro(tituloLivro, autor);
                            livros.add(livro);
                            System.out.println("Livro criado: " + livro);
                        } else {
                            System.out.println("Número de autor inválido.");
                        }
                    }
                    break;
                case 4:
                    if (livros.isEmpty()) {
                        System.out.println("Crie um livro primeiro.");
                    } else {
                        if (biblioteca == null) {
                            System.out.println("Crie uma biblioteca primeiro.");
                        } else {
                            System.out.println("Escolha um livro pelo número:");
                            for (int i = 0; i < livros.size(); i++) {
                                System.out.println(i + ". " + livros.get(i).getTitulo());
                            }
                            int livroEscolhido = scanner.nextInt();
                            scanner.nextLine(); 
                            if (livroEscolhido >= 0 && livroEscolhido < livros.size()) {
                                Livro livroParaAdicionar = livros.get(livroEscolhido);
                                biblioteca.adicionarLivro(livroParaAdicionar);
                                System.out.println("Livro adicionado à biblioteca.");
                            } else {
                                System.out.println("Número de livro inválido.");
                            }
                        }
                    }
                    break;
                case 5:
                    if (livros.isEmpty() || biblioteca == null) {
                        System.out.println("Crie uma biblioteca e um livro primeiro.");
                    } else {
                        System.out.println("Escolha um livro pelo número:");
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println(i + ". " + livros.get(i).getTitulo());
                        }
                        int livroEscolhido = scanner.nextInt();
                        scanner.nextLine();
                        if (livroEscolhido >= 0 && livroEscolhido < livros.size()) {
                            Livro livroParaEmprestar = livros.get(livroEscolhido);
                            if (biblioteca.emprestarLivro(livroParaEmprestar)) {
                                System.out.println("Livro emprestado com sucesso.");
                            } else {
                                System.out.println("Não foi possível emprestar o livro. Já emprestado ou não encontrado.");
                            }
                        } else {
                            System.out.println("Número de livro inválido.");
                        }
                    }
                    break;
                case 6:
                    if (livros.isEmpty() || biblioteca == null) {
                        System.out.println("Crie uma biblioteca e um livro primeiro.");
                    } else {
                        System.out.println("Escolha um livro pelo número:");
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println(i + ". " + livros.get(i).getTitulo());
                        }
                        int livroEscolhido = scanner.nextInt();
                        scanner.nextLine(); 
                        if (livroEscolhido >= 0 && livroEscolhido < livros.size()) {
                            Livro livroParaDevolver = livros.get(livroEscolhido);
                            if (biblioteca.devolverLivro(livroParaDevolver)) {
                                System.out.println("Livro devolvido com sucesso.");
                            } else {
                                System.out.println("Não foi possível devolver o livro. Não emprestado ou não encontrado.");
                            }
                        } else {
                            System.out.println("Número de livro inválido.");
                        }
                    }
                    break;
                case 7:
                    if (biblioteca == null) {
                        System.out.println("Crie uma biblioteca primeiro.");
                    } else {
                        biblioteca.listarLivrosDisponiveis();
                    }
                    break;
                case 8:
                    System.out.print("Digite o nome da pessoa: ");
                    String nomePessoa = scanner.nextLine();
                    Pessoa novaPessoa = new Pessoa(nomePessoa);
                    biblioteca.adicionarPessoa(novaPessoa);
                    System.out.println("Pessoa criada: " + novaPessoa);
                    break;
                case 9:
                    System.out.print("Digite o título da mídia: ");
                    String tituloMidia = scanner.nextLine();
                    System.out.print("A mídia é um CD ou DVD (digite 'cd' ou 'dvd'): ");
                    String tipoMidia = scanner.nextLine();
                    Midia novaMidia;
                    if (tipoMidia.equals("cd")) {
                        System.out.print("Digite o nome do álbum: ");
                        String album = scanner.nextLine();
                        novaMidia = new MidiaDigital(tituloMidia, album);
                    } else {
                        novaMidia = new Midia(tituloMidia);
                    }
                    biblioteca.adicionarMidia(novaMidia);
                    System.out.println("Mídia criada: " + novaMidia);
                    break;
                case 10:
                    if (biblioteca == null) {
                        System.out.println("Crie uma biblioteca primeiro.");
                    } else {
                        biblioteca.listarMidiasDisponiveis();
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
