
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.event.ListDataEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
            System.out.println("4- Vender um ingresso");
            System.out.println("5- remover filmes");
            System.out.println("6- remover salas");
            System.out.println("7- remover sessoes");
            System.out.println("8- remover vendas");
            System.out.println("9- lista de filmes");
            System.out.println("10- lista de Salas");
            System.out.println("11- lista de Sessoes");
            System.out.println("12- Total de Vendas");
            System.out.println("0- sair");
            System.out.println("Escolha uma opção: ");
            opcao = ent.nextInt();
            ent.nextLine();
            try {

                switch (opcao) {

                    case 1: // adicionar filme
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
                    case 2: // adicionar sala
                        System.out.println("Digite o numero da sala:");
                        int num = ent.nextInt();
                        System.out.println("Digite a quantidade de assentos:");
                        int quant = ent.nextInt();
                        sistema.AdicionarSala(new Salas(num, quant));
                        break;
                    case 3: // adicionar sessao
                        System.out.println("Digite o código da sessão");
                        int sessaoCod = ent.nextInt();
                        System.out.println("Digite o horário da sessão");
                        String horario = ent.next();
                        System.out.println("Digite o código do filme");
                        int codFilme = ent.nextInt();
                        // Buscar filme na lista de filmes
                        Filmes filmSessao = sistema.filmes.stream().filter(f -> f.getCodigo() == codFilme).findFirst().orElse(null);
                        // procura a sala na lista                                                // Esses metodos achei procurando no google
                        // se encontrar retorna a sala achada
                        // se nao achar retorna null
                        if (filmSessao == null) { //se não achou o filme
                            System.out.println("Filme não encontrado");
                            return;
                        }
                        System.out.println("Digite o número da sala");
                        int salaSessao = ent.nextInt();
                        System.out.println("Digite o preço do ingresso dessa sessão");
                        Double precoIngressoSessao = ent.nextDouble();
                        Salas salaDaSessao = sistema.salas.stream().filter(s -> s.getNumeroSala() == salaSessao).findFirst().orElse(null); // Buscar sala na lista
                        if (salaDaSessao == null) { // se não achar nada                                        
                            System.out.println("Sala não encontrada");
                            return;
                        }
                        int AssentosSessao = salaDaSessao.getQuantidadeAssentos();
                        sistema.AdicionarSessao(new Sessao(sessaoCod, horario, filmSessao, salaDaSessao, AssentosSessao, precoIngressoSessao));
                        System.out.println("Sessão adicionada");

                    case 4: // vender um ingresso
                        System.out.println("Digite o código da sessão que quer assistir:");
                        int SessaoVenda = ent.nextInt();
                        Sessao SessaovendaIng = null;
                        for (Sessao s : sistema.sessoes) {
                            if (s.getCodigoSala() == SessaoVenda) {
                                SessaovendaIng = s;
                                break;
                            }
                        }
                        if (SessaovendaIng == null) {
                            System.out.println("Sessao nao encontrada");
                            break;
                        }
                        int assentosDisponiveis = SessaovendaIng.getQuantidadAssentos();
                        if (assentosDisponiveis > 0) {
                            System.out.println("Ingressos disponíveis: " + assentosDisponiveis);
                            System.out.println("continuar a compra? 1- sim 2- não");
                            int resposta = ent.nextInt();
                            if (resposta == 1) {
                                SessaovendaIng.venderIngresso(1); // tirar um espaço da sessão
                                sistema.AdicionarVenda(new VendaDeIngressos(1, SessaovendaIng, SessaovendaIng.getPrecoIngresso()));
                                System.out.println("compra realizada");
                            } else {
                                System.out.println("compra camncelada");
                            }
                        } else {
                            System.out.println("essa seção não tem mais ingressos disponiveis");
                        }
                        break;

                    case 5:  // remover filmes
                        System.out.println("Digite o código do filme:");
                        int codRemoveFilme = ent.nextInt();
                        Filmes RemoverFilme = null;
                        for (Filmes f : sistema.filmes) { //percorre a arraylist para achar o filme
                            if (f.getCodigo() == codRemoveFilme) {
                                RemoverFilme = f;
                                break;
                            }
                        }
                        if (RemoverFilme != null) {
                            sistema.filmes.remove(RemoverFilme);
                            System.out.println("Filme removido.");
                        } else {
                            System.out.println("Filme nao encontrado.");
                        }
                        break;

                    case 6: // remover salas
                        System.out.println("Digite o número da sala:");
                        int codRemoveSala = ent.nextInt();
                        Salas salaParaRemover = null;
                        for (Salas s : sistema.salas) {
                            if (s.getNumeroSala() == codRemoveSala) {
                                salaParaRemover = s;
                                break;
                            }
                        }
                        if (salaParaRemover != null) {
                            sistema.salas.remove(salaParaRemover);
                            System.out.println("Sala removida com sucesso.");
                        } else {
                            System.out.println("Sala com número " + codRemoveSala + " não encontrada.");
                        }
                        break;
                    case 7: // remover sessões
                        System.out.println("Digite o código da sessão:");
                        int codRemoveSessao = ent.nextInt();
                        Sessao sessaoParaRemover = null;
                        for (Sessao s : sistema.sessoes) {
                            if (s.getCodigoSala() == codRemoveSessao) {
                                sessaoParaRemover = s;
                                break;
                            }
                        }

                        // Remover a sessão se encontrada
                        if (sessaoParaRemover != null) {
                            sistema.sessoes.remove(sessaoParaRemover);
                            System.out.println("Sessão removida com sucesso.");
                        } else {
                            System.out.println("Sessão com código " + codRemoveSessao + " não encontrada.");
                        }
                        break;

                    case 8:// remover vendas
                        System.out.println("");
                        break;
                    case 9: // lista de filmes
                        System.out.println("Lista de filmes cadastrados no sistema");
                        System.out.println(sistema.listadeFilmes());
                        break;
                    case 10: // lista de salas
                        System.out.println("Lista de salas cadastradas no sistema");
                        System.out.println(sistema.listadeSalas());
                        break;
                    case 11: // lista de sessoes
                        System.out.println("Lista de sessoes cadastradas no sistema");
                        System.out.println(sistema.listaDeSessoes());
                        break;
                    case 12: // Calcular a soma total dos ingressos vendidos
                        int totalDeIngressosVendidos = 0;
                        for (VendaDeIngressos venda : sistema.vendas) {
                            totalDeIngressosVendidos += venda.getQuantidadeDeIngressos(); // Somar os ingressos de cada venda
                        }

                        System.out.println("Total de ingressos vendidos: " + totalDeIngressosVendidos);
                        break;

                    case 13: // Gerar Relatório
                        System.out.println("Gerando relatório");
                        String arquivoRelatorio = "relatorio_cinema.txt";
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoRelatorio))) {
                            writer.write("Relatório do cinema \n");
                            writer.write("/n");
                            writer.write("\nFilmes Disponíveis:\n");
                            for (Filmes filme : sistema.filmes) {
                                writer.write("Código: " + filme.getCodigo() + ", Nome: " + filme.getNome() + ", Gênero: " + filme.getGenero() + "\n");
                            }
                            writer.write("\nSalas Disponíveis:\n");
                            for (Salas sala : sistema.salas) {
                                writer.write("Número da Sala: " + sala.getNumeroSala() + ", Quantidade de Assentos: " + sala.getQuantidadeAssentos() + "\n");
                            }

                            // Relatório de sessões
                            writer.write("\nSessões Existentes:\n");
                            for (Sessao sessao : sistema.sessoes) {
                                writer.write("Código Sessão: " + sessao.getCodigoSala() + ", Sala: " + sessao.getSalasSessao().getNumeroSala() + ", Filme: " + sessao.getFilmesSessao().getNome() + ", Horário: " + sessao.getHorario() + "\n");
                            }

                            // Relatório de vendas por filme
                            writer.write("\nVendas por Filme:\n");
                            for (Filmes filme : sistema.filmes) {
                                int totalVendasFilme = 0;
                                for (VendaDeIngressos venda : sistema.vendas) {
                                    if (venda.getSessao().getFilmesSessao().equals(filme)) {
                                        totalVendasFilme += venda.getQuantidadeDeIngressos();
                                    }
                                }
                                writer.write("Filme: " + filme.getNome() + ", Total de Ingressos Vendidos: " + totalVendasFilme + "\n");
                            }

                            // Relatório de vendas por horário
                            writer.write("\nVendas por Horário:\n");
                            for (Sessao sessao : sistema.sessoes) {
                                int totalVendasSessao = 0;
                                for (VendaDeIngressos venda : sistema.vendas) {
                                    if (venda.getSessao().equals(sessao)) {
                                        totalVendasSessao += venda.getQuantidadeDeIngressos();
                                    }
                                }
                                writer.write("Sessão: " + sessao.getCodigoSala() + ", Horário: " + sessao.getHorario() + ", Total de Ingressos Vendidos: " + totalVendasSessao + "\n");
                            }

                            // Filmes mais exibidos (que mais apareceram em sessões)
                            writer.write("\nFilmes Mais Exibidos:\n");
                            for (Filmes filme : sistema.filmes) {
                                int countFilme = 0;
                                for (Sessao sessao : sistema.sessoes) {
                                    if (sessao.getFilmesSessao().equals(filme)) {
                                        countFilme++;
                                    }
                                }
                                writer.write("Filme: " + filme.getNome() + ", Sessões: " + countFilme + "\n");
                            }

                            // Salas mais utilizadas (que mais apareceram em sessões)
                            writer.write("\nSalas Mais Utilizadas:\n");
                            for (Salas sala : sistema.salas) {
                                int countSala = 0;
                                for (Sessao sessao : sistema.sessoes) {
                                    if (sessao.getSalasSessao().equals(sala)) {
                                        countSala++;
                                    }
                                }
                                writer.write("Sala: " + sala.getNumeroSala() + ", Sessões: " + countSala + "\n");
                            }

                            // Finalização do relatório
                            writer.write("\n====================================\n");
                            writer.write("Relatório gerado com sucesso!\n");

                        } catch (IOException e) {
                            System.out.println("Erro ao gerar o relatório: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("encerrando programa");
                        break;

                    default:
                        System.out.println("opção invalida");

                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                ent.nextLine(); // Limpar o buffer
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Erro: Índice fora do intervalo válido.");
            } catch (NullPointerException e) {
                System.out.println("Erro: Objeto não encontrado.");
            }

        } while (opcao != 0);
        ent.close();

    }
}
