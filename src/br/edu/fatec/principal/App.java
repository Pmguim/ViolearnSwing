package br.edu.fatec.principal;

import br.edu.fatec.telas.AddMusica;
import br.edu.fatec.telas.Splash;
import br.edu.fatec.telas.CriarPlaylist;

public class App {

    public static void main(String[] args){

        new Splash();
        new CriarPlaylist().montarJanela();
    }

}
