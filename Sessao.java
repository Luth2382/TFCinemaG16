
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
        this.assentosDisponiveis =  quantAssentos;
        this.precoIngresso = precoIngresso;
    }

    

    public int getQuantidadAssentos() {
        return assentosDisponiveis;
    }

    public Salas getSalasSessao(){
        return Salas;
    }

    public Filmes getFilmesSessao(){
        return Filmes;
    }
    public String getHorario(){
        return horario;
    }

    public Double getPrecoIngresso() {
        return precoIngresso;
    }

    public int getCodigoSala(){
        return codigoSessao;
    }

    public void venderIngresso(int quantidade){
        this.assentosDisponiveis -= quantidade;
    }
}
/*
 System.out.println("digite o codigo da sessão");
                        int sessaoCod = ent.nextInt();
                        System.out.println("Digite o horario da sessão");
                        String horario = ent.next();
                        System.out.println("Digite o codigo do filme");
                        int codFilme = ent.nextInt();
                        Filmes filmSessao = sistema.filmes.get(codFilme); //pele codigo do filme temos o seu "nome"
                        System.out.println("Digite a sala da sessão");
                        int salaSessao = ent.nextInt();
                        System.out.println("Digite o preço do ingresso dessa sessão");
                        int precoIngressoSessao = ent.nextInt();
                        Salas salaDaSessao = sistema.salas.get(salaSessao); // pelo numero da sala temos os seus dados
                        int AssentosSessao = salaDaSessao.getQuantidadeAssentos(); // quantidade de assentos na sessao
                        sistema.AdicionarSessao(new Sessao(sessaoCod, horario, filmSessao, salaDaSessao, AssentosSessao, AssentosSessao));
                        break;
 */