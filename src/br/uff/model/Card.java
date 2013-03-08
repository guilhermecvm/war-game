/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.model;

/**
 *
 * @author Schettino
 */
public class Card {

    private int type;
    private Favela favela;
    private String img;
    public static final int TYPE_TRIANGLE = 1;
    public static final int TYPE_CIRCLE = 2;
    public static final int TYPE_SQUARE = 3;
    public static final int[] TYPES = {TYPE_TRIANGLE, TYPE_CIRCLE, TYPE_SQUARE};
    public static final int FIRST_TRADE_BONUS = 4;
    public static final int SECOND_TRADE_BONUS = 6;
    public static final int THIRD_TRADE_BONUS = 8;
    public static final int FOURTH_TRADE_BONUS = 10;
    public static final int FIFTH_TRADE_BONUS = 12;
    public static final int SIXTH_TRADE_BONUS = 15;

    public Card(int type, Favela favela, String img) {
        this.type = type;
        this.favela = favela;
        this.img = img;
    }

    @Override
    public String toString() {
        String resp = this.favela.getName() + " - tipo: ";
        switch (this.type) {
            case TYPE_TRIANGLE: {
                resp = "Triângulo";
                break;
            }
            case TYPE_CIRCLE: {
                resp = "Bola";
                break;
            }
            case TYPE_SQUARE: {
                resp = "Quadrado";
                break;
            }
        }
        return resp;
    }

    public int get_type() {
        return this.type;
    }
    
    public String getImage(){
        return this.img;
    }
}
