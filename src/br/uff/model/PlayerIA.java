package br.uff.model;

import java.util.ArrayList;

public class PlayerIA extends PlayerAbstract {

    public PlayerIA(String name, String img) {
        this.setId(Data.players.size() + 1);
        this.setName(name);
        this.setImg(img);
        this.setIa(true);
    }

    @Override
    public void play() {
        this.distributeArmy();
        this.attackIntelligence();
        this.tradeCardsIntelligence();
        this.buyCard();
        Helper.nextPlayer();
    }
    
    private void distributeArmy() {
        System.out.println("Você tem " + this.getArmyAvaiable() + " reforços.");
        ArrayList<Favela> favelas = this.getFavelas();
        ArrayList<Favela> options = new ArrayList<Favela>();
        for (Favela favela : favelas) {
            System.out.println(favela.getName() + ": " + favela.getNumArmy() + " membros.");
            ArrayList<Favela> neighbourhood = (ArrayList<Favela>) favela.getNeighbourhood();

            for (Favela neighbour : neighbourhood) {
                if (neighbour.getPlayer() != this && neighbour.getNumArmy() > favela.getNumArmy()) {
                    options.add(favela);
                    break;
                }
            }
        }
        if (options.isEmpty()) {
            options = favelas;
        }
        int i = 0;
        while (this.getArmyAvaiable() > 0) {
            Favela favelaReinforce = options.get(i % options.size());
            int reinforcements = 1;
            this.setArmyAvaiable(this.getArmyAvaiable() - reinforcements);
            favelaReinforce.setNumArmy(favelaReinforce.getNumArmy() + reinforcements);
            System.out.println(reinforcements + " membros alocados em " + favelaReinforce.getName());
            i++;
        }

    }

    private void attackIntelligence() {
        ArrayList<Favela[]> moves = this.getPossibleMoves();
        if (moves.size() < 1) {
            System.out.println("Este jogador não pode fazer nenhuma jogada.");
        } else {
            ArrayList<Favela[]> options = new ArrayList<Favela[]>();

            for (Favela[] move : moves) {
                Favela favelaAttack = move[0];
                Favela favelaDefense = move[1];
                if (favelaAttack.getNumArmy() > favelaDefense.getNumArmy()) {
                    options.add(move);
                    break;
                }
            }
            if (options.isEmpty()) {
                Favela[] move = moves.get(0);
                Favela favelaAttack = move[0];
                Favela favelaDefense = move[1];
                int attackQty = favelaAttack.getNumArmy() - 1;
                this.attack(favelaAttack, favelaDefense, attackQty);
            } else {
                for (Favela[] move : options) {
                    Favela favelaAttack = move[0];
                    Favela favelaDefense = move[1];
                    while (favelaAttack.getNumArmy() > favelaDefense.getNumArmy() && favelaDefense.getPlayer() != this) {
                        int attackQty = favelaAttack.getNumArmy() - 1;
                        System.out.println("Atacando da região " + favelaAttack.getName()
                                + " para a região " + favelaDefense.getName() + " com " + attackQty + " membros.");
                        if (attackQty > 0) {
                            this.attack(favelaAttack, favelaDefense, attackQty);
                        }
                        if (favelaDefense.getNumArmy() == 0) {
                            System.out.println("Ataque tomou o terrório, escolha o número de membros para passar");
                            int moveQty = favelaAttack.getNumArmy() / 2;
                            this.moveSoldiersAttack(favelaAttack, favelaDefense, moveQty);
                            favelaDefense.setPlayer(this);
                        }
                    }
                }
            }
        }
    }

    private void tradeCardsIntelligence() {
        if (this.canTradeCards()) {
            boolean trade = true;
            for (Player p : Data.players.values()) {
                if (p != this && p.getCards().size() > this.getCards().size()) {
                    trade = false;
                    break;
                }

            }
            if (trade) {
                ArrayList<Card> tradingCards = new ArrayList<Card>();
                if (this.getCards().size() == 3) {
                    tradingCards = this.getCards();
                } else {
                    int type_circle_count = 0;
                    int type_square_count = 0;
                    int type_triangle_count = 0;
                    for (Card card : this.getCards()) {
                        switch (card.get_type()) {
                            case Card.TYPE_CIRCLE: {
                                type_circle_count++;
                                break;
                            }
                            case Card.TYPE_SQUARE: {
                                type_square_count++;
                                break;
                            }
                            case Card.TYPE_TRIANGLE: {
                                type_triangle_count++;
                                break;
                            }
                        }
                    }
                    if (type_circle_count >= 3) {
                        for (Card card : this.getCards()) {
                            if (card.get_type() == Card.TYPE_CIRCLE && tradingCards.size() < 3) {
                                tradingCards.add(card);
                            }
                        }
                    } else {
                        if (type_square_count >= 3) {
                            for (Card card : this.getCards()) {
                                if (card.get_type() == Card.TYPE_SQUARE && tradingCards.size() < 3) {
                                    tradingCards.add(card);
                                }
                            }
                        } else {
                            if (type_triangle_count >= 3) {
                                for (Card card : this.getCards()) {
                                    if (card.get_type() == Card.TYPE_TRIANGLE && tradingCards.size() < 3) {
                                        tradingCards.add(card);
                                    }
                                }
                            } else {
                                boolean circle_choosen = false;
                                boolean square_choosen = false;
                                boolean triangle_choosen = false;
                                for (Card card : this.getCards()) {
                                    if (tradingCards.size() < 3) {
                                        switch (card.get_type()) {
                                            case Card.TYPE_CIRCLE: {
                                                if (!circle_choosen) {
                                                    tradingCards.add(card);
                                                    circle_choosen = true;
                                                }
                                                break;
                                            }
                                            case Card.TYPE_SQUARE: {
                                                if (!square_choosen) {
                                                    tradingCards.add(card);
                                                    square_choosen = true;
                                                }
                                                break;
                                            }
                                            case Card.TYPE_TRIANGLE: {
                                                if (!triangle_choosen) {
                                                    tradingCards.add(card);
                                                    triangle_choosen = true;
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }

                }
                this.tradeCards(tradingCards);
            }
        }

    }
}
