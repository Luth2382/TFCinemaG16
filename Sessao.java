public class Sessao {
    // aqui ela vai relacionar a sala com o filme que vai ser exibido e o seu horario de exibição
    private Salas Salas;
    private String horario;
    private Filmes Filmes;
    private int assentosDisponiveis;
    private int codigoSessao;

    public Sessao(int codigoSessao, int assentosDisponiveis, String horario, Filmes Filmes, int quantAssentos) {
        
        this.Salas = Salas;
        this.horario = horario;
        this.Filmes = Filmes;
        this.assentosDisponiveis = assentosDisponiveis;
        this.codigoSessao = codigoSessao;
    }
    public int assentosDisponiveis() {
     return assentosDisponiveis;
    }
}
