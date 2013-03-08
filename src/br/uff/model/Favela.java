package br.uff.model;

import java.util.ArrayList;
import java.util.List;

public class Favela {

    private String name;
    private Continent continent;
    private Player player;
    private Integer numArmy;
    private ArrayList<Favela> neighbourhood;
    private String img;
    private Integer x, y, armyX, armyY;
    
    public Favela(String name, Continent continent, String img) {
        this.name = name;
        this.continent = continent;
        this.player = null;
        this.numArmy = 1;
        this.neighbourhood = new ArrayList<Favela>();
        continent.addFavela(this);
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
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

    public void addNeighbourhood(Favela[] favelas) {
    	for (Favela favela : favelas) {
    		this.neighbourhood.add(favela);
    	}
    }

    public boolean isNeighbour(Favela favela) {
        for (Favela neighbour : this.neighbourhood) {
            if (neighbour == favela) {
                return true;
            }
        }
        return false;
    }
    
    public List<Favela> getNeighbourhood() {
        return neighbourhood;
    }
    
    public void setPosition(Integer x, Integer y, Integer armyX, Integer armyY) {
    	this.x = x;
    	this.y = y;
    	this.armyX = armyX;
    	this.armyY = armyY;
    }
    
	public Integer getX() {
		return x;
	}
	
	public Integer getY() {
		return y;
	}
	
	public Integer getArmyX() {
		return armyX;
	}
	
	public Integer getArmyY() {
		return armyY;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
