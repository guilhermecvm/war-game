package br.uff.controller;

import java.util.Scanner;

import br.uff.model.Data;
import br.uff.model.Deck;
import br.uff.model.Helper;

public class Main {
    

    private static int CARD_TRADES = 0;
    
    public static void increment_card_trades(){
        CARD_TRADES++;
    }
    
    public static int get_card_trades(){
        return CARD_TRADES;
    }
    
    
    public static void main(String[] args) {
    	//Distribui Regiões para os players no inicio do jogo
    	Helper.distributeFavelas();
        Deck deck = new Deck(Data.deck);
    	
        while (true) {
            Scanner in = new Scanner(System.in);

            System.out.println("Qual player jogará agora?");
            int nextPlayer = in.nextInt();
            if (nextPlayer != 0) {
                Data.player = Data.players.get(nextPlayer);

                System.out.println();
                System.out.println("### Nova Rodada ###");
                System.out.println("Player: " + Data.player.getName());

                Data.player.play();
            } else {
                System.out.println("Saindo do jogo...");
                System.exit(0);
            }
        }
    }
}