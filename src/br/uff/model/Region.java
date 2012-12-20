package br.uff.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import sun.tools.tree.ThisExpression;

public class Region {

    private String name;
    private Continent continent;
    private Player player;
    private Integer numArmy;
    private ArrayList<Region> neighbourhood;

    public Region(String name, Continent continent, Player player) {
        this.name = name;
        this.continent = continent;
        continent.addRegion(this);
        this.player = player;
        this.numArmy = 1;
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
    
    //TODO: resolver para  quando num de regioes nao for multiplo do num de players
    public static void distributeRegions(){
        Map<Integer, Region> regions = Data.regions;
        Map<Integer, Player> players = Data.players;
        int qtyForPerson = regions.size()/players.size();
        int playerNumber = 1;
        int regionNumber;
        for(int i = 1; i == regions.size(); i+=qtyForPerson){
            for(int j = 1; j==qtyForPerson; j++){
                regionNumber = (new Random()).nextInt(regions.size());
                regions.get(regionNumber).setPlayer(players.get(playerNumber));
                regions.remove(regionNumber);
                playerNumber ++;
            }
        }
    }
}
