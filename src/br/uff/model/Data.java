package br.uff.model;

import java.util.HashMap;
import java.util.Map;

public class Data {
	public static Player player;
	
    public static Favela attacking = null;
	public static Favela defending = null;
        
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
		favelas.put(4, new Favela("Zona Oeste 1", continents.get(1), "zonaOeste1.png"));
                
		favelas.put(5, new Favela("Baixada 1", continents.get(2), "baixada1.png"));
		favelas.put(6, new Favela("Baixada 2", continents.get(2), "baixada2.png"));
		favelas.put(7, new Favela("Baixada 3", continents.get(2), "baixada3.png"));
		favelas.put(8, new Favela("Baixada 4", continents.get(2), "baixada4.png"));
		favelas.put(9, new Favela("Baixada 5", continents.get(2), "baixada5.png"));
		favelas.put(10, new Favela("Baixada 6", continents.get(2), "baixada6.png"));
		favelas.put(11, new Favela("Baixada 7", continents.get(2), "baixada7.png"));
		favelas.put(12, new Favela("Baixada 8", continents.get(2), "baixada8.png"));
		favelas.put(13, new Favela("Baixada 9", continents.get(2), "baixada9.png"));
                
		favelas.put(14, new Favela("Avenida 1", continents.get(3), "avenida1.png"));
		favelas.put(15, new Favela("Avenida 2", continents.get(3), "avenida2.png"));
		favelas.put(16, new Favela("Vila Cruzeiro", continents.get(3), "vilaCruzeiro.png"));
		favelas.put(17, new Favela("Avenida 4", continents.get(3), "avenida4.png"));
		favelas.put(18, new Favela("Agua Santa", continents.get(3), "aguaSanta.png"));
		favelas.put(19, new Favela("Avenida 6", continents.get(3), "avenida6.png"));
		favelas.put(20, new Favela("Jacarezinho", continents.get(3), "jacarezinho.png"));
                
		favelas.put(21, new Favela("Zona Norte 2", continents.get(4), "zonaNorte2.png"));
		favelas.put(22, new Favela("Zona Norte 1", continents.get(4), "zonaNorte1.png"));
		favelas.put(23, new Favela("Morro do Macaco", continents.get(4), "morro do macaco.png"));
     	favelas.put(24, new Favela("Zona Norte 4", continents.get(4), "zonaNorte4.png"));
     	favelas.put(25, new Favela("Zona Norte 5", continents.get(4), "zonaNorte5.png"));
     	favelas.put(26, new Favela("Nova Holanda", continents.get(4), "novaHolanda.png"));
     	favelas.put(27, new Favela("Zona Norte 3", continents.get(4), "zonaNorte3.png"));
     	favelas.put(28, new Favela("Sao Carlos", continents.get(4), "saoCarlos.png"));
     	favelas.put(29, new Favela("Nova Esperanca", continents.get(4), "novaEsperanca.png"));
     	favelas.put(30, new Favela("Mangueira", continents.get(4), "mangueira.png"));
     	favelas.put(31, new Favela("Salgueiro", continents.get(4), "salgueiro.png"));
            
     	favelas.put(32, new Favela("Central 1", continents.get(5), "central1.png"));
     	favelas.put(33, new Favela("Providencia", continents.get(5), "providencia.png"));
     	favelas.put(34, new Favela("Coroa", continents.get(5), "coroa.png"));
     	favelas.put(35, new Favela("Central 2", continents.get(5), "central2.png"));
            
     	favelas.put(36, new Favela("Pavao Pavaozinho", continents.get(6), "pavaoPavaozinho.png"));
     	favelas.put(37, new Favela("Chapeu Mangueira", continents.get(6), "chapeuMangueira.png"));
     	favelas.put(38, new Favela("Cantagalo", continents.get(6), "cantagalo.png"));
     	favelas.put(39, new Favela("Dona Marta", continents.get(6), "donaMarta.png"));
     	favelas.put(40, new Favela("Vidigal", continents.get(6), "vidigal.png"));
     	favelas.put(41, new Favela("Rocinha", continents.get(6), "rocinha.png"));

	
		//Set Position
		favelas.get(1).setPosition(146, 236);
		favelas.get(2).setPosition(113, 292);
		favelas.get(3).setPosition(48, 257);
		favelas.get(4).setPosition(36, 209);
		favelas.get(5).setPosition(110, 155);
		favelas.get(6).setPosition(43, 107);
		favelas.get(7).setPosition(136, 98);
		favelas.get(8).setPosition(176, 47);
		favelas.get(9).setPosition(143, 8);
		favelas.get(10).setPosition(140, 42);
		favelas.get(11).setPosition(101, 34);
		favelas.get(12).setPosition(71, 9);
		favelas.get(13).setPosition(46, 34);
		favelas.get(14).setPosition(240, 18);
		favelas.get(15).setPosition(263, 18);
		favelas.get(16).setPosition(322, 15);
		favelas.get(17).setPosition(282, 108);
		favelas.get(18).setPosition(251, 139);
		favelas.get(19).setPosition(338, 153);
		favelas.get(20).setPosition(349, 49);
		favelas.get(21).setPosition(408, 89);
		favelas.get(22).setPosition(392, 179);
		favelas.get(23).setPosition(400, 159);
		favelas.get(24).setPosition(453, 70);
		favelas.get(25).setPosition(427, 23);
		favelas.get(26).setPosition(478, 34);
		favelas.get(27).setPosition(430, 71);
		favelas.get(28).setPosition(533, 164);
		favelas.get(29).setPosition(522, 76);
		favelas.get(30).setPosition(490, 121);
		favelas.get(31).setPosition(475, 215);
		favelas.get(32).setPosition(562, 165);
		favelas.get(33).setPosition(587, 153);
		favelas.get(34).setPosition(565, 218);
		favelas.get(35).setPosition(617, 179);
		favelas.get(36).setPosition(609, 416);
		favelas.get(37).setPosition(607, 304);
		favelas.get(38).setPosition(485, 359);
		favelas.get(39).setPosition(491, 321);
		favelas.get(40).setPosition(429, 431);
		favelas.get(41).setPosition(327, 392);
		
		//Fica em loop? Da problema?
		favelas.get(1).addNeighbourhood(new Favela[] {favelas.get(2), favelas.get(3),favelas.get(4) });
		favelas.get(2).addNeighbourhood(new Favela[] {favelas.get(1), favelas.get(3)});
		favelas.get(3).addNeighbourhood(new Favela[] {favelas.get(1), favelas.get(2), favelas.get(4)});
		favelas.get(4).addNeighbourhood(new Favela[] {favelas.get(1), favelas.get(3), favelas.get(5)});
	}
	
	public static Map <Integer, Dice> dicesAttack = new HashMap<Integer, Dice>();
	static {
		dicesAttack.put(1, new Dice("", 10, 0, 0));
		dicesAttack.put(2, new Dice("", 140, 0, 0));
		dicesAttack.put(3, new Dice("", 270, 0, 0));
	}
	
	public static Map <Integer, Dice> dicesDefense = new HashMap<Integer, Dice>();
	static {
		dicesDefense.put(1, new Dice("", 400, 0, 0));
		dicesDefense.put(2, new Dice("", 530, 0, 0));
		dicesDefense.put(3, new Dice("", 660, 0, 0));
	}
}