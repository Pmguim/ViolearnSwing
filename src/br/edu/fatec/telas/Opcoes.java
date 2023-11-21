package br.edu.fatec.telas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import br.edu.fatec.dados.Playlist;

public class Opcoes {

    JFrame framePlaylist;
    JLabel label1, lblOpcoes, lblImagem;
    JButton btnAdd, btnRemove, btnMostrar, btnExcluir, btnFechar, btnCifra;
    String nomePlaylist;
    Playlist playlist = new Playlist(nomePlaylist);

    //Pegando o nome da playlist inserido na primeira tela:
    public Opcoes(String playlistData) {
        this.nomePlaylist = playlistData;
    }

    public JLabel getLblWel() {
        label1 = new JLabel("Violearn");
        label1.setFont(new Font("verdana", Font.BOLD, 24));
        //x, y, largura, altura
        label1.setBounds(165, 100, 200, 33);
        return label1;
    }

    public JLabel getLblOpcoes() {
        lblOpcoes = new JLabel("O que deseja fazer com sua playlist?");
        lblOpcoes.setFont(new Font("verdana", Font.BOLD, 12));
        //x, y, largura, altura
        lblOpcoes.setBounds(100, 140, 250, 33);
        return lblOpcoes;
    }

    public JButton getBtnAdd() {
        btnAdd = new JButton("Adicionar músicas");
        //x,y,largura,altura
        btnAdd.setBounds(40,180,150,33);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {;
                new AddMusica(nomePlaylist).montarJanela();
                framePlaylist.dispose();
            }
        };

        btnAdd.addActionListener(listener);
        return btnAdd;
    }

    public JButton getBtnRemove() {
        btnRemove = new JButton("Remover músicas");
        btnRemove.setBounds(240,180,150,33);

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (playlist.nulo()){
                    JOptionPane.showMessageDialog(null, "Não há o que remover, pois a playlist está vazia.", "Playlist vazia", JOptionPane.OK_OPTION);
                } else {
                    new RemoverMusica(nomePlaylist).montarJanela();
                    framePlaylist.dispose();
                }
            }

        };

        btnRemove.addActionListener(listener);

        return btnRemove;
    }

    public JButton getBtnMostrar() {
        btnMostrar = new JButton("Mostra-la");
        //x, y, largura, altura
        btnMostrar.setBounds(40,230,150,33);

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (playlist.isNull()){
                    JOptionPane.showMessageDialog(framePlaylist,"Não há o que mostrar da playlist," +
                            " pois ela está vazia.", "Playlist vazia", JOptionPane.WARNING_MESSAGE);
                } else {
                    framePlaylist.dispose();
                    new Listar(nomePlaylist).montarJanela();
                }
            }

        };

        btnMostrar.addActionListener(listener);

        return btnMostrar;
    }

    public JButton getBtnExcluir() {
        btnExcluir = new JButton("Excluir a playlist");
        //x,y,largura,altura
        btnExcluir.setBounds(240,230, 150,33);

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int delete = JOptionPane.showConfirmDialog(btnExcluir,
                        "Deseja realmente excluir a playlist '" + nomePlaylist + "' ?",
                        "Excluir (nome da playlist)", JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (delete == JOptionPane.YES_OPTION) {
                    playlist.excluirPlaylist();
                    framePlaylist.dispose();
                    new CriarPlaylist().montarJanela();
                } else {
                    return;
                }
            }

        };

        btnExcluir.addActionListener(listener);
        return btnExcluir;
    }

    public JButton getBtnCifra(){
        btnCifra = new JButton("Cifra");

        btnCifra.setBounds(145,285,150,33);
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaCifra(nomePlaylist).montarJanela();
                framePlaylist.dispose();
            }
        };

        btnCifra.addActionListener(listener);
        return btnCifra;
    }

    public JButton getBtnFechar() {
        btnFechar = new JButton("Fechar");
        //x,y, largura, altura
        btnFechar.setBounds(145,350,150,33);

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int fechar = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?",
                        "Sair",JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (fechar == JOptionPane.YES_OPTION) {
                    framePlaylist.dispose();
                } else {

                }
            }

        };

        btnFechar.addActionListener(listener);
        return btnFechar;
    }

    ImageIcon icone = new ImageIcon("Violearn_icone.png");
    ImageIcon imagem = new ImageIcon("Violearn.png");

    public JLabel getLblImg() {
        lblImagem = new JLabel();
        lblImagem.setIcon(icone);
        //x,y,largura,altura
        lblImagem.setBounds(187,15,80,80);
        return lblImagem;
    }

    public void montarJanela() {

        framePlaylist = new JFrame("Playlist: " + nomePlaylist);
        framePlaylist.setBounds(0,0,450,500);
        framePlaylist.setLocationRelativeTo(null);
        framePlaylist.setResizable(false);
        framePlaylist.setLayout(null);

        framePlaylist.getContentPane().add(getLblWel());
        framePlaylist.getContentPane().add(getLblOpcoes());
        framePlaylist.getContentPane().add(getBtnAdd());
        framePlaylist.getContentPane().add(getBtnRemove());
        framePlaylist.getContentPane().add(getBtnMostrar());
        framePlaylist.getContentPane().add(getBtnExcluir());
        framePlaylist.getContentPane().add(getBtnCifra());
        framePlaylist.getContentPane().add(getBtnFechar());
        framePlaylist.getContentPane().add(getLblImg());

        framePlaylist.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePlaylist.setIconImage(imagem.getImage());
        framePlaylist.setVisible(true);
    }

}