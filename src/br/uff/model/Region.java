package br.uff.model;

import java.util.ArrayList;
import java.util.List;

public class Region {

    private String name;
    private Continent continent;
    private Player player;
    private Integer numArmy;
    private ArrayList<Region> neighbourhood;
    private String img;
    private Integer x, y, x1, x2, y1, y2;

    public Region(String name, Continent continent, Player player, String img) {
        this.name = name;
        this.continent = continent;
        this.player = player;
        this.numArmy = 1;
        this.neighbourhood = new ArrayList<Region>();
        continent.addRegion(this);
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

    public void addNeighbour(Region region) {
        this.neighbourhood.add(region);
    }

    public boolean isNeighbour(Region region) {
        for (Region neighbour : this.neighbourhood) {
            if (neighbour == region) {
                return true;
            }
        }
        return false;
    }
    
    public List<Region> getNeighbourhood() {
        return neighbourhood;
    }
    
    public void setPosition(Integer x, Integer y, Integer x1, Integer x2, Integer y1, Integer y2) {
    	this.x = x;
    	this.y = y;
    	this.x1 = x1;
    	this.x2 = x2;
    	this.y1 = y1;
    	this.y2 = y2;
    }
    
	public Integer getX() {
		return x;
	}
	
	public Integer getY() {
		return y;
	}
	
	public Integer getX1() {
		return x1;
	}
	
	public Integer getX2() {
		return x2;
	}
	
	public Integer getY1() {
		return y1;
	}
	
	public Integer getY2() {
		return y2;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
