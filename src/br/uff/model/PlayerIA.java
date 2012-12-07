package br.uff.model;

public class PlayerIA extends PlayerAbstract {
	
	public PlayerIA(String name) {
		this.setName(name);
	}

	@Override
	public void play() {
		System.out.println("IA jogando, código randomico para atacar");
		
		//chamar código randomico e inicializar valores
		Region regionAttack = Data.regions.get(1);
		Region regionDefense = Data.regions.get(2);
		int attackQty = 2;
		
		this.attack(regionAttack, regionDefense, attackQty);
	}
	
}
