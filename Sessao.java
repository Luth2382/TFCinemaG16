public class Sessao {
    // aqui ela vai relacionar a sala com o filme que vai ser exibido e o seu horario de exibição
    private Salas Salas;
    private String horario;
    private Filmes Filmes;
    private int assentosDisponiveis;

    public Sessao(Salas Salas, String horario, Filmes Filmes, int assentosDisponiveis) {
        
        this.Salas = Salas;
        this.horario = horario;
        this.Filmes = Filmes;
        this.assentosDisponiveis = assentosDisponiveis;
    }
    public int assentosDisponiveis() {
     return assentosDisponiveis;
    }
}
