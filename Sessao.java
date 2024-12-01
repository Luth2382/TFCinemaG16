public class Sessao {
    // aqui ela vai relacionar a sala com o filme que vai ser exibido e o seu horario de exibição
    private Salas Salas;
    private String horario;
    private Filmes Filmes;
    private int assentosDisponiveis;
    private int codigoSessao;

    public Sessao(int codigoSessao,  String horario, Filmes Filmes, Salas sala, int  quantAssentos) {
        
        this.codigoSessao = codigoSessao;
        this.horario = horario;
        this.Filmes = Filmes;
        this.Salas = Salas;
        this.assentosDisponiveis = assentosDisponiveis;
    }
    public int assentosDisponiveis() {
     return assentosDisponiveis;

    }
}
