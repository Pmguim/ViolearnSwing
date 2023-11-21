package br.edu.fatec.dados;

import javax.swing.*;
import java.awt.*;

public class Musica{

    String compositor;
    String nomeMusica;
    String cifra;
    String[] musicas = new String[9];
    String[] artistas = new String[7];

    JLabel lblNomeMusica, lblCompositor, lblCifra;

    public void setMusicas() {
        musicas[0] = "Believer";
        musicas[1] = "Chocolate";
        musicas[2] = "Às Vezes um Clichê";
        musicas[3] = "Come As You Are";
        musicas[4] = "Não Quero Dinheiro";
        musicas[5] = "Flores";
        musicas[6] = "Gostava Tanto de Você";
        musicas[7] = "Promessas";
        musicas[8] = "Tempo perdido";
    }

    public String[] getMusicas(){
        return musicas;
    }

    public void setArtistas() {
        artistas[0] = "Imagine Dragons";
        artistas[1] = "Ana Frango Elétrico";
        artistas[2] = "Nirvana";
        artistas[3] = "Tim Maia";
        artistas[4] = "Titãs";
        artistas[5] = artistas[3];
        artistas[6] = artistas[1];
        artistas[7] = "Legião Urbana";

    }

    public String[] getArtistas(){
        return artistas;
    }

    public void setCifra(String cifra) {
        this.cifra = cifra;
    }

    public String getCifra() {
        return cifra;
    }

    public void imprimirDetalhes() {
        lblNomeMusica = new JLabel("Título: " + nomeMusica);
        lblCompositor = new JLabel("Artista: " + compositor);
    }

    public void imprimirCifra() {
        lblNomeMusica = new JLabel("Título: " + nomeMusica);
        lblCompositor = new JLabel("Artista: " + compositor);
        lblCifra = new JLabel(cifra);
    }

}