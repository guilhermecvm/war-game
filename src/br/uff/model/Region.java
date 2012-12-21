package br.uff.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Region {

    private String name;
    private Continent continent;
    private Player player;
    private Integer numArmy;
    private ArrayList<Region> neighbourhood;

    public Region(String name, Continent continent, Player player) {
        this.name = name;
        this.continent = continent;
        this.player = player;
        this.numArmy = 1;
        this.neighbourhood = new ArrayList<Region>();
        continent.addRegion(this);
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
    
    public static void distributeRegions(){
        List<Region> regions = new ArrayList<Region>();
        regions.addAll(Data.regions.values());

        int qtyForPerson = regions.size()/Data.players.size();
        int regionNumber;
        
        for (Player p : Data.players.values()) {
            for (int i = 0; i < qtyForPerson; i++) {
                regionNumber = (new Random()).nextInt(regions.size());
                regions.get(regionNumber).setPlayer(p);
                regions.remove(regionNumber);
            }
        }
        
        int i = 1;
        for (Region r : regions) {
            Player p = Data.players.get(i);
            r.setPlayer(p);
            i++;
        }
    }
}
