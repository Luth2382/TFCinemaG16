
public class Salas {

    // classe para cadastrar as salas e quantidade de assentos de cada uma das salas
    private int numeroSala;
    private int quantidadeAssentos;

    public Salas(int numeroSala, int quantidadeAssentos) {
        this.numeroSala = numeroSala;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public int getQuantidadeAssentos() {
        return quantidadeAssentos;
    }
}
