package br.uff.model;

import java.util.ArrayList;

public interface Player {

    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public int getArmyAvaiable();

    public void setArmyAvaiable(int armyAvaiable);

    public String getImg();

    public void setImg(String img);

    public void receiveRoundArmy();

    public boolean sendArmyTo(Favela destination, int numArmy);

    public ArrayList<Card> getCards();

    public void setCards(ArrayList<Card> cards);

    public void buyCard();

    public boolean canTradeCards();

    public void tradeCards(ArrayList<Card> cards);

    public void play();

    public void passTurn();
    //attackQty = num membros (sem incluir o que tem que ficar na favela)

    public void attack(Favela FavelaAttack, Favela FavelaDefense, Integer attackQty);

    public ArrayList<Favela> getFavelas();

    public ArrayList<Favela> getEnemyFavelas();

    public ArrayList<Favela[]> getPossibleMoves();

    public boolean moveSoldiersAttack(Favela base, Favela destination, Integer soldiersNumber);

    public boolean isIa();

    public void setIa(boolean ia);

    public void initDistribution();
}