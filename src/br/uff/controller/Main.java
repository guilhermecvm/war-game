package br.uff.controller;

import java.util.Scanner;

import br.uff.model.Data;

public class Main {
	
	public static void main(String[] args) {
		while (true) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			
			System.out.println("Qual player jogará agora?");
			Data.player = Data.players.get(in.nextInt());
			
			System.out.println();
			System.out.println("### Nova Rodada ###");
			System.out.println("Player: "+ Data.player.getName());
			
			Data.player.play();
		}
	}
}