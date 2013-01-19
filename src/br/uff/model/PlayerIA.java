package br.uff.model;

import java.util.ArrayList;
import java.util.Random;

public class PlayerIA extends PlayerAbstract {

    public PlayerIA(String name) {
        this.setName(name);
    }

    @Override
    public void play() {
        ArrayList<Favela[]> moves = this.getPossibleMoves();
        if (moves.size() < 1) {
            System.out.println("Este jogador não pode fazer nenhuma jogada.");
        } else {
            Random r = new Random();
            Favela[] move = moves.get(r.nextInt(moves.size()));
            Favela favelaAttack = move[0];
            Favela favelaDefense = move[1];
            int attackQty = r.nextInt(favelaAttack.getNumArmy()) + 1;
            System.out.println("Atacando da região " + favelaAttack.getName()
                    + " para a região " + favelaDefense.getName() + " com " + attackQty + " soldados.");

            this.attack(favelaAttack, favelaDefense, attackQty);
        }
    }
}
