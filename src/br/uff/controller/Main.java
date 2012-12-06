package br.uff.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.uff.model.Continent;
import br.uff.model.Player;
import br.uff.model.PlayerIA;
import br.uff.model.PlayerUser;
import br.uff.model.Region;

public class Main {
	
	private static Map <Integer, Continent> continents = new HashMap<Integer, Continent>();
	static {
		continents.put(1, new Continent("America do Sul", 10));
	}
	
	private static Map <Integer, Player> players = new HashMap<Integer, Player>();
	static {
		players.put(1, new PlayerUser("Player 1"));
		players.put(2, new PlayerIA("Player 2"));
	}
	
	private static Map <Integer, Region> regions = new HashMap<Integer, Region>();
	static {
		regions.put(1, new Region("Região 1", continents.get(1), players.get(1), 5));
		regions.put(2, new Region("Região 2", continents.get(1), players.get(2), 3));
		
		//Fica em loop? Da problema?
		regions.get(1).addNeighbour(regions.get(2));
		regions.get(2).addNeighbour(regions.get(1));
	}

	private static Player playerUser = players.get(1);
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("### Nova Rodada ###");
			System.out.println("Ataque # Num Army:" + regions.get(1).getNumArmy());
			System.out.println("Defesa # Num Army:" + regions.get(2).getNumArmy());
			System.out.println();
			
			Region regionAttack = regions.get(1);
			Region regionDefense = regions.get(2);
			
			playerUser.attack(regionAttack, regionDefense, in.nextInt());
		}
	}
}