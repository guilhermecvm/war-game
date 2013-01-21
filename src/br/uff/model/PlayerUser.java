package br.uff.model;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerUser extends PlayerAbstract {

    public PlayerUser(String name) {
        this.setName(name);
    }

    @Override
    public void play() {
        Scanner in = new Scanner(System.in);
        ArrayList<Card> cards = this.getCards();

        System.out.println("Você tem " + cards.size() + " cartas:");
        if (cards.size() > 0) {
            String strCards = "";
            int i = 0;
            for (Card card : cards) {
                strCards += i++ + ". " + card.toString() + ", ";
            }
            System.out.println(strCards.substring(0, strCards.length() - 2) + ".");
            if (cards.size() == 5) {
                System.out.println("Escolha as 3 cartas para trocar:");
                ArrayList<Card> trade = new ArrayList<Card>();
                trade.add(cards.get(in.nextInt()));
                trade.add(cards.get(in.nextInt()));
                trade.add(cards.get(in.nextInt()));
                this.tradeCards(trade);
            } else if(cards.size() >= 3){
                System.out.println("Deseja trocar cartas? (s/n)");
                String resp = in.nextLine();
                if (resp.trim().toUpperCase().equals("S")) {
                    System.out.println("Escolha as 3 cartas para trocar:");
                    ArrayList<Card> trade = new ArrayList<Card>();
                    trade.add(cards.get(in.nextInt()));
                    trade.add(cards.get(in.nextInt()));
                    trade.add(cards.get(in.nextInt()));
                    this.tradeCards(trade);
                }

            }

        }

        this.updateArmy();

        while (this.getArmyAvaiable() > 0) {
            System.out.println("Você tem " + this.getArmyAvaiable() + " reforços.");
            ArrayList<Favela> favelas = this.getFavelas();
            for (Favela favela : favelas) {
                System.out.println(favela.getName() + ": " + favela.getNumArmy() + " membros.");
            }
            Favela favelaReinforce = Data.favelas.get(in.nextInt());
            System.out.println("Quantos membros deseja alocar em " + favelaReinforce.getName() + "?");
            int reinforcements = in.nextInt();
            if (this.getArmyAvaiable() >= reinforcements) {
                this.setArmyAvaiable(this.getArmyAvaiable() - reinforcements);
                favelaReinforce.setNumArmy(favelaReinforce.getNumArmy() + reinforcements);
                System.out.println(reinforcements + " membros alocados em " + favelaReinforce.getName());
            }
        }

        System.out.println("Com qual país quer atacar?");
        Favela favelaAttack = Data.favelas.get(in.nextInt());
        //Confere se é o dono da região
        if (Data.player != favelaAttack.getPlayer()) {
            System.out.println("Você não é o dono da região selecionada");
            return;
        }

        System.out.println("Qual país quer atacar?");
        Favela favelaDefense = Data.favelas.get(in.nextInt());
        //Confere se faz divisa
        if (!favelaAttack.isNeighbour(favelaDefense)) {
            System.out.println("A região selecionada não faz divisa");
            return;
        }

        System.out.println("Atacando:" + favelaAttack.getName());
        System.out.println("Defendendo:" + favelaDefense.getName());
        System.out.println("Ataque # Num Army:" + favelaAttack.getNumArmy());
        System.out.println("Defesa # Num Army:" + favelaDefense.getNumArmy());
        System.out.println();

        System.out.println("Quantos soldados quer usar?");
        int attackQty = in.nextInt();
        //Confere se tem army suficiente (qtd selecionada < total na regiao e total na regiao > 1)
        if (!(attackQty < favelaAttack.getNumArmy() && favelaAttack.getNumArmy() > 1)) {
            System.out.println("Você não tem a quantidade de exercito escolhida ou não tem o mínimo para atacar (1)");
            return;
        }

        this.attack(favelaAttack, favelaDefense, attackQty);

        //Verifica se a região sob ataque ainda tem exército
        if (favelaDefense.getNumArmy() == 0) {
            System.out.println("Ataque tomou o terrório, escolha o número de soldados para passar");
            Boolean armyMoved = false;
            while (!armyMoved) {
                armyMoved = this.moveSoldiersAttack(favelaAttack, favelaDefense, in.nextInt());
            }
            Helper.takeFavela(this, favelaDefense);
        }
        this.buyCard();

    }
}
