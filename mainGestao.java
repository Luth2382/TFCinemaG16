
import java.util.Scanner;

public class mainGestao extends GestaoCinema {

    public static void main(String[] args) {
        GestaoCinema sistema = new GestaoCinema();
        Scanner ent = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Menu Gestão:");
            System.out.println("1- adicionar filmes");
            System.out.println("2- adicionar salas");
            System.out.println("3- adicionar sessoes");
            System.out.println("4- adicionar vendas de ingressos ");
            System.out.println("5- Vender um ingresso");
            System.out.println("6- remover filmes");
            System.out.println("7- remover salas");
            System.out.println("8- remover sessoes");
            System.out.println("9- remover vendas");
            System.out.println("10- lista de filmes");
            System.out.println("11- lista deSalas");
            System.out.println("12- lista de Sessoes");
            System.out.println("13- Total de Vendas");
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
                    sistema.AdicionarFilme(new Filmes(cod, nome, genero, sinopse));
                    break;
                case 2:
                    System.out.println("Digite o numero da sala:");
                    int num = ent.nextInt();
                    System.out.println("Digite a quantidade de assentos:");
                    int quant = ent.nextInt();
                    sistema.AdicionarSala(new Salas(num, quant));
                    break;
                case 3:
                    System.out.println("digite o codigo da sessão");
                    int sessaoCod = ent.nextInt();
                    System.out.println("Digite a sala da sessão");
                    int salaSessao = ent.nextInt();
                    System.out.println("Digite o horario da sessão");
                    String horario = ent.next();
                    System.out.println("Digite o codigo do filme");
                    int codFilme = ent.nextInt();
                    System.out.println("Digite a quantidade de assentos");
                    int quantAssentos = ent.nextInt();
                    Filmes filmSessao = sistema.filmes.get(codFilme);
                    sistema.AdicionarSessao(new Sessao(sessaoCod, salaSessao, horario, filmSessao, quantAssentos));
                    break;
                case 4: // adicionar vendas

                    System.out.println("Digite o codigo da sessão ");
                    int codSessaoVenda = ent.nextInt();
                    System.out.println("digite a quantidade de ingressos dessa sessão");
                    int quantDeIngressos = ent.nextInt();
                    System.out.println("Digite o preço de ingresso:");
                    Double precoIngresso = ent.nextDouble();
                    Sessao codiSessao = sistema.sessoes.get(codSessaoVenda);
                    sistema.AdicionarVenda(new VendaDeIngressos(quantDeIngressos, codiSessao, precoIngresso));
                    break;
                case 5: //vender um ingresso
                    /*int countVenda;
                System.out.println("Digite o codigo da Sessão");
                int codSessaoVender = ent.nextInt();
                Sessao sessaovenda = sistema.sessoes.get(codSessaoVender);
                if (sessaovenda == null){
                    System.out.println("Sessao não encontrada");
                }else{
                    System.out.println("digite a quantidade de ingressos a serem comprados");
                    int quantidadeIngressos = ent.nextInt();
                    sessaovenda.disponibilidadeIngresso(quantidadeIngressos);

                     */
                    break;

                case 6:  // remover filmes
                    System.out.println("Digite o codigo do filme");
                    int codRemoveFilme = ent.nextInt();
                    Filmes codremovefilm = sistema.filmes.get(codRemoveFilme);
                    sistema.removeFilme (codremovefilm);

                    break;
                case 7: // remover salas
                System.out.println("Digite o codigo da sala");
                int codRemoveSala = ent.nextInt();
                Salas codremoveSal = sistema.salas.get(codRemoveSala);
                sistema.removesala(codremoveSal);
                    break;
                case 8:// remover sessoes
                System.out.println("Digite o codigo da sessao");
                int codRemoveSessao = ent.nextInt();
                Sessao codremoveSessa = sistema.sessoes.get(codRemoveSessao);
                sistema.removeSessoes(codremoveSessa);
                    break;
                case 9:// remover vendas
                    System.out.println("");
                    break;
                case 10: // lista de filmes
                    System.out.println("Lista de filmes cadastrados no sistema");
                    System.out.println(sistema.listadeFilmes());
                    break;
                case 11: // lista de salas
                    System.out.println("Lista de salas cadastradas no sistema");
                    System.out.println(sistema.listadeSalas());
                    break;
                case 12: // lista de sessoes
                System.out.println("Lista de sessoes cadastradas no sistema");
                    System.out.println(sistema.listaDeSessoes());
                    break;

            }

        } while (opcao != 0);
            ent.close();
    }
}
