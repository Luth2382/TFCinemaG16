
import java.util.Scanner;

public class mainGestao {

    public static void main(String[] args) {
        GestaoCinema gestao = new GestaoCinema();
        Scanner ent = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Menu Gestão:");
            System.out.println("1- adicionar filmes");
            System.out.println("2- adicionar salas");
            System.out.println("3- adicionar sessoes");
            System.out.println("4- adicionar vendas ");
            System.out.println("5- remover filmes");
            System.out.println("6- remover salas");
            System.out.println("7- remover sessoes");
            System.out.println("8- remover vendas");
            System.out.println("9- lista de filmes");
            System.out.println("10- lista deSalas");
            System.out.println("11- lista de Sessoes");
            System.out.println("12- Total de Vendas");
            System.out.println("0- sair");
            System.out.println("Escolha uma opção: ");
            opcao = ent.nextInt();
                switch (opcao) {

                    case 1:
                        System.out.println("Digite o codigo do filme:");
                        int cod = ent.nextInt();
                        System.out.println("Digite o nome do filme:");
                        String nome = ent.next();
                        System.out.println("Digite o genero do filme:");
                        String genero = ent.next();
                        System.out.println("Digite a sinopse do filme:");
                        String sinopse = ent.next();
                        Filmes film = new Filmes(cod, nome, genero, sinopse);
                        gestao.AdicionarFilme(film);
                        break;
                    case 2:
                        System.out.println("Digite o numero da sala:");
                        int num = ent.nextInt();
                        System.out.println("Digite a quantidade de assentos:");
                        int quant = ent.nextInt();
                        Salas sala = new Salas(num, quant);
                        gestao.AdicionarSala(sala);
                        break;
                    case 3:
                        System.out.println("Digite a sala da sessão");
                        int salaSessao = ent.nextInt();
                        System.out.println("Digite o horario da sessão");
                        String horario = ent.next();
                        System.out.println("Digite o codigo do filme");
                        int codFilme = ent.nextInt();
                        System.out.println("Digite a quantidade de assentos");
                        int quantAssentos = ent.nextInt();
                        Filmes filmSessao = gestao.filmes.get(codFilme);
                        Sessao sessao = new Sessao(salaSessao, horario, filmSessao, quantAssentos);
                        gestao.AdicionarSessao(sessao);
                        break;
                    case 4:
                    System.out.println("");
                    break;
                    case 5:
                    System.out.println("");
                    break;
                    case 6:
                    System.out.println("");
                    break;
                    case 7:
                    System.out.println("");
                    break;
                    case 8:
                    System.out.println("");
                    break;
                    case 9:
                    System.out.println("");
                    break;
                    case 10:
                    System.out.println("");
                    break;
                    case 11:








                }

                
        } while ( opcao != 0);
    }
}
