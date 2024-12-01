
import java.util.ArrayList;

public class GestaoCinema {

    // Essa clase vai servir como se fosse para um funcionario do cinema adicionar as informações necessarias do cinema
    public ArrayList<Filmes> filmes;
    public ArrayList<Salas> salas;
    public ArrayList<Sessao> sessoes;
    public ArrayList<VendaDeIngressos> vendas;

    public GestaoCinema() {
        filmes = new ArrayList<Filmes>();
        salas = new ArrayList<Salas>();
        sessoes = new ArrayList<Sessao>();
        vendas = new ArrayList<VendaDeIngressos>();
    }

    public void AdicionarFilme(Filmes filme) {  //adicionando filmes na lista
        filmes.add(filme);
    }

    public void AdicionarSala(Salas sala) { //adicionando sala na lista
        salas.add(sala);
    }

    public void AdicionarSessao(Sessao sessao) { // adicionando sessoes na lista
        sessoes.add(sessao);
    }

    public void AdicionarVenda(VendaDeIngressos venda) { // adicionando vendas na lista
        vendas.add(venda);
    }

    public void removeFilme(Filmes filme) {
        if (filmes.contains(filme)) {
            filmes.remove(filme);
        } else {
            System.out.println("filme não encontrado");
        }
    }

    public void removesala(Salas sala) {
        if (salas.contains(sala)) {
            salas.remove(sala);
        } else {
            System.out.println("sala não encontrada");
        }
    }

    public void removeSessoes(Sessao sessao) {
        if (sessoes.contains(sessao)) {
            sessoes.remove(sessao);
        } else {
            System.out.println("sessão não encontrada");
        }
        sessoes.remove(sessao);
    }

    public void removerVenda(VendaDeIngressos venda) {

        vendas.remove(venda);
    }


    public String listadeFilmes() {
        for (int i = 0; i<filmes.size(); i++){
        System.out.println(filmes.get(i));
        }
        return "";
    }

    public String listadeSalas() {
        for (int i = 0; i<salas.size(); i++){
        System.out.println(salas.get(i));
        }
        return "";
    }

    
    public String listaDeSessoes() {
        for (int i = 0; i<sessoes.size(); i++){
        System.out.println(sessoes.get(i));
        }
        return "";
    }

    public void AdicionarVenda(int quantDeIngressos, Sessao codiSessao, int precoIngresso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AdicionarVenda'");
    }

}
/*
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
 */
