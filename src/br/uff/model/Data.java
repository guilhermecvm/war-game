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
	
	public static Map <Integer, Favela> favelas = new HashMap<Integer, Favela>();
	static {
		favelas.put(1, new Favela("Rio das Pedras", continents.get(1), "rio.png"));
		favelas.put(2, new Favela("Gardenia", continents.get(1), "gardenia.png"));
		favelas.put(3, new Favela("Cidade de Deus", continents.get(1), "cidadeDeDeus.png"));
		
		//Set Position
		favelas.get(1).setPosition(145, 248);
		favelas.get(2).setPosition(110, 302);
		favelas.get(3).setPosition(45, 270);
		
		//Fica em loop? Da problema?
		favelas.get(1).addNeighbourhood(new Favela[] {favelas.get(2), favelas.get(3)});
		favelas.get(2).addNeighbourhood(new Favela[] {favelas.get(1), favelas.get(3)});
		favelas.get(3).addNeighbourhood(new Favela[] {favelas.get(1), favelas.get(2)});
	}

	public static Favela attacking = null;
	public static Favela defending = null;
	

}