
public class VendaDeIngressos {

    private int quantidadeDeIngressos;
    private Sessao sessao;
    private Double valorTotal;

    public VendaDeIngressos(int quantidadeDeIngressos, Sessao sessao, Double valorTotal) {
        this.quantidadeDeIngressos = quantidadeDeIngressos;
        this.sessao = sessao;
        this.valorTotal = valorTotal;
    }

    public boolean disponibilidadeIngresso(int quant) {
        if (quantidadeDeIngressos == 0) {
            return false;
        } else {
            return true;

        }

    }

    public int getQuantidadeDeIngressos() {
        return quantidadeDeIngressos;
    }

    public void setQuantidadeDeIngressos(int quantidadeDeIngressos) {
        this.quantidadeDeIngressos = quantidadeDeIngressos;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void ingressoVendido() {

    }

    public void precoDoAssento(Sessao sessao, int preco) {

    }

}
//(vai usar buffer writter) registra a venda de um ingresso, relacionando a sessão  e realizando o controle de quantidade de assentos
