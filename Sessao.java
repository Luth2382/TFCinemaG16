
public class Sessao {

    // aqui ela vai relacionar a sala com o filme que vai ser exibido e o seu horario de exibição
    private Salas Salas;
    private String horario;
    private Filmes Filmes;
    private int assentosDisponiveis;
    private int codigoSessao;
    private Double precoIngresso;

    public Sessao(int codigoSessao, String horario, Filmes Filme, Salas sala, int quantAssentos, Double precoIngresso) {

        this.codigoSessao = codigoSessao;
        this.horario = horario;
        this.Filmes = Filme;
        this.Salas = sala;
        this.assentosDisponiveis = quantAssentos;
        this.precoIngresso = precoIngresso;
    }

    public int getQuantidadAssentos() {
        return assentosDisponiveis;
    }

    public Salas getSalasSessao() {
        return Salas;
    }

    public Filmes getFilmesSessao() {
        return Filmes;
    }

    public String getHorario() {
        return horario;
    }

    public Double getPrecoIngresso() {
        return precoIngresso;
    }

    public int getCodigoSala() {
        return codigoSessao;
    }

    public void venderIngresso(int quantidade) {
        this.assentosDisponiveis -= quantidade;
    }
    public String toString(){
        return "Sessao: " +codigoSessao;
    }
}
