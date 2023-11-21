package br.edu.fatec.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import br.edu.fatec.dados.Playlist;

public class CriarPlaylist {

        JFrame framePlaylist;
        JLabel label1, lblNome, lblImg;
        JTextField nomePlaylist;
        JButton btnEnviar, btnLimpar, btnFechar;
        Playlist playlist;
        String playlistData, check;
        int checkTry;

        public JLabel getLblWel() {
            label1 = new JLabel("Violearn");
            label1.setFont(new Font("verdana", Font.BOLD, 24));
            //x, y, largura, altura
            label1.setBounds(200, 80, 200, 33);
            return label1;
        }

        public JLabel getLblNomePl() {
            lblNome = new JLabel("Insira o nome da sua playlist:");
            //x,y,largura,altura
            lblNome.setBounds(40,120,250,30);
            return lblNome;
        }

        public JTextField getTxtNome() {
            nomePlaylist = new JTextField();
            //x,y, altura, largura
            nomePlaylist.setBounds(210, 125, 245, 25);
            return nomePlaylist;
        }

        public JButton getBtnlimpar() {
            btnLimpar = new JButton("Limpar");
            //x,y,largura,altura
            btnLimpar.setBounds(150,180,100,33);

            ActionListener listener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {;
                    nomePlaylist.setText("");
                }
            };

            btnLimpar.addActionListener(listener);
            return btnLimpar;
        }

        public JButton getBtnEnviar() {
            btnEnviar = new JButton("Enviar");
            //x,y,largura,altura
            btnEnviar.setBounds(270,180,100,33);

            ActionListener listener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    playlistData = nomePlaylist.getText();
                    playlist = new Playlist(playlistData);

                    //Verificando se o campo de nome da playlist está em branco:
                    if (nomePlaylist.getText() == null || nomePlaylist.getText().isEmpty() || nomePlaylist.getText().isBlank()) {					;
                        JOptionPane.showMessageDialog(btnEnviar, "O nome da playlist não pode ficar em branco!", "Nome em branco", JOptionPane.WARNING_MESSAGE);
                    } else{
                        JOptionPane.showMessageDialog(btnEnviar, "A playlist '" + playlist.getNomePlaylist() + "' foi cadastrada com sucesso!");
                        new Opcoes(playlistData).montarJanela();
                        framePlaylist.dispose();
                    }
                }
            };
            btnEnviar.addActionListener(listener);
            return btnEnviar;
        }

        public JButton getBtnFechar() {
            btnFechar = new JButton("Fechar");
            //x,y, largura, altura
            btnFechar.setBounds(210,230,100,33);

            ActionListener listener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    int fechar = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?",
                            "Fechar o Violearn",JOptionPane.YES_NO_OPTION,
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

        ImageIcon imagem = new ImageIcon("Violearn_icone.png");
        ImageIcon icone = new ImageIcon("Violearn.png");

        public JLabel getLblImg() {
            lblImg = new JLabel();
            lblImg.setIcon(imagem);
            //x,y,largura,altura
            lblImg.setBounds(220,0,80,80);
            return lblImg;
        }

        public void montarJanela() {
            framePlaylist = new JFrame("Criando sua playlist");

            framePlaylist.setBounds(0,0,500,330);
            framePlaylist.setLocationRelativeTo(null);
            framePlaylist.setResizable(false);
            framePlaylist.setLayout(null);

            framePlaylist.getContentPane().add(getLblImg());
            framePlaylist.getContentPane().add(getLblWel());
            framePlaylist.getContentPane().add(getLblNomePl());
            framePlaylist.getContentPane().add(getTxtNome());
            framePlaylist.getContentPane().add(getBtnEnviar());
            framePlaylist.getContentPane().add(getBtnlimpar());
            framePlaylist.getContentPane().add(getBtnFechar());

            framePlaylist.setDefaultCloseOperation(framePlaylist.EXIT_ON_CLOSE);
            framePlaylist.setVisible(true);
            framePlaylist.setIconImage(icone.getImage());
        }
}
