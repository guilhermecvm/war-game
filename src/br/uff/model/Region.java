package br.uff.model;

import java.util.ArrayList;
import java.util.List;

public class Region {

    private String name;
    private Continent continent;
    private Player player;
    private Integer numArmy;
    private List<Region> neighbourhood;

    public Region(String name, Continent continent, Player player, Integer numArmy) {
        this.name = name;
        this.continent = continent;
        this.player = player;
        this.numArmy = numArmy;
        this.neighbourhood = new ArrayList<Region>();
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

    public void setContinent(Continent continent) {
        this.continent = continent;
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
}
