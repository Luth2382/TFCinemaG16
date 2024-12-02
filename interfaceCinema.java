
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class interfaceCinema {

    mainGestao sistema = new mainGestao();
    private JFrame frame; // criando janela
    private JPanel panelPrincipal;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> { // invoke later para tratar exeções da janela
            try {
                interfaceCinema window = new interfaceCinema();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public interfaceCinema() {
        initialize(); // iniciando a janela
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0, 1, 10, 10)); // usei grid layout para fazer com que os botões ficassem um acima do outro e ficassem mais "bonitinhos"
        frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);

        JButton btnCadastrarFilme = new JButton("Cadastrar Filme");
        btnCadastrarFilme.addActionListener(e -> openCadastroFilme()); // puxando o metodo pra cadastrar o filme n dentro do botão
        panelPrincipal.add(btnCadastrarFilme); // adicionando botao no painel

        JButton btCadastrarSala = new JButton("Cadastrar Sala");
        btCadastrarSala.addActionListener(e -> openCadastroSala()); // puxando metodo pra cadastrar a sala
        panelPrincipal.add(btCadastrarSala);

        JButton btnCadastrarSessao = new JButton("Cadastrar Sessão");
        btnCadastrarSessao.addActionListener(e -> openCadastroSessao());
        panelPrincipal.add(btnCadastrarSessao);

        JButton btnVendaIngressos = new JButton("Venda de Ingressos");
        btnVendaIngressos.addActionListener(e -> openVendaIngressos());
        panelPrincipal.add(btnVendaIngressos);

        JButton btnGerarRelatorio = new JButton("Gerar Relatório");
        btnGerarRelatorio.addActionListener(e -> gerarRelatorio());
        panelPrincipal.add(btnGerarRelatorio);
    }

    private void openCadastroFilme() { // abrindo janela para cadastrar o filme
        JFrame TelacadastroFilme = new JFrame("Cadastro de Filme");
        TelacadastroFilme.setSize(300, 300); //tamanho da tela
        TelacadastroFilme.setLocationRelativeTo(null); //centralizar a tela
        JPanel panelCadastroFilme = new JPanel();
        panelCadastroFilme.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblCodigo = new JLabel("Código:");
        JTextField txtCodigo = new JTextField();
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();
        JLabel lblGenero = new JLabel("Gênero:");
        JTextField txtGenero = new JTextField();
        JLabel lblSinopse = new JLabel("Sinopse:");
        JTextField txtSinopse = new JTextField();

        JButton btSalvar = new JButton("Salvar");
        btSalvar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText()); // Garantir que o código seja um número
                Filmes filme = new Filmes(codigo, txtNome.getText(), txtGenero.getText(), txtSinopse.getText()); // inserindo em filmes
                sistema.AdicionarFilme(filme); // Adicionando o filme à lista
                System.out.println("Filme salvo: " + txtNome.getText());
                TelacadastroFilme.dispose(); // Fechando a janela após salvar
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(TelacadastroFilme, "Código do filme inválido");
            }
        });

        panelCadastroFilme.add(lblCodigo);
        panelCadastroFilme.add(txtCodigo);
        panelCadastroFilme.add(lblNome);
        panelCadastroFilme.add(txtNome);
        panelCadastroFilme.add(lblGenero);
        panelCadastroFilme.add(txtGenero);
        panelCadastroFilme.add(lblSinopse);
        panelCadastroFilme.add(txtSinopse);
        panelCadastroFilme.add(btSalvar);

        TelacadastroFilme.add(panelCadastroFilme);
        TelacadastroFilme.setVisible(true);
    }

    private void openCadastroSala() {
        JFrame cadastroSalaFrame = new JFrame("Cadastrar sala");
        cadastroSalaFrame.setSize(300, 200);
        JPanel panelCadastroSala = new JPanel();
        cadastroSalaFrame.setLocationRelativeTo(null);
        panelCadastroSala.setLayout(new GridLayout(3, 2, 10, 10)); // deixando em opção de pilha, uma acima da outra

        JLabel lblNumeroSala = new JLabel("Numero da sala");
        JTextField txtNumeroSala = new JTextField();
        JLabel lblQuantidadeAssentos = new JLabel("Quantidade de Assentos:");
        JTextField txtQuantidadeAssentos = new JTextField();

        JButton btnSalvarSala = new JButton("Salvar");
        btnSalvarSala.addActionListener(e -> {
            try {
                int numeroSala = Integer.parseInt(txtNumeroSala.getText());
                int quantidadeAssentos = Integer.parseInt(txtQuantidadeAssentos.getText());
                Salas sala = new Salas(numeroSala, quantidadeAssentos);
                sistema.AdicionarSala(sala); // Adicionando a sala à lista
                JOptionPane.showMessageDialog(cadastroSalaFrame, "Sala cadastrada");
                cadastroSalaFrame.dispose(); // Fechando a janela após salvar
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(cadastroSalaFrame, "Numeros inválidos");
            }
        });

        panelCadastroSala.add(lblNumeroSala);
        panelCadastroSala.add(txtNumeroSala);
        panelCadastroSala.add(lblQuantidadeAssentos);
        panelCadastroSala.add(txtQuantidadeAssentos);
        panelCadastroSala.add(btnSalvarSala);

        cadastroSalaFrame.add(panelCadastroSala);
        cadastroSalaFrame.setVisible(true);
    }

    private void openCadastroSessao() {
        JFrame telaCadastroSessao = new JFrame("Cadastro de Sessão");
        telaCadastroSessao.setSize(350, 300);
        telaCadastroSessao.setLocationRelativeTo(null);
        JPanel panelCadastroSessao = new JPanel();
        panelCadastroSessao.setLayout(new GridLayout(5, 2, 10, 10));

        // Adicionando os filmes cadastrados
        JLabel lblFilme = new JLabel("Escolha um Filme:");
        JComboBox<Filmes> comboFilmes = new JComboBox<>(sistema.filmes.toArray(new Filmes[0])); // usando jcombo para criar uma pilha de itens 

        // Adicionando as salas cadastradas
        JLabel lblSala = new JLabel("Escolha uma Sala:");
        JComboBox<Salas> comboSalas = new JComboBox<>(sistema.salas.toArray(new Salas[0]));

        JLabel lblHorario = new JLabel("Horario da Sessao:");
        JTextField txtHorario = new JTextField();

        JLabel lblPrecoIngresso = new JLabel("Preco do Ingresso:");
        JTextField txtPrecoIngresso = new JTextField();

        JButton btnSalvarSessao = new JButton("Salvar Sessao");
        btnSalvarSessao.addActionListener(e -> {
            try { // testando se os elementos estão certos e não tem erro
                Filmes filmeSelecionado = (Filmes) comboFilmes.getSelectedItem();
                Salas salaSelecionada = (Salas) comboSalas.getSelectedItem();
                String horario = txtHorario.getText();
                double precoIngresso = Double.parseDouble(txtPrecoIngresso.getText());
                int quantidadeAssentos = salaSelecionada.getQuantidadeAssentos();

                Sessao novaSessao = new Sessao( // Adicionando sessão ao cinema
                        sistema.sessoes.size() + 1,
                        horario,
                        filmeSelecionado,
                        salaSelecionada,
                        quantidadeAssentos,
                        precoIngresso
                );
                sistema.AdicionarSessao(novaSessao);
                JOptionPane.showMessageDialog(telaCadastroSessao, "Sessão cadastrada");
                telaCadastroSessao.dispose();
            } catch (NumberFormatException ex) { // caso existirem erros, o catch vai avisa-los
                JOptionPane.showMessageDialog(telaCadastroSessao, "digite um numero valido.");
            }
        });

        panelCadastroSessao.add(lblFilme);
        panelCadastroSessao.add(comboFilmes); // adicionando a lista criada com jcombobox 
        panelCadastroSessao.add(lblSala);
        panelCadastroSessao.add(comboSalas);
        panelCadastroSessao.add(lblHorario);
        panelCadastroSessao.add(txtHorario);
        panelCadastroSessao.add(lblPrecoIngresso);
        panelCadastroSessao.add(txtPrecoIngresso);
        panelCadastroSessao.add(btnSalvarSessao);

        telaCadastroSessao.add(panelCadastroSessao);
        telaCadastroSessao.setVisible(true);
    }

    private void openVendaIngressos() {
        JFrame VendaDeIngressosTela = new JFrame("Venda de Ingressos");
        VendaDeIngressosTela.setSize(350, 200);
        VendaDeIngressosTela.setLocationRelativeTo(null);
        JPanel panelVendaIngressos = new JPanel();
        panelVendaIngressos.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblSessao = new JLabel("Escolha a Sessao:");
        JComboBox<Sessao> comboSessoes = new JComboBox<>(sistema.sessoes.toArray(new Sessao[0]));

        JLabel lblQuantidadeIngressos = new JLabel("Quantidade de Ingressos:");
        JTextField txtQuantidadeIngressos = new JTextField();

        JButton btnVenderIngresso = new JButton("Vender Ingresso");
        btnVenderIngresso.addActionListener(e -> {
            try {
                Sessao sessaoSelecionada = (Sessao) comboSessoes.getSelectedItem();
                int quantidadeIngressos = Integer.parseInt(txtQuantidadeIngressos.getText());

                if (sessaoSelecionada.getQuantidadAssentos() >= quantidadeIngressos) { // Vendendo os ingressos
                    sessaoSelecionada.venderIngresso(quantidadeIngressos);
                    sistema.AdicionarVenda(new VendaDeIngressos(quantidadeIngressos, sessaoSelecionada, sessaoSelecionada.getPrecoIngresso()));
                    JOptionPane.showMessageDialog(VendaDeIngressosTela, "Compra realizada com sucesso!");
                    VendaDeIngressosTela.dispose();
                } else {
                    JOptionPane.showMessageDialog(VendaDeIngressosTela, "Ingressos insuficientes disponíveis.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(VendaDeIngressosTela, "numero de ingressos invalido");
            }
        });

        panelVendaIngressos.add(lblSessao);
        panelVendaIngressos.add(comboSessoes);
        panelVendaIngressos.add(lblQuantidadeIngressos);
        panelVendaIngressos.add(txtQuantidadeIngressos);
        panelVendaIngressos.add(btnVenderIngresso);

        VendaDeIngressosTela.add(panelVendaIngressos);
        VendaDeIngressosTela.setVisible(true);
    }

    private void gerarRelatorio() {
        System.out.println("Gerando relatorio do cinema");
        String arquivoRelatorio = "relatorio_cinema.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoRelatorio))) {
            writer.write("Relatorio do cinema \n");
            writer.write("\nFilmes:\n");

            // Gerando o relatório de filmes
            for (Filmes filme : sistema.filmes) {
                writer.write("Codigo: " + filme.getCodigo() + ", Nome: " + filme.getNome() + ", Genero: " + filme.getGenero() + "\n");
            }

            // Gerando o relatório de salas
            writer.write("\nSalas:\n");
            for (Salas sala : sistema.salas) {
                writer.write("Numero da Sala: " + sala.getNumeroSala() + ", Quantidade de Assentos: " + sala.getQuantidadeAssentos() + "\n");
            }

            // Gerando o relatório de sessões
            writer.write("\nSessoes:\n");
            for (Sessao sessao : sistema.sessoes) {
                writer.write("Codigo Sessao: " + sessao.getCodigoSala() + ", Sala: " + sessao.getSalasSessao().getNumeroSala()
                        + ", Filme: " + sessao.getFilmesSessao().getNome() + ", Horario: " + sessao.getHorario() + "\n");
            }

            // Gerando o relatório de vendas por filme
            writer.write("\nVendas por Filme:\n");
            for (Filmes filme : sistema.filmes) {
                int totalVendasFilme = 0;
                // Somando as vendas de ingressos para cada filme
                for (VendaDeIngressos venda : sistema.vendas) {
                    if (venda.getSessao().getFilmesSessao().equals(filme)) {
                        totalVendasFilme += venda.getQuantidadeDeIngressos();
                    }
                }
                writer.write("Filme: " + filme.getNome() + ", Quantidade de ingressos Vendidos: " + totalVendasFilme + "\n");
            }

            //final do relatorio
            writer.write("\n");
            JOptionPane.showMessageDialog(null, "Relatório gerado");
        } catch (IOException e) {
            System.out.println("Erro ao gerar o relatorio: " + e.getMessage()); // caso de erro na geração do relatório
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + e.getMessage());
        }
    }
}
