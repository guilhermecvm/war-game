/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import br.uff.model.PlayerAbstract;
import br.uff.model.PlayerUser;
import br.uff.model.PlayerIA;

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
    public void testPassTurn() {
        PlayerIA ia = (PlayerIA) Data.players.get(2);
        Data.player = ia;
        Data.counter = 1;
        ia.passTurn();
        assertEquals(Data.player, Data.players.get(3));
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
//
//    @Test
//    public void testInitDistribution() {
//        System.out.println("initDistribution");
//        PlayerAbstract instance = new PlayerAbstractImpl();
//        instance.initDistribution();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testReceiveRoundArmy() {
//        System.out.println("receiveRoundArmy");
//        PlayerAbstract instance = new PlayerAbstractImpl();
//        instance.receiveRoundArmy();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testSendArmyTo() {
//        System.out.println("sendArmyTo");
//        Favela destination = null;
//        int numArmy = 0;
//        PlayerAbstract instance = new PlayerAbstractImpl();
//        boolean expResult = false;
//        boolean result = instance.sendArmyTo(destination, numArmy);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetFavelas() {
//        System.out.println("getFavelas");
//        PlayerAbstract instance = new PlayerAbstractImpl();
//        ArrayList expResult = null;
//        ArrayList result = instance.getFavelas();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetEnemyFavelas() {
//        System.out.println("getEnemyFavelas");
//        PlayerAbstract instance = new PlayerAbstractImpl();
//        ArrayList expResult = null;
//        ArrayList result = instance.getEnemyFavelas();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetPossibleMoves() {
//        System.out.println("getPossibleMoves");
//        PlayerAbstract instance = new PlayerAbstractImpl();
//        ArrayList expResult = null;
//        ArrayList result = instance.getPossibleMoves();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testAttack() {
//        System.out.println("attack");
//        Favela favelaAttack = null;
//        Favela favelaDefense = null;
//        Integer attackQty = null;
//        PlayerAbstract instance = new PlayerAbstractImpl();
//        instance.attack(favelaAttack, favelaDefense, attackQty);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testMoveSoldiersAttack() {
//        System.out.println("moveSoldiersAttack");
//        Favela base = null;
//        Favela destination = null;
//        Integer qtyArmy = null;
//        PlayerAbstract instance = new PlayerAbstractImpl();
//        boolean expResult = false;
//        boolean result = instance.moveSoldiersAttack(base, destination, qtyArmy);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    public class PlayerAbstractImpl extends PlayerAbstract {
//    }
}
