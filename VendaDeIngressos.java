public class VendaDeIngressos {
    private int quantidadeDeIngressos;
    private Sessao sessao;
    private Double valorTotal;

    public VendaDeIngressos(int quantidadeDeIngressos, Sessao sessao, Double valorTotal) {
        this.quantidadeDeIngressos = quantidadeDeIngressos;
        this.sessao = sessao;
        this.valorTotal = valorTotal;
    }


    //(vai usar buffer writter) registra a venda de um ingresso, relacionando a sessão  e realizando o controle de quantidade de assentos
}
