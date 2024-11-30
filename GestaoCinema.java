import java.util.ArrayList;
public class GestaoCinema {
    // Essa clase vai servir como se fosse para um funcionario do cinema adicionar as informações necessarias do cinema
    public ArrayList<Filmes> filmes;
    public ArrayList<Salas> salas;
    public ArrayList<Sessao> sessoes;
    public ArrayList<VendaDeIngressos> vendas;

    public GestaoCinema(){
        filmes = new ArrayList<Filmes>();
        salas = new ArrayList<Salas>();
        sessoes = new ArrayList<Sessao>();
        vendas = new ArrayList<VendaDeIngressos>();
    }
    public void AdicionarFilme(Filmes filme){  //adicionando filmes
        filmes.add(filme);
    } 

    public void AdicionarSala(Salas sala){ //adicionando sala
        salas.add(sala);
    }

    public void AdicionarSessao(Sessao sessao){ // adicionando sessoes
        sessoes.add(sessao);
    }

    public void AdicionarVenda(VendaDeIngressos venda){ // adicionando vendas
        vendas.add(venda);
    }

}
