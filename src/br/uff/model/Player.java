package br.uff.model;

import java.util.ArrayList;

public interface Player {
	
	public String getName();
	public void setName(String name);
	public int getArmyAvaiable();
	public void setArmyAvaiable(int armyAvaiable);
	
	public void play();
	//attackQty = num soldados (sem incluir o que tem que ficar no território)
	public void attack(Region regionAttack, Region regionDefense, Integer attackQty);
	
	public ArrayList<Region> getRegions();
    public ArrayList<Region> getEnemyRegions();
    public ArrayList<Region[]> getPossibleMoves();
    public boolean moveSoldiersAttack(Region base, Region destination, Integer soldiersNumber);
}