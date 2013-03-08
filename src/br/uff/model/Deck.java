/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Schettino
 */
public class Deck {

    private static ArrayList<Card> cards;

    public Deck(ArrayList<Card> cards) {
        Deck.cards = cards;
        Deck.shuffle();
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void setCards(ArrayList<Card> cards) {
        Deck.cards = cards;
    }

    public static void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(Deck.cards, new Random(seed));
    }
}
