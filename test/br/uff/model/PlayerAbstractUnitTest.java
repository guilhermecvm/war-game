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
}
