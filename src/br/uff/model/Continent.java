package br.uff.model;

import java.util.ArrayList;

public class Continent {
	
	private String name;
	private Integer bonus;
	private ArrayList<Region> regions;
	
	public Continent(String name, Integer bonus) {
		this.name = name;
		this.bonus = bonus;
		this.regions = new ArrayList<Region>();
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
	
	public ArrayList<Region> getRegions() {
        return regions;
    }
    
    public void addRegion(Region reg) {
        this.regions.add(reg);
    }
}
