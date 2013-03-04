package br.uff.model;

import br.uff.controller.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper {

    public static int throwDice() {
        Random r = new Random();
        return r.nextInt(6) + 1; //0~5 + 1 = 1~6
    }

    public static boolean gameOver() {
        boolean over = true;
        for (Player p : Data.players.values()) {
            if(!p.getPossibleMoves().isEmpty() || p.getArmyAvaiable() > 0){
                over = false;
                break;
            }
        }
        return over;
    }

    public static void distributeFavelas() {
        List<Favela> favelas = new ArrayList<Favela>();
        favelas.addAll(Data.favelas.values());

        int qtyForPerson = favelas.size() / Data.players.size();
        int FavelaNumber;

        for (Player p : Data.players.values()) {
            for (int i = 0; i < qtyForPerson; i++) {
                FavelaNumber = (new Random()).nextInt(favelas.size());
                favelas.get(FavelaNumber).setPlayer(p);
                favelas.remove(FavelaNumber);
            }
        }

        int i = 1;
        for (Favela r : favelas) {
            Player p = Data.players.get(i);
            r.setPlayer(p);
            i++;
        }
    }

    public static boolean hasArmy(Favela favela, int qtyArmy) {
        // Confere se tem army suficiente (qtd selecionada < total na regiao e total na regiao > 1)
        if ((favela.getNumArmy() - qtyArmy) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int numberOfBonusArmy() {
        int current_trade = Main.get_card_trades() + 1;
        int resp = 0;
        switch (current_trade) {
            case 1: {
                resp = Card.FIRST_TRADE_BONUS;
                break;
            }
            case 2: {
                resp = Card.SECOND_TRADE_BONUS;
                break;
            }
            case 3: {
                resp = Card.THIRD_TRADE_BONUS;
                break;
            }
            case 4: {
                resp = Card.FOURTH_TRADE_BONUS;
                break;
            }
            case 5: {
                resp = Card.FIFTH_TRADE_BONUS;
                break;
            }
            case 6: {
                resp = Card.SIXTH_TRADE_BONUS;
                break;
            }
            default: {
                int delta = current_trade - 6;
                resp = Card.SIXTH_TRADE_BONUS + 5 * delta;
            }
        }
        return resp;
    }

    public static void nextPlayer() {
        Player player;
        if (Data.player.getId() == Data.players.size()) {
            player = Data.players.get(1);
        } else {
            player = Data.players.get(Data.player.getId() + 1);
        }
        
        Data.player = player;
        
        Data.player.receiveRoundArmy();
		Data.status = Status.DISTRIBUTING;
		Data.attacking = null;
		Data.defending = null;
		Helper.eraseDice();
    }
    
    public static void eraseDice() {
		for (Dice dice : Data.dicesAttack.values()) {
			dice.setValue(0);
		}
		for (Dice dice : Data.dicesDefense.values()) {
			dice.setValue(0);
		}
	}
}
