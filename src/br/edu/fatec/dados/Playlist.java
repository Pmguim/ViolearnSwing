package br.edu.fatec.dados;

import javax.swing.*;
import java.awt.*;

public class Playlist {

    String nomePlaylist;
    Musica[] musicas;
    int tamanho;


    public Playlist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
        this.musicas = new Musica[10];
        this.tamanho = 0;
    }

    public String getNomePlaylist() {
        return nomePlaylist;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void listar(int id){
            musicas[id].imprimirCifra();
    }

    public boolean nulo(){
        for (int i = 0; i < musicas.length; i++){
            if (musicas[i] != null){
                return false;
            }
        }
        return true;
    }

    public void mostrarMusica(int id) {

        if (musicas[id] == null) {
            JOptionPane.showMessageDialog(null, "Índice inválido, tente novamente.");
        } else {
            musicas[id].imprimirCifra();
        }
    }

    public boolean isNull() {
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null) {
                return false;
            }
        }
        return true;
    }

    public void excluirPlaylist() {

        this.nomePlaylist = null;
        this.musicas = new Musica[10];
        this.tamanho = 0;

        JOptionPane.showMessageDialog(null, "A playlist foi excluída.");
    }


}
