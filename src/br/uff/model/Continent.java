package br.uff.model;

public class Continent {
	
	private String name;
	private Integer bonus;
	
	public Continent(String name, Integer bonus) {
		this.name = name;
		this.bonus = bonus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	
}
