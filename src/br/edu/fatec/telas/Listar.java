package br.edu.fatec.telas;

import br.edu.fatec.dados.Adicionar;

import javax.swing.*;
import java.awt.*;

public class Listar {

    JFrame frame;
    String nomePlaylist;
    JLabel label1;
    ImageIcon imagem = new ImageIcon("Violearn.png");
    Adicionar adicionar;
    int codigo;

    public Listar(int codigo,String nomePlaylist){
        this.codigo = codigo;
        this.nomePlaylist = nomePlaylist;
    }

    /*public JLabel getPlaylist(){
        label1 = new JLabel(adicionar.adicionarMusicas(codigo));
        return label1;
    }*/

    public void montarJanela(){
        frame = new JFrame("Playlist: " + nomePlaylist);
        frame.setBounds(0,0,450,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        
        /*frame.getContentPane().add(getPlaylist());*/

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(imagem.getImage());
        frame.setVisible(true);
    }

}
