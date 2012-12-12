package br.uff.model;

import java.util.ArrayList;
import java.util.Random;

public class PlayerIA extends PlayerAbstract {

    public PlayerIA(String name) {
        this.setName(name);
    }

    @Override
    public void play() {
        ArrayList<Region[]> moves = this.getPossibleMoves();
        if (moves.size() < 1) {
            System.out.println("Este jogador não pode fazer nenhuma jogada.");
        } else {
            Random r = new Random();
            Region[] move = moves.get(r.nextInt(moves.size()));
            Region regionAttack = move[0];
            Region regionDefense = move[1];
            int attackQty = r.nextInt(regionAttack.getNumArmy()) + 1;
            System.out.println("Atacando da região " + regionAttack.getName()
                    + " para a região " + regionDefense.getName() + " com " + attackQty + " soldados.");

            System.out.println("random " + r.nextInt(10));
            System.out.println("random " + r.nextInt(10));
            System.out.println("random " + r.nextInt(10));
            this.attack(regionAttack, regionDefense, attackQty);
        }
    }
}
