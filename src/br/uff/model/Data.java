package br.uff.model;

import java.util.HashMap;
import java.util.Map;

public class Data {
	public static Player player;
	
	public static Map <Integer, Continent> continents = new HashMap<Integer, Continent>();
	static {
		continents.put(1, new Continent("Zona Oeste", 10));
		continents.put(2, new Continent("Baixada", 10));
		continents.put(3, new Continent("Avenida Brasil", 10));
		continents.put(4, new Continent("Zona Norte", 10));
		continents.put(5, new Continent("Central", 10));
		continents.put(6, new Continent("Zona Sul", 10));
	}
	
	public static Map <Integer, Player> players = new HashMap<Integer, Player>();
	static {
		players.put(1, new PlayerUser("Player 1"));
		players.put(2, new PlayerIA("Player IA"));
	}
	
	public static Map <Integer, Region> regions = new HashMap<Integer, Region>();
	static {
		regions.put(1, new Region("Rio das Pedras", continents.get(1), "rio.png"));
		regions.put(2, new Region("Gardenia", continents.get(1), "gardenia.png"));
		regions.put(3, new Region("Cidade de Deus", continents.get(1), "cidadeDeDeus.png"));
		
		//Set Position
		regions.get(1).setPosition(145, 248);
		regions.get(2).setPosition(110, 302);
		
		//Fica em loop? Da problema?
		regions.get(1).addNeighbour(regions.get(2));
		regions.get(2).addNeighbour(regions.get(1));
	}

}