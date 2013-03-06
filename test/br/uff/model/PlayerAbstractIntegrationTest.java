/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Schettino
 */
public class PlayerAbstractIntegrationTest {

    public PlayerAbstractIntegrationTest() {
    }

    @Before
    public void setUp() {
        Data.deck = new Deck(Data.deck_init);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBuyCard() {
        Card card = Data.deck.getCards().get(0);
        PlayerIA ia = new PlayerIA("IA", "imagem");
        ia.buyCard();
        assertEquals(card, ia.getCards().get(ia.getCards().size() - 1));
    }

    @Test
    public void testCanTradeCards() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        Card card1 = new Card(Card.TYPE_CIRCLE, null, "imagem");
        Card card2 = new Card(Card.TYPE_SQUARE, null, "imagem");
        Card card3 = new Card(Card.TYPE_TRIANGLE, null, "imagem");
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card3);
        cards.add(card2);
        cards.add(card1);
        ia.setCards(cards);
        assertEquals(ia.canTradeCards(), true);
    }

    @Test
    public void testCanTradeCards2() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        Card card1 = new Card(Card.TYPE_CIRCLE, null, "imagem");
        Card card2 = new Card(Card.TYPE_CIRCLE, null, "imagem");
        Card card3 = new Card(Card.TYPE_CIRCLE, null, "imagem");
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card3);
        cards.add(card2);
        cards.add(card1);
        ia.setCards(cards);
        assertEquals(ia.canTradeCards(), true);
    }

    @Test
    public void testCanTradeCards3() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        Card card1 = new Card(Card.TYPE_CIRCLE, null, "imagem");
        Card card2 = new Card(Card.TYPE_TRIANGLE, null, "imagem");
        Card card3 = new Card(Card.TYPE_CIRCLE, null, "imagem");
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card3);
        cards.add(card2);
        cards.add(card1);
        ia.setCards(cards);
        assertEquals(ia.canTradeCards(), false);
    }

    @Test
    public void testTradeCards() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        Card card1 = new Card(Card.TYPE_CIRCLE, null, "imagem");
        Card card2 = new Card(Card.TYPE_CIRCLE, null, "imagem");
        Card card3 = new Card(Card.TYPE_CIRCLE, null, "imagem");
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card3);
        cards.add(card2);
        cards.add(card1);
        ia.setCards(cards);
        ia.setArmyAvaiable(0);
        Data.set_card_trades(0);
        ia.tradeCards(cards);
        assertEquals(ia.getCards().size(), 0);
        assertEquals(Data.get_card_trades(), 1);
        assertEquals(ia.getArmyAvaiable(), Card.FIRST_TRADE_BONUS);
    }

    @Test
    public void testReceiveRoundArmy() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        for (Favela f : Data.favelas.values()) {
            f.setPlayer(null);
        }
        for (int i = 1; i <= 6; i++) {
            Favela favela = Data.favelas.get(i + 3);
            favela.setPlayer(ia);
        }
        ia.setArmyAvaiable(0);
        ia.receiveRoundArmy();
        assertEquals(ia.getArmyAvaiable(), 3);
    }

    @Test
    public void testReceiveRoundArmy2() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        for (Favela f : Data.favelas.values()) {
            f.setPlayer(null);
        }
        for (int i = 1; i <= 8; i++) {
            Favela favela = Data.favelas.get(i + 3);
            favela.setPlayer(ia);
        }
        ia.setArmyAvaiable(0);
        ia.receiveRoundArmy();
        assertEquals(ia.getArmyAvaiable(), 4);
    }

    @Test
    public void testSendArmyTo() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        Favela destination = Data.favelas.get(1);
        destination.setPlayer(ia);
        destination.setNumArmy(0);
        int armyAv = 5;
        ia.setArmyAvaiable(armyAv);
        assertEquals(ia.sendArmyTo(destination, armyAv), true);
    }

    @Test
    public void testSendArmyTo2() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        Favela destination = Data.favelas.get(1);
        destination.setPlayer(ia);
        destination.setNumArmy(0);
        int armyAv = 5;
        ia.setArmyAvaiable(armyAv);
        assertEquals(ia.sendArmyTo(destination, armyAv + 1), false);
    }

    @Test
    public void testGetFavelas() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        for (Favela f : Data.favelas.values()) {
            f.setPlayer(null);
        }
        ArrayList<Favela> favelas = new ArrayList<Favela>();
        for (int i = 1; i <= 3; i++) {
            Favela favela = Data.favelas.get(i);
            favela.setPlayer(ia);
            favelas.add(favela);
        }
        assertEquals(ia.getFavelas(), favelas);
    }

    @Test
    public void testGetEnemyFavelas() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        PlayerIA ia2 = (PlayerIA) Data.players.get(3);
        for (Favela f : Data.favelas.values()) {
            f.setPlayer(null);
        }
        ArrayList<Favela> favelas = new ArrayList<Favela>();
        for (int i = 1; i <= 3; i++) {
            Favela favela = Data.favelas.get(i);
            favela.setPlayer(ia2);
            favelas.add(favela);
        }
        assertEquals(ia.getEnemyFavelas(), favelas);
    }

    @Test
    public void testGetPossibleMoves() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        PlayerIA ia2 = (PlayerIA) Data.players.get(3);
        for (Favela f : Data.favelas.values()) {
            f.setPlayer(null);
        }
        for (int i = 1; i <= 5; i++) {
            Favela favela = Data.favelas.get(i);
            favela.setPlayer(ia2);
        }
        Favela favela = Data.favelas.get(4);
        favela.setPlayer(ia);
        ArrayList<Favela[]> possibleMoves = ia.getPossibleMoves();
        Favela[] move = new Favela[2];
        move[0] = favela;
        move[1] = Data.favelas.get(1);
        assertEquals(possibleMoves.get(0)[0], move[0]);
        assertEquals(possibleMoves.get(0)[1], move[1]);
        move[0] = favela;
        move[1] = Data.favelas.get(3);
        assertEquals(possibleMoves.get(1)[0], move[0]);
        assertEquals(possibleMoves.get(1)[1], move[1]);
        move[0] = favela;
        move[1] = Data.favelas.get(5);
        assertEquals(possibleMoves.get(2)[0], move[0]);
        assertEquals(possibleMoves.get(2)[1], move[1]);
        assertEquals(possibleMoves.size(), 3);
    }

    @Test
    public void testMoveSoldiersAttack() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        for (Favela f : Data.favelas.values()) {
            f.setPlayer(null);
        }
        for (int i = 1; i <= 3; i++) {
            Favela favela = Data.favelas.get(i);
            favela.setPlayer(ia);
            favela.setNumArmy(5);
        }
        Favela base = Data.favelas.get(1);
        Favela destination = Data.favelas.get(3);
        destination.setNumArmy(0);
        ia.moveSoldiersAttack(base, destination, 3);
        assertEquals((int) destination.getNumArmy(), 3);
        assertEquals((int) base.getNumArmy(), 2);
    }
}
