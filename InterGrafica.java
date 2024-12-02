/*
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
// do jp

public class InterGrafica extends JFrame implements ActionListener {

    public InterGrafica() {
        //setando características da janela como: titulo, tamanho/largura, que o X de sair funcione etc
        setTitle("Venda de Ingressos no Cinema");
        setVisible(true);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        //Botão para adicionar filem
        JButton jButtonAddFilme = new JButton("Adicionar Filme");
        jButtonAddFilme.setBounds(50, 50, 200, 50);
        jButtonAddFilme.setFont(new Font("Italico", Font.ITALIC, 18));
        jButtonAddFilme.addActionListener(this);
        jButtonAddFilme.setForeground(Color.BLACK);
        jButtonAddFilme.setBackground(Color.WHITE);
        add(jButtonAddFilme);

        //Botão para adicionar sala
        JButton jButtonAddSala = new JButton("Adicionar Sala");
        jButtonAddSala.setBounds(300, 50, 200, 50);
        jButtonAddSala.setFont(new Font("Italico", Font.ITALIC, 18));
        jButtonAddSala.addActionListener(this);
        jButtonAddSala.setForeground(Color.BLACK);
        jButtonAddSala.setBackground(Color.WHITE);
        add(jButtonAddSala);

        //Bitão para adicionar sessão
        JButton jButtonAddSessao = new JButton("Adicionar Sessão");
        jButtonAddSessao.setBounds(550, 50, 200, 50);
        jButtonAddSessao.setFont(new Font("Italico", Font.ITALIC, 18));
        jButtonAddSessao.addActionListener(this);
        jButtonAddSessao.setForeground(Color.BLACK);
        jButtonAddSessao.setBackground(Color.WHITE);
        add(jButtonAddSessao);

        //Botão para vender ingresso
        JButton jButtonVenderIngresso = new JButton("Vender Ingresso");
        jButtonVenderIngresso.setBounds(50, 150, 200, 50);
        jButtonVenderIngresso.setFont(new Font("Italico", Font.ITALIC, 18));
        jButtonVenderIngresso.addActionListener(this);
        jButtonVenderIngresso.setForeground(Color.BLACK);
        jButtonVenderIngresso.setBackground(Color.WHITE);
        add(jButtonVenderIngresso);

        JButton jButtonRemover = new JButton("Remover");
        jButtonRemover.setBounds(300, 150, 200, 50);
        jButtonRemover.setFont(new Font("Italico", Font.ITALIC, 18));
        jButtonRemover.addActionListener(this);
        jButtonRemover.setForeground(Color.BLACK);
        jButtonRemover.setBackground(Color.WHITE);
        add(jButtonRemover);

        //Botão para sair
        JButton jButtonSair = new JButton("Sair");
        jButtonSair.setBounds(550, 370, 200, 50);
        jButtonSair.setFont(new Font("Italico", Font.ITALIC, 20));
        jButtonSair.setForeground(Color.WHITE);
        jButtonSair.setBackground(Color.BLACK);
        add(jButtonSair);

        //faz que quando voce clique no botão o programa fecha
        jButtonSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    //metodo de declaração do ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Adicionar Filme":
                abrirJanelaAdicionar("Filme");
                break;

            case "Adicionar Sala":
                abrirJanelaAdicionar("Sala");
                break;

            case "Adicionar Sessão":
                abrirJanelaAdicionar("Sessão");
                break;

            case "Vender Ingresso":
                abrirJanelaAdicionar("Vender ingresso");
                break;

            case "Remover":
                abrirJanelaRemover();
                break;

            default:
        }
    }

    private void abrirJanelaAdicionar(String tipo) {
        JFrame janela = new JFrame("Adicionar " + tipo);
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(this);
        janela.setLayout(null);

        JLabel label = new JLabel("Digite o " + tipo + ":");
        label.setBounds(20, 20, 250, 30);
        janela.add(label);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(20, 60, 250, 30);
        janela.add(campoTexto);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(90, 110, 100, 30);
        botaoSalvar.addActionListener(e -> {
            System.out.println(tipo + " adicionado: " + campoTexto.getText());
            janela.dispose();
        });
        janela.add(botaoSalvar);

        janela.setVisible(true);
    }

    private void abrirJanelaRemover() {
        JFrame janela = new JFrame("Remover");
        janela.setSize(300, 200);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(this);
        janela.setLayout(null);

        JLabel label = new JLabel("Escolha o que deseja remover:");
        label.setBounds(20, 20, 250, 30);
        janela.add(label);

        String[] opcoes = {"Filme", "Sala", "Sessão"};
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(20, 60, 250, 30);
        janela.add(comboBox);

        JButton botaoRemover = new JButton("Remover");
        botaoRemover.setBounds(90, 110, 100, 30);
        botaoRemover.addActionListener(e -> {
            System.out.println("Removido: " + comboBox.getSelectedItem());
            janela.dispose();
        });
        janela.add(botaoRemover);

        janela.setVisible(true);
    }
}
*/