package br.edu.fatec.dados;

import javax.swing.*;
import java.util.Arrays;

public class Adicionar {

    Musica[] musicas;
    int tamanho;
    Musica believer, chocolate, cliche, come,
    dinheiro, flores, gostava, promessas, tempo;

    /*String believer, chocolate, clliche, come,
    dinheiro, flores, gostava, promessas, tempo;*/
    int codigo;
    JLabel label1;

    public Adicionar(int codigo) {
        this.codigo = codigo;
        this.tamanho = 0;
        this.musicas = new Musica[10];
    }

    public void adicionar(Musica novaMusica){
        this.tamanho = tamanho;
        if (tamanho == 10){
            JOptionPane.showMessageDialog(null, "A playlist não pode " +
                    "receber mais músicas pois está cheia.", "Playlist cheia.", JOptionPane.WARNING_MESSAGE);
        }
        else {
            musicas[tamanho] = novaMusica;
            tamanho++;
            JOptionPane.showMessageDialog(null, "A música foi adicionada com sucesso à playlist.");
        }
    }
}

    /*public void mostrar(){
        this.musicas = musicas;
        musicas[0] = believer;
        label1 = new JLabel(Arrays.toString(musicas));
    }*/

