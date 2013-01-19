package br.uff.model;

import java.util.ArrayList;

public interface Player {
	
	public String getName();
	public void setName(String name);
	public int getArmyAvaiable();
	public void setArmyAvaiable(int armyAvaiable);
	
	public void play();
	//attackQty = num soldados (sem incluir o que tem que ficar no território)
	public void attack(Favela FavelaAttack, Favela FavelaDefense, Integer attackQty);
	
	public ArrayList<Favela> getFavelas();
    public ArrayList<Favela> getEnemyFavelas();
    public ArrayList<Favela[]> getPossibleMoves();
    public boolean moveSoldiersAttack(Favela base, Favela destination, Integer soldiersNumber);
}