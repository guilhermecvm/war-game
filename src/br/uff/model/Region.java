package br.uff.model;

public class Region {
	
	private String name;
	private Player player;
	private Integer numArmy;
	
	public Region(String name, Player player, Integer numArmy) {
		this.name = name;
		this.player = player;
		this.numArmy = numArmy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getNumArmy() {
		return numArmy;
	}

	public void setNumArmy(Integer numArmy) {
		this.numArmy = numArmy;
	}
	
}
