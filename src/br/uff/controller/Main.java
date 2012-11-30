package br.uff.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.uff.model.*;

public class Main {
	
	private static Map <Integer, Continent> continents = new HashMap<Integer, Continent>();
	static {
		continents.put(1, new Continent("America do Sul", 10);
	}
	
	private static Map <Integer, Player> players = new HashMap<Integer, Player>();
	static {
		players.put(1, new Player("Player 1"));
		players.put(2, new Player("Player 2"));
	}
	
	private static Map <Integer, Region> regions = new HashMap<Integer, Region>();
	static {
		regions.put(1, new Region("Região 1", continents.get(1), players.get(1), 2));
		regions.put(2, new Region("Região 2", continents.get(1), players.get(2), 3));
	}

	private static Player playerUser = players.get(1);
	
	public static void main(String[] args) {
		Main main = new Main();
		main.attack(1, 2, 1, 2);
	}
	
	public void attack(Integer regionIdA, Integer regionIdD, Integer armyType, Integer armyQty) {
		Region regionAttack = regions.get(regionIdA);
		Region regionDefense = regions.get(regionIdD);

		Player playerAttack = regionAttack.getPlayer();
		Player playerDefense = regionDefense.getPlayer();

		ArrayList diceAttack = new ArrayList();
		ArrayList diceDefense = new ArrayList();
		
		//Confere se é o dono da região
		if (playerUser == playerAttack) {
			//Confere se tem army suficiente
			if (armyQty <= regionAttack.getNumArmy()) {
				//Joga Dados Ataque (total escolhido)
				System.out.println("Ataque");
				for (int i=0; i < armyQty; i++) {
					diceAttack.add(throwDice());
					System.out.println(diceAttack.get(i));
				}
				//Joga dados Defesa (total no pais)
				System.out.println("Defesa");
				for (int i=0; i < regionDefense.getNumArmy(); i++) {
					diceDefense.add(throwDice());
					System.out.println(diceDefense.get(i));
				}
				
				//Compara Dados (mudar para comparar maior com maior)
				for (int i=0; i < armyQty; i++) {
					for (int j=0; j < regionDefense.getNumArmy(); j++) {
						if (Integer.parseInt(diceAttack.get(i).toString()) <= Integer.parseInt(diceDefense.get(j).toString()))
							diceAttack.remove(new Integer(i));
						if (Integer.parseInt(diceAttack.get(i).toString()) > Integer.parseInt(diceDefense.get(j).toString()))
							diceDefense.remove(new Integer(j));
					}
				}
				
				//Resultado das tropas
				System.out.println("Ataque");
				for (int i=0; i < armyQty; i++) {
					System.out.println(diceAttack.get(i));
				}
				System.out.println("Defesa");
				for (int i=0; i < regionDefense.getNumArmy(); i++) {
					System.out.println(diceDefense.get(i));
				}
			}
			else {
				System.out.println("Você não tem a quantidade de exercito escolhida");
			}
			
		}
		else {
			System.out.println("Você não é o dono da região selecionada");
		}
	}
	
	public int throwDice() {
		Random r = new Random();
		return r.nextInt(6) + 1; //0~5 + 1 = 1~6
	}

}
