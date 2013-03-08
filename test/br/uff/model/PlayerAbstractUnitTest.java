/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Schettino
 */
public class PlayerAbstractUnitTest {
    
    public PlayerAbstractUnitTest() {
    }

    @Test
    public void testPlayerUser() {
        PlayerUser humano = new PlayerUser("Humano", "imagem");
        assertEquals(humano.isIa(), false);
    }

    @Test
    public void testPlayerIA() {
        PlayerIA ia = new PlayerIA("IA", "imagem");
        assertEquals(ia.isIa(), true);
    }

    @Test
    public void testGetId() {
        PlayerIA ia = new PlayerIA("IA", "imagem");
        int id = Data.players.size() + 1;
        assertEquals(ia.getId(), id);
    }

    @Test
    public void testSetId() {
        PlayerIA ia = new PlayerIA("IA", "imagem");
        int id = 99;
        ia.setId(id);
        assertEquals(ia.getId(), id);
    }

    @Test
    public void testGetName() {
        String name = "IA";
        PlayerIA ia = new PlayerIA(name, "imagem");
        assertEquals(ia.getName(), name);
    }

    @Test
    public void testSetName() {
        String name = "IA";
        PlayerIA ia = new PlayerIA(name, "imagem");
        String newName = "IA";
        ia.setName(newName);
        assertEquals(ia.getName(), newName);
    }

    @Test
    public void testGetImg() {
        String img = "imagem";
        PlayerIA ia = new PlayerIA("IA", img);
        assertEquals(ia.getImg(), img);
    }

    @Test
    public void testSetImg() {
        String img = "imagem";
        PlayerIA ia = new PlayerIA("IA", img);
        String newImg = "imagem";
        ia.setImg(newImg);
        assertEquals(ia.getImg(), newImg);
    }

    @Test
    public void testGetArmyAvaiable() {
        String img = "imagem";
        PlayerIA ia = new PlayerIA("IA", img);
        assertEquals(ia.getArmyAvaiable(), 0);
    }

    @Test
    public void testSetArmyAvaiable() {
        String img = "imagem";
        PlayerIA ia = new PlayerIA("IA", img);
        int army = 2;
        ia.setArmyAvaiable(army);
        assertEquals(ia.getArmyAvaiable(), army);
    }
}
