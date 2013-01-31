package br.uff.model;

import java.util.ArrayList;

public class Continent {
	
	private String name;
	private Integer bonus;
	private ArrayList<Favela> favelas;
	
	public Continent(String name, Integer bonus) {
		this.name = name;
		this.bonus = bonus;
		this.favelas = new ArrayList<Favela>();
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
	
	public ArrayList<Favela> getFavelas() {
        return favelas;
    }
    
    public void addFavela(Favela reg) {
        this.favelas.add(reg);
    }
}
