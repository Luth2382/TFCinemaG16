import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CinemaMain {
    mainGestao sistema = new mainGestao();
    private JFrame frame;
    private JPanel panelPrincipal;
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                CinemaMain window = new CinemaMain();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CinemaMain() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0, 1, 10, 10));
        frame.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        
        JButton btnCadastrarFilme = new JButton("Cadastrar Filme");
        btnCadastrarFilme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCadastroFilme();
            }
        });
        panelPrincipal.add(btnCadastrarFilme);
        
        JButton btnCadastrarSala = new JButton("Cadastrar Sala");
        btnCadastrarSala.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCadastroSala();
            }
        });
        panelPrincipal.add(btnCadastrarSala);
        
        JButton btnCadastrarSessao = new JButton("Cadastrar Sessão");
        btnCadastrarSessao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCadastroSessao();
            }
        });
        panelPrincipal.add(btnCadastrarSessao);
        
        JButton btnVendaIngressos = new JButton("Venda de Ingressos");
        btnVendaIngressos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openVendaIngressos();
            }
        });
        panelPrincipal.add(btnVendaIngressos);

        JButton btnGerarRelatorio = new JButton("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarRelatorio();
            }
        });
        panelPrincipal.add(btnGerarRelatorio);
    }

    private void openCadastroFilme() {
        // Abrir nova janela para cadastro de filme
        JFrame TelacadastroFilme = new JFrame("Cadastro de Filme");
        TelacadastroFilme.setSize(300, 300);

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
        btSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Filme salvo: " + txtNome.getText());
                TelacadastroFilme.dispose();
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
        JFrame cadastroSalaFrame = new JFrame("Cadastro de Sala");
        cadastroSalaFrame.setSize(300, 200);
        JPanel panelCadastroSala = new JPanel();
        cadastroSalaFrame.setLocationRelativeTo(null);
        panelCadastroSala.setLayout(new GridLayout(3, 2, 10, 10));
        
        JLabel lblNumeroSala = new JLabel("Número da Sala:");
        JTextField txtNumeroSala = new JTextField();
        JLabel lblQuantidadeAssentos = new JLabel("Quantidade de Assentos:");
        JTextField txtQuantidadeAssentos = new JTextField();
        
        JButton btnSalvarSala = new JButton("Salvar");
        btnSalvarSala.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int numeroSala = Integer.parseInt(txtNumeroSala.getText());
                    int quantidadeAssentos = Integer.parseInt(txtQuantidadeAssentos.getText());
                    // Adicionando sala ao sistema
                    sistema.AdicionarSala(new Salas(numeroSala, quantidadeAssentos));
                    JOptionPane.showMessageDialog(cadastroSalaFrame, "Sala cadastrada com sucesso!");
                    cadastroSalaFrame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(cadastroSalaFrame, "Por favor, insira números válidos.");
                }
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

        JPanel panelCadastroSessao = new JPanel();
        panelCadastroSessao.setLayout(new GridLayout(5, 2, 10, 10));
    
        // Adicionando os filmes cadastrados
        JLabel lblFilme = new JLabel("Escolha um Filme:");
        JComboBox<Filmes> comboFilmes = new JComboBox<>(sistema.filmes.toArray(new Filmes[0]));
        
        // Adicionando as salas cadastradas
        JLabel lblSala = new JLabel("Escolha uma Sala:");
        JComboBox<Salas> comboSalas = new JComboBox<>(sistema.salas.toArray(new Salas[0]));
        
        JLabel lblHorario = new JLabel("Horário da Sessão:");
        JTextField txtHorario = new JTextField();
        
        JLabel lblPrecoIngresso = new JLabel("Preço do Ingresso:");
        JTextField txtPrecoIngresso = new JTextField();
        
        JButton btnSalvarSessao = new JButton("Salvar Sessão");
        btnSalvarSessao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Filmes filmeSelecionado = (Filmes) comboFilmes.getSelectedItem();
                    Salas salaSelecionada = (Salas) comboSalas.getSelectedItem();
                    String horario = txtHorario.getText();
                    double precoIngresso = Double.parseDouble(txtPrecoIngresso.getText());
                    int quantidadeAssentos = salaSelecionada.getQuantidadeAssentos();
    
                    // Adicionando sessão ao sistema
                    Sessao novaSessao = new Sessao(sistema.sessoes.size() + 1, horario, filmeSelecionado, salaSelecionada, quantidadeAssentos, precoIngresso);
                    sistema.AdicionarSessao(novaSessao);
                    JOptionPane.showMessageDialog(telaCadastroSessao, "Sessão cadastrada com sucesso!");
                    telaCadastroSessao.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(telaCadastroSessao, "Por favor, insira valores válidos.");
                }
            }
        });
    
        panelCadastroSessao.add(lblFilme);
        panelCadastroSessao.add(comboFilmes);
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
        JFrame vendaIngressosFrame = new JFrame("Venda de Ingressos");
        vendaIngressosFrame.setSize(350, 200);
        JPanel panelVendaIngressos = new JPanel();
        panelVendaIngressos.setLayout(new GridLayout(3, 2, 10, 10));
        
        JLabel lblSessao = new JLabel("Escolha a Sessão:");
        JComboBox<Sessao> comboSessoes = new JComboBox<>(sistema.sessoes.toArray(new Sessao[0]));
        
        JLabel lblQuantidadeIngressos = new JLabel("Quantidade de Ingressos:");
        JTextField txtQuantidadeIngressos = new JTextField();
        
        JButton btnVenderIngresso = new JButton("Vender Ingresso");
        btnVenderIngresso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Sessao sessaoSelecionada = (Sessao) comboSessoes.getSelectedItem();
                    int quantidadeIngressos = Integer.parseInt(txtQuantidadeIngressos.getText());
                    
                    if (sessaoSelecionada.getQuantidadAssentos() >= quantidadeIngressos) {
                        // Vender os ingressos
                        sessaoSelecionada.venderIngresso(quantidadeIngressos);
                        sistema.AdicionarVenda(new VendaDeIngressos(quantidadeIngressos, sessaoSelecionada, sessaoSelecionada.getPrecoIngresso()));
                        JOptionPane.showMessageDialog(vendaIngressosFrame, "Compra realizada com sucesso!");
                        vendaIngressosFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(vendaIngressosFrame, "Ingressos insuficientes disponíveis.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vendaIngressosFrame, "Por favor, insira um número válido de ingressos.");
                }
            }
        });
    
        panelVendaIngressos.add(lblSessao);
        panelVendaIngressos.add(comboSessoes);
        panelVendaIngressos.add(lblQuantidadeIngressos);
        panelVendaIngressos.add(txtQuantidadeIngressos);
        panelVendaIngressos.add(btnVenderIngresso);
        
        vendaIngressosFrame.add(panelVendaIngressos);
        vendaIngressosFrame.setVisible(true);
    }
    

  private void gerarRelatorio() {
    System.out.println("Gerando relatório...");
    String arquivoRelatorio = "relatorio_cinema.txt";
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoRelatorio))) {
        writer.write("Relatório do cinema \n");
        writer.write("\nFilmes Disponíveis:\n");
        for (Filmes filme : sistema.filmes) {
            writer.write("Código: " + filme.getCodigo() + ", Nome: " + filme.getNome() + ", Gênero: " + filme.getGenero() + "\n");
        }

        // Relatório de salas
        writer.write("\nSalas Disponíveis:\n");
        for (Salas sala : sistema.salas) {
            writer.write("Número da Sala: " + sala.getNumeroSala() + ", Quantidade de Assentos: " + sala.getQuantidadeAssentos() + "\n");
        }

        // Relatório de sessões
        writer.write("\nSessões Existentes:\n");
        for (Sessao sessao : sistema.sessoes) {
            writer.write("Código Sessão: " + sessao.getCodigoSala() + ", Sala: " + sessao.getSalasSessao().getNumeroSala() + ", Filme: " + sessao.getFilmesSessao().getNome() + ", Horário: " + sessao.getHorario() + "\n");
        }

        // Relatório de vendas por filme
        writer.write("\nVendas por Filme:\n");
        for (Filmes filme : sistema.filmes) {
            int totalVendasFilme = 0;
            for (VendaDeIngressos venda : sistema.vendas) {
                if (venda.getSessao().getFilmesSessao().equals(filme)) {
                    totalVendasFilme += venda.getQuantidadeDeIngressos();
                }
            }
            writer.write("Filme: " + filme.getNome() + ", Total de Ingressos Vendidos: " + totalVendasFilme + "\n");
        }

        // Finalização do relatório
        writer.write("\n====================================\n");
        writer.write("Relatório gerado com sucesso!\n");

    } catch (IOException e) {
        System.out.println("Erro ao gerar o relatório: " + e.getMessage());
    }
}

    }