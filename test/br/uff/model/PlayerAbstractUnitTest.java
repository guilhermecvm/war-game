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
