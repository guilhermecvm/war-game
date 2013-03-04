package br.uff.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.uff.view.Game;
import java.util.Random;

public abstract class PlayerAbstract implements Player {

    private int id;
    private String name;
    private int armyAvaiable = 0;
    private boolean ia;
    private String img;
    private ArrayList<Card> cards = new ArrayList<Card>();

    public boolean isIa() {
        return ia;
    }

    public void setIa(boolean ia) {
        this.ia = ia;
    }

    @Override
    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public void buyCard() {
        Card card = Deck.getCards().remove(0);
        this.cards.add(card);
        System.out.println("Comprou carta " + card);
    }

    @Override
    public void passTurn() {
        Data.player = Data.players.get((++Data.counter % Data.players.size()) + 1);
    }

    @Override
    public boolean canTradeCards() {
        if (this.cards.size() < 3) {
            return false;
        } else {
            int type_circle_count = 0;
            int type_square_count = 0;
            int type_triangle_count = 0;
            for (Card card : this.cards) {
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

            if ((type_circle_count == 3 || type_square_count == 3 || type_triangle_count == 3) || (type_circle_count == 1 && type_square_count == 1 && type_triangle_count == 1)) {
                return true;
            } else {
                return false;
            }

        }
    }

    @Override
    public void tradeCards(ArrayList<Card> cards) {
        if (cards.size() != 3) {
        } else {
            int type_circle_count = 0;
            int type_square_count = 0;
            int type_triangle_count = 0;
            for (Card card : cards) {
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

            if ((type_circle_count == 3 || type_square_count == 3 || type_triangle_count == 3) || (type_circle_count == 1 && type_square_count == 1 && type_triangle_count == 1)) {
                for (Card card : cards) {
                    this.cards.remove(card);
                }
                this.armyAvaiable = Helper.numberOfBonusArmy();
                Data.increment_card_trades();
            }
        }
    }

    @Override
    public void initDistribution() {
        ArrayList<Favela> favelas = this.getFavelas();
        while (this.getArmyAvaiable() > 0) {
            Random r = new Random();
            int i = r.nextInt(favelas.size());
            Favela favelaReinforce = favelas.get(i);
            int reinforcements = 1;
            this.setArmyAvaiable(this.getArmyAvaiable() - reinforcements);
            favelaReinforce.setNumArmy(favelaReinforce.getNumArmy() + reinforcements);
        }

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getArmyAvaiable() {
        return armyAvaiable;
    }

    @Override
    public void setArmyAvaiable(int armyAvaiable) {
        this.armyAvaiable = armyAvaiable;
    }

    @Override
    public String getImg() {
        return img;
    }

    @Override
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public void receiveRoundArmy() {
        int numberOfFavelas = this.getFavelas().size();

        // Aumenta army para distribuir de acordo com favelas dominadas
        if (numberOfFavelas <= 6) {
            this.setArmyAvaiable(this.getArmyAvaiable() + 3);
        } else {
            this.setArmyAvaiable(this.getArmyAvaiable() + numberOfFavelas / 2);
        }

        // Aumenta army para distribuir caso seja dono de um continente
        for (Continent cont : Data.continents.values()) {
            if (this.getFavelas().containsAll(cont.getFavelas())) {
                this.setArmyAvaiable(this.getArmyAvaiable() + cont.getFavelas().size() / 2);
            }
        }
    }

    @Override
    public boolean sendArmyTo(Favela destination, int numArmy) {
        if (this.getFavelas().contains(destination) && this.getArmyAvaiable() >= numArmy) {
            destination.setNumArmy(destination.getNumArmy() + numArmy);
            this.setArmyAvaiable(this.getArmyAvaiable() - numArmy);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Favela> getFavelas() {
        // Retorna todas as regiões que eu estou dominando no momento
        ArrayList<Favela> favelas = new ArrayList<Favela>();
        Favela favela;
        for (int i = 1; i <= Data.favelas.size(); i++) {
            favela = Data.favelas.get(i);

            if ((favela.getPlayer() != null) && favela.getPlayer().equals(this)) {
                favelas.add(favela);
            }
        }

        return favelas;
    }

    @Override
    public ArrayList<Favela> getEnemyFavelas() {
        // Retorna todas as regiões que eu NÃO estou dominando no momento
        ArrayList<Favela> favelas = new ArrayList<Favela>();
        Favela reg;
        for (int i = 1; i <= Data.favelas.size(); i++) {
            reg = Data.favelas.get(i);
            if ((reg.getPlayer() != null) && !reg.getPlayer().equals(this)) {
                favelas.add(reg);
            }
        }

        return favelas;
    }

    @Override
    public ArrayList<Favela[]> getPossibleMoves() {
        // Retorna todas as minhas possíveis jogadas
        // Uma jogada é possível desde que uma região minha tenha mais de 1
        // membro
        // e que a região vizinha seja de um inimigo
        ArrayList<Favela[]> moves = new ArrayList<Favela[]>();
        ArrayList<Favela> myFavelas = this.getFavelas();

        for (int i = 0; i < myFavelas.size(); i++) {
            Favela myFavela = myFavelas.get(i);
            ArrayList<Favela> neigbourhood = (ArrayList<Favela>) myFavela.getNeighbourhood();
            if (myFavela.getNumArmy() > 1) {
                for (int j = 0; j < neigbourhood.size(); j++) {
                    Favela neigbour = neigbourhood.get(j);
                    if (!neigbour.getPlayer().equals(this)) {
                        Favela[] move = {myFavela, neigbour};
                        moves.add(move);
                    }
                }
            }
        }
        return moves;
    }

    @Override
    public void attack(Favela favelaAttack, Favela favelaDefense, Integer attackQty) {
        List<Integer> diceAttack = new ArrayList<Integer>();
        List<Integer> diceDefense = new ArrayList<Integer>();

        // Total exército defesa
        Integer defenseQty = favelaDefense.getNumArmy();

        // Regras
        if (!Helper.hasArmy(favelaAttack, attackQty)) {
            throw new Error("Você não tem a quantidade de membros escolhida ou não tem o mínimo para atacar (1)");
        }

        // Máximo de 3 para ataque e defesa
        if (attackQty > 3) {
            attackQty = 3;
        }
        if (defenseQty > 3) {
            defenseQty = 3;
        }



        // Joga Dados Ataque (total escolhido)
        for (int i = 0; i < attackQty; i++) {
            diceAttack.add(Helper.throwDice());
        }

        // Joga dados Defesa (total no pais)
        for (int i = 0; i < defenseQty; i++) {
            diceDefense.add(Helper.throwDice());
        }

        // Ordena do maior pro menor
        Collections.sort(diceAttack, Collections.reverseOrder());
        Collections.sort(diceDefense, Collections.reverseOrder());

        // Mostra Resultado dos Dados do Ataque
        System.out.println("Ataque");
        for (int i = 0; i < attackQty; i++) {
            System.out.print(diceAttack.get(i) + ",");
            Data.dicesAttack.get(i + 1).setValue(diceAttack.get(i));
        }

        System.out.println();
        // Mostra Resultado dos Dados da Defesa
        System.out.println("Defesa");
        for (int i = 0; i < defenseQty; i++) {
            System.out.print(diceDefense.get(i) + ",");
            Data.dicesDefense.get(i + 1).setValue(diceDefense.get(i));
        }

        System.out.println();
        System.out.println();

        // Número de dados para ser comparado = menor número de membros
        Integer nDados = (attackQty > defenseQty) ? defenseQty : attackQty;

        // Compara Dados (maior com maior)
        for (int i = 0; i < nDados; i++) {
            if ((int) diceAttack.get(i) > (int) diceDefense.get(i)) {
                // Ataque venceu: reduz tropa da defesa
                favelaDefense.setNumArmy(favelaDefense.getNumArmy() - 1);
                System.out.println("Ataque Maior: " + diceAttack.get(i) + " > " + diceDefense.get(i));
            } else {
                // Defesa venceu: reduz tropa do ataque
                favelaAttack.setNumArmy(favelaAttack.getNumArmy() - 1);
                System.out.println("Defesa Maior: " + diceDefense.get(i) + " >= " + diceAttack.get(i));
            }
        }
    }

    @Override
    public boolean moveSoldiersAttack(Favela base, Favela destination, Integer qtyArmy) {
        if (Helper.hasArmy(base, qtyArmy)) {
            base.setNumArmy(base.getNumArmy() - qtyArmy);
            destination.setNumArmy(destination.getNumArmy() + qtyArmy);
            destination.setPlayer(this);
            System.out.println("Membros enviados a nova favela com sucesso.");
            return true;
        }
        System.out.println("Número de membros inválido. Deve ter pelo menos 1 membro tomando conta da base antiga! Digite novamente:");
        System.out.println("Origem: " + base.getName() + " => " + base.getNumArmy() + " membros.");

        return false;
    }
}
