package br.edu.fatec.telas;

import br.edu.fatec.dados.Adicionar;
import br.edu.fatec.dados.Cifra;
import br.edu.fatec.dados.Musica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddMusica {
    JFrame frame;
    JLabel label1, label2, label3;
    JButton adicionar, voltar, fechar;
    JTextField textCodigo;
    int codigo;
    boolean verifica;
    String nomePlaylist;
    ImageIcon imagem = new ImageIcon("Violearn.png");
    Musica[] musica = new Musica[10];
    public AddMusica(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }

    public JLabel getLabel1(){
        label1 = new JLabel("Adicionar músicas");
        label1.setBounds(155,20,250,55);
        label1.setFont(new Font("verdana", Font.BOLD, 20));
        return label1;
    }

    public JLabel getLabel2(){
        label2 = new JLabel("<html><div style='text-align: center; line-height: 200px;'>Adicione uma das músicas disponíveis abaixo<br />" +
                "inserindo seu código</div></html>");
        label2.setBounds(110,50,400,55);
        label2.setFont(new Font("verdana", Font.BOLD, 12));
        return label2;
    }

    public JLabel getLabel3(){
        label3 = new JLabel("Código:");
        label3.setBounds(90,365,250,33);
        label3.setFont(new Font("verdana", Font.BOLD, 14));
        return label3;
    }

    public JTextField getTextCodigo(){
        textCodigo = new JTextField();
        textCodigo.setBounds(170,365,220,33);
        return textCodigo;
    }

    public JButton getBtnEnviar() {
        adicionar = new JButton("Enviar");
        //x,y, largura, altura
        adicionar.setBounds(260,420,150,33);

        ActionListener listener = e -> {

            try {
                // Tentar converter o texto para um número
                codigo = Integer.parseInt(textCodigo.getText());

                // Verificar se o código é um número inteiro
                if (codigo > 8 || codigo < 0) {
                    // Verificar se o código é menor que 9 e maior que 0
                    JOptionPane.showMessageDialog(frame, "O código inserido não está no intervalo válido. Tente novamente.",
                            "Erro", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Se todas as verificações passarem, abrir a janela
                    new Adicionar(codigo);
                    JOptionPane.showMessageDialog(frame, "A música foi adicionada com sucesso à Playlist.");
                }
            } catch (NumberFormatException ex) {
                // Se não for possível converter para um número
                JOptionPane.showMessageDialog(frame, "O código inserido não é um número válido. Tente novamente.",
                        "Erro", JOptionPane.WARNING_MESSAGE);
            }
        };
        adicionar.addActionListener(listener);
        return adicionar;
    }

    public JButton getBtnVoltar() {
        voltar = new JButton("Voltar");
        //x,y, largura, altura
        voltar.setBounds(70,420,150,33);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Opcoes(nomePlaylist).montarJanela();
                frame.dispose();
            }
        };

        voltar.addActionListener(listener);
        return voltar;
    }

    public JButton getBtnFechar() {
        fechar = new JButton("Fechar");
        //x,y, largura, altura
        fechar.setBounds(170,470,150,33);

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int fechar = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?",
                        "Sair",JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (fechar == JOptionPane.YES_OPTION) {
                    frame.dispose();
                } else {
                    return;
                }
            }
        };

        fechar.addActionListener(listener);
        return fechar;
    }

    JTable tabela;
    JScrollPane scroll;
    String[] colunas = {"Código", "Nome", "Artista"};
    String[][] dados = {{"Código", "Nome", "Artista"},
            {"0", "Believer", "Imagine Dragons"},
            {"1", "Chocolate", "Ana Frango Elétrico"},
            {"2", "Às Vezes um Clichê", "Maglore"},
            {"3", "Come As You Are", "Nirvana"},
            {"4", "Não Quero Dinheiro", "Tim Maia"},
            {"5", "Flores", "Titãs"},
            {"6", "Gostava Tanto de Você", "Tim Maia"},
            {"7", "Promessas", "Ana Frango Elétrico"},
            {"8", "Tempo Perdido", "Legião Urbana"}
    };
    public JTable getTabela(){
        tabela = new JTable(dados, colunas);
        tabela.setBounds(55,100,400,250);
        return tabela;
    }

    public JScrollPane getScroll(){
        scroll = new JScrollPane(tabela);
        return scroll;
    }

    public void montarJanela(){
        frame = new JFrame("Playlist: " + nomePlaylist);
        frame.setBounds(0,0,500,600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.getContentPane().add(getLabel1());
        frame.getContentPane().add(getLabel2());
        frame.getContentPane().add(getLabel3());
        frame.getContentPane().add(getTextCodigo());
        frame.getContentPane().add(getTabela());
        frame.getContentPane().add(getBtnEnviar());
        frame.getContentPane().add(getBtnVoltar());
        frame.getContentPane().add(getBtnFechar());

        //frame.setIconImage(imagem.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(imagem.getImage());
        frame.setVisible(true);
    }
}
