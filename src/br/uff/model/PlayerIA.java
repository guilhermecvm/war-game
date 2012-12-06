package br.uff.model;

public class PlayerIA implements Player {
	
	private String name;
	
	public PlayerIA(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void attack(Region regionAttack, Region regionDefense, Integer attackQty) {
		// TODO Auto-generated method stub
		
	}
	
}
