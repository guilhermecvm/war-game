package br.uff.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper {
	
	public static int throwDice() {
		Random r = new Random();
		return r.nextInt(6) + 1; //0~5 + 1 = 1~6
	}
	
	public static void distributeRegions(){
        List<Region> regions = new ArrayList<Region>();
        regions.addAll(Data.regions.values());

        int qtyForPerson = regions.size() / Data.players.size();
        int regionNumber;
        
        for (Player p : Data.players.values()) {
            for (int i = 0; i < qtyForPerson; i++) {
                regionNumber = (new Random()).nextInt(regions.size());
                regions.get(regionNumber).setPlayer(p);
                regions.remove(regionNumber);
            }
        }
        
        int i = 1;
        for (Region r : regions) {
            Player p = Data.players.get(i);
            r.setPlayer(p);
            i++;
        }
    }
}
