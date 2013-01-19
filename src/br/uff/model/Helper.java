package br.uff.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper {
	
	public static int throwDice() {
		Random r = new Random();
		return r.nextInt(6) + 1; //0~5 + 1 = 1~6
	}
	
	public static void distributeFavelas(){
        List<Favela> favelas = new ArrayList<Favela>();
        favelas.addAll(Data.favelas.values());

        int qtyForPerson = favelas.size() / Data.players.size();
        int FavelaNumber;
        
        for (Player p : Data.players.values()) {
            for (int i = 0; i < qtyForPerson; i++) {
                FavelaNumber = (new Random()).nextInt(favelas.size());
                favelas.get(FavelaNumber).setPlayer(p);
                favelas.remove(FavelaNumber);
            }
        }
        
        int i = 1;
        for (Favela r : favelas) {
            Player p = Data.players.get(i);
            r.setPlayer(p);
            i++;
        }
    }
	
	public static boolean hasArmy(Favela favela, int qtyArmy) {
		// Confere se tem army suficiente (qtd selecionada < total na regiao e total na regiao > 1)
		if ((favela.getNumArmy() - qtyArmy) > 0)
			return true;
		else
			return false;
	}
}
