package br.edu.fatec.telas;

import javax.swing.*;
import java.awt.*;

public class RemoverMusica {

    JFrame frame;

    String nomePlaylist;

    public RemoverMusica(String nomePlaylist){
        this.nomePlaylist = nomePlaylist;
    }

    public void montarJanela(){
        frame = new JFrame("Adicionando músicas a " + nomePlaylist);
        frame.setSize(550,550);



        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

}
