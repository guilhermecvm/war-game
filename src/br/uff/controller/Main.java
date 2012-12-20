package br.uff.controller;

import java.util.Scanner;

import br.uff.model.Data;

public class Main {

    public static void main(String[] args) {
        while (true) {
            @SuppressWarnings("resource")
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