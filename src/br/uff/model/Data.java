package br.uff.model;

import java.util.HashMap;
import java.util.Map;

public class Data {
	public static Player player;
	
	public static Map <Integer, Continent> continents = new HashMap<Integer, Continent>();
	static {
		continents.put(1, new Continent("America do Sul", 10));
	}
	
	public static Map <Integer, Player> players = new HashMap<Integer, Player>();
	static {
		players.put(1, new PlayerUser("Player 1"));
		players.put(2, new PlayerIA("Player IA"));
	}
	
	public static Map <Integer, Region> regions = new HashMap<Integer, Region>();
	static {
		regions.put(1, new Region("Região 1", continents.get(1), players.get(1)));
		regions.put(2, new Region("Região 2", continents.get(1), players.get(2)));
                
                regions.get(1).setNumArmy(5);
                regions.get(2).setNumArmy(3);
		
		//Fica em loop? Da problema?
		regions.get(1).addNeighbour(regions.get(2));
		regions.get(2).addNeighbour(regions.get(1));
	}

}