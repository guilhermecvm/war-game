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
    private Integer x, y, x1, x2, y1, y2;
    
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
    
    public void setPosition(Integer x, Integer y) {
    	this.x = x;
    	this.y = y;
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
