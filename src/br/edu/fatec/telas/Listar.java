package br.edu.fatec.telas;

import javax.swing.*;
import java.awt.*;

public class Listar {

    JFrame frame;
    String nomePlaylist;
    ImageIcon imagem = new ImageIcon("Violearn.png");

    public Listar(String nomePlaylist){
        this.nomePlaylist = nomePlaylist;
    }

    public void montarJanela(){
        frame = new JFrame("Playlist: " + nomePlaylist);
        frame.setBounds(0,0,450,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(imagem.getImage());
        frame.setVisible(true);
    }

}
