package br.uff.model;

public interface Player {
	
	//attackQty = num soldados (sem incluir o que tem que ficar no território)
	public void attack(Region regionAttack, Region regionDefense, Integer attackQty);

}
