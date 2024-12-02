
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

    public void AdicionarVenda(VendaDeIngressos venda) { // adiciona venda de ingresso
        vendas.add(venda);
    }

    public void removeFilme(Filmes filme) { // remove filme da lista
        if (filmes.contains(filme)) {
            filmes.remove(filme);
        } else {
            System.out.println("filme não encontrado");
        }
    }

    public void removesala(Salas sala) { // remove alguma sala da lista
        if (salas.contains(sala)) {
            salas.remove(sala);
        } else {
            System.out.println("sala não encontrada");
        }
    }

    public void removeSessoes(Sessao sessao) {  //remove alguma sessão
        if (sessoes.contains(sessao)) {
            sessoes.remove(sessao);
        } else {
            System.out.println("sessão não encontrada");
        }
        sessoes.remove(sessao);
    }

    public String listadeFilmes() { //retorna a lista de filmes
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println(filmes.get(i));
        }
        return "";
    }

    public String listadeSalas() { //retorna a lista de salas
        for (int i = 0; i < salas.size(); i++) {
            System.out.println(salas.get(i));
        }
        return "";
    }

    public String listaDeSessoes() { //retorna lista de sessoes
        for (int i = 0; i < sessoes.size(); i++) {
            System.out.println(sessoes.get(i));
        }
        return "";
    }

    public void AdicionarVenda(int quantDeIngressos, Sessao codiSessao, int precoIngresso) { // metodo para registrar uma venda

    }

}
