package br.edu.fatec.telas;

import br.edu.fatec.dados.Cifra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ciframe {

    JFrame frame;
    JButton voltar, fechar;
    JLabel lblCifra;
    JScrollPane scroll;
    int codigo;
    Cifra cifra;

    public Ciframe(int codigo) {
        this.codigo = codigo;
    }

    public JScrollPane exibirCifra(){
        cifra = new Cifra();
        if (codigo == 0) {
            lblCifra = new JLabel(cifra.getBeliever());
        }
        else if (codigo == 1) {
            lblCifra = new JLabel(cifra.getChocolate());
        }
        else if (codigo == 2) {
                lblCifra = new JLabel(cifra.getCliche());
        }
        else if (codigo == 3) {
            lblCifra = new JLabel(cifra.getCome());
        }
        else if (codigo == 4) {
            lblCifra = new JLabel(cifra.getTimDinheiro());
        }
        else if (codigo == 5) {
            lblCifra = new JLabel(cifra.getFlores());
        }
        else if (codigo == 6) {
            lblCifra = new JLabel(cifra.getTimGostava());
        }
        else if (codigo == 7) {
            lblCifra = new JLabel(cifra.getPromessas());
        }
        else if (codigo == 8){
                lblCifra = new JLabel(cifra.getCifraLegiao());
        }

        lblCifra.setBounds(0,0,100,200);

        scroll = new JScrollPane(lblCifra);

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        return scroll;

    }

    /*public JButton getVoltar(){
        voltar = new JButton("Voltar");
        voltar.setBounds(300,300,150,33);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaCifra().montarJanela();
                frame.dispose();
            }
        };

        voltar.addActionListener(listener);
        return voltar;
    }

    public JButton getFechar(){
        fechar = new JButton("Fechar");
        fechar.setBounds(100,300,150,33);

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int fechar = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?",
                        "Sair",JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (fechar == JOptionPane.YES_OPTION) {
                    frame.dispose();
                } else {

                }
            }

        };

        fechar.addActionListener(listener);
        return fechar;
    }*/

    public void montarJanela(){
        frame = new JFrame("Cifra " + codigo);
        frame.setBounds(0,0,600,600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        frame.getContentPane().add(exibirCifra(),BorderLayout.CENTER);
        //frame.getContentPane().add(getVoltar());
        //frame.getContentPane().add(getFechar());

        //frame.setIconImage(imagem.getImage());

        frame.setVisible(true);
    }

}
