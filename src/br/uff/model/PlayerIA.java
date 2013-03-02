package br.uff.model;

import java.util.ArrayList;
import java.util.Random;

public class PlayerIA extends PlayerAbstract {

    public PlayerIA(String name, String img) {
    	this.setId(Data.players.size()+1);
        this.setName(name);
        this.setImg(img);
    }

    @Override
    public void play() {
        this.receiveRoundArmy();

        while (this.getArmyAvaiable() > 0) {
            System.out.println("Você tem " + this.getArmyAvaiable() + " reforços.");
            ArrayList<Favela> favelas = this.getFavelas();
            for (Favela favela : favelas) {
                System.out.println(favela.getName() + ": " + favela.getNumArmy() + " membros.");
            }
            Random r = new Random();
            Favela favelaReinforce = favelas.get(r.nextInt(favelas.size()));
            System.out.println("Quantos membros deseja alocar em " + favelaReinforce.getName() + "?");
            int reinforcements = r.nextInt(this.getArmyAvaiable()) + 1;
            if (this.getArmyAvaiable() >= reinforcements) {
                this.setArmyAvaiable(this.getArmyAvaiable() - reinforcements);
                favelaReinforce.setNumArmy(favelaReinforce.getNumArmy() + reinforcements);
                System.out.println(reinforcements + " membros alocados em " + favelaReinforce.getName());
            }
        }


        ArrayList<Favela[]> moves = this.getPossibleMoves();
        if (moves.size() < 1) {
            System.out.println("Este jogador não pode fazer nenhuma jogada.");
        } else {
            Random r = new Random();
            Favela[] move = moves.get(r.nextInt(moves.size()));
            Favela favelaAttack = move[0];
            Favela favelaDefense = move[1];
            int attackQty = r.nextInt(favelaAttack.getNumArmy() - 1) + 1;
            System.out.println("Atacando da região " + favelaAttack.getName()
                    + " para a região " + favelaDefense.getName() + " com " + attackQty + " membros.");

            this.attack(favelaAttack, favelaDefense, attackQty);

            if (favelaDefense.getNumArmy() == 0) {
                System.out.println("Ataque tomou o terrório, escolha o número de membros para passar");
                Boolean armyMoved = false;
                while (!armyMoved) {
                    armyMoved = this.moveSoldiersAttack(favelaAttack, favelaDefense, r.nextInt(favelaAttack.getNumArmy() - 1) + 1);
                }
                favelaDefense.setPlayer(this);
            }
        }
        this.buyCard();
    }
}
