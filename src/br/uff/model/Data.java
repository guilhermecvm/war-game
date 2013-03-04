package br.uff.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {

    public static Player player;
    public static Favela attacking = null;
    public static Favela defending = null;
    public static Status status = null;
    public static int counter = 0;
    public static Deck deck;
    private static int CARD_TRADES = 0;

    public static void increment_card_trades() {
        CARD_TRADES++;
    }

    public static int get_card_trades() {
        return CARD_TRADES;
    }
    public static Map<Integer, Continent> continents = new HashMap<Integer, Continent>();

    static {
        continents.put(1, new Continent("Zona Oeste", 10));
        continents.put(2, new Continent("Baixada", 10));
        continents.put(3, new Continent("Avenida Brasil", 10));
        continents.put(4, new Continent("Zona Norte", 10));
        continents.put(5, new Continent("Central", 10));
        continents.put(6, new Continent("Zona Sul", 10));
    }
    public static Map<Integer, Player> players = new HashMap<Integer, Player>();

    static {
        players.put(1, new PlayerUser("Player 1", "blueArmy.png"));
//        players.put(1, new PlayerIA("Player 1", "blueArmy.png"));
        players.put(2, new PlayerIA("Player IA", "greenArmy.png"));
        players.put(3, new PlayerIA("Player IA2", "blackArmy.png"));
    }
    public static Map<Integer, Favela> favelas = new HashMap<Integer, Favela>();

    static {
        favelas.put(1, new Favela("Rio das Pedras", continents.get(1), "rio.png"));
        favelas.put(2, new Favela("Gardenia", continents.get(1), "gardenia.png"));
        favelas.put(3, new Favela("Cidade de Deus", continents.get(1), "cidadeDeDeus.png"));
        favelas.put(4, new Favela("Nova Aurora", continents.get(1), "zonaOeste1.png"));
        favelas.get(1).setPosition(167, 361, 257, 488);
        favelas.get(2).setPosition(119, 422, 164, 471);
        favelas.get(3).setPosition(32, 376, 98, 480);
        favelas.get(4).setPosition(20, 314, 65, 374);
        favelas.put(5, new Favela("Covanca", continents.get(2), "baixada1.png"));
        favelas.put(6, new Favela("Jardim Sulacap", continents.get(2), "baixada2.png"));
        favelas.put(7, new Favela("Morro do Fubá", continents.get(2), "baixada3.png"));
        favelas.put(8, new Favela("Serrinha", continents.get(2), "baixada4.png"));
        favelas.put(9, new Favela("Rocha Miranda", continents.get(2), "baixada5.png"));
        favelas.put(10, new Favela("Vila Santa", continents.get(2), "baixada6.png"));
        favelas.put(11, new Favela("Bento Ribeiro", continents.get(2), "baixada7.png"));
        favelas.put(12, new Favela("Honório Gurgel", continents.get(2), "baixada8.png"));
        favelas.put(13, new Favela("Vila Eugenia", continents.get(2), "baixada9.png"));
        favelas.get(5).setPosition(113, 242, 0, 0);
        favelas.get(6).setPosition(29, 181, 0, 0);
        favelas.get(7).setPosition(150, 170, 0, 0);
        favelas.get(8).setPosition(202, 102, 0, 0);
        favelas.get(9).setPosition(159, 52, 0, 0);
        favelas.get(10).setPosition(155, 95, 0, 0);
        favelas.get(11).setPosition(105, 87, 0, 0);
        favelas.get(12).setPosition(66, 53, 0, 0);
        favelas.get(13).setPosition(33, 85, 0, 0);
        favelas.put(14, new Favela("Morro do Juramento", continents.get(3), "avenida1.png"));
        favelas.put(15, new Favela("Tomás Coelho", continents.get(3), "avenida2.png"));
        favelas.put(16, new Favela("Vila Cruzeiro", continents.get(3), "vilaCruzeiro.png"));
        favelas.put(17, new Favela("Morro do Trajano", continents.get(3), "avenida4.png"));
        favelas.put(18, new Favela("Agua Santa", continents.get(3), "aguaSanta.png"));
        favelas.put(19, new Favela("Borda do Mato", continents.get(3), "avenida6.png"));
        favelas.put(20, new Favela("Jacarezinho", continents.get(3), "jacarezinho.png"));

        favelas.get(14).setPosition(285, 66, 0, 0);
        favelas.get(15).setPosition(315, 66, 0, 0);
        favelas.get(16).setPosition(392, 61, 417, 82);
        favelas.get(17).setPosition(340, 183, 0, 0);
        favelas.get(18).setPosition(298, 221, 364, 321);
        favelas.get(19).setPosition(413, 238, 0, 0);
        favelas.get(20).setPosition(427, 106, 482, 179);
        favelas.put(21, new Favela("Higienópolis", continents.get(4), "zonaNorte2.png"));
        favelas.put(22, new Favela("Morro do Borel", continents.get(4), "zonaNorte1.png"));
        favelas.put(23, new Favela("Morro do Macaco", continents.get(4), "morro do macaco.png"));
        favelas.put(24, new Favela("Vila do João", continents.get(4), "zonaNorte4.png"));
        favelas.put(25, new Favela("Parque União", continents.get(4), "zonaNorte5.png"));
        favelas.put(26, new Favela("Nova Holanda", continents.get(4), "novaHolanda.png"));
        favelas.put(27, new Favela("Oswaldo Cruz", continents.get(4), "zonaNorte3.png"));
        favelas.put(28, new Favela("Sao Carlos", continents.get(4), "saoCarlos.png"));
        favelas.put(29, new Favela("Nova Esperanca", continents.get(4), "novaEsperanca.png"));
        favelas.put(30, new Favela("Mangueira", continents.get(4), "mangueira.png"));
        favelas.put(31, new Favela("Salgueiro", continents.get(4), "salgueiro.png"));

        favelas.get(21).setPosition(503, 158, 0, 0);
        favelas.get(22).setPosition(482, 275, 0, 0);
        favelas.get(23).setPosition(495, 248, 554, 277);
        favelas.get(24).setPosition(561, 132, 0, 0);
        favelas.get(25).setPosition(528, 72, 0, 0);
        favelas.get(26).setPosition(595, 87, 621, 151);
        favelas.get(27).setPosition(531, 134, 0, 0);
        favelas.get(28).setPosition(665, 256, 685, 296);
        favelas.get(29).setPosition(651, 141, 700, 176);
        favelas.get(30).setPosition(609, 199, 633, 290);
        favelas.get(31).setPosition(591, 322, 660, 358);
        favelas.put(32, new Favela("Mineira", continents.get(5), "central1.png"));
        favelas.put(33, new Favela("Providencia", continents.get(5), "providencia.png"));
        favelas.put(34, new Favela("Morro da Coroa", continents.get(5), "coroa.png"));
        favelas.put(35, new Favela("Baronesa", continents.get(5), "central2.png"));

        favelas.get(32).setPosition(704, 257, 0, 0);
        favelas.get(33).setPosition(735, 242, 787, 250);
        favelas.get(34).setPosition(708, 326, 739, 362);
        favelas.get(35).setPosition(776, 276, 0, 0);

        favelas.put(36, new Favela("Pavao Pavaozinho", continents.get(6), "pavaoPavaozinho.png"));
        favelas.put(37, new Favela("Chapeu Mangueira", continents.get(6), "chapeuMangueira.png"));
        favelas.put(38, new Favela("Cantagalo", continents.get(6), "cantagalo.png"));
        favelas.put(39, new Favela("Dona Marta", continents.get(6), "donaMarta.png"));
        favelas.put(40, new Favela("Vidigal", continents.get(6), "vidigal.png"));
        favelas.put(41, new Favela("Rocinha", continents.get(6), "rocinha.png"));

        //Set Position
        favelas.get(36).setPosition(765, 584, 773, 604);
        favelas.get(37).setPosition(761, 437, 810, 538);
        favelas.get(38).setPosition(603, 509, 736, 598);
        favelas.get(39).setPosition(610, 459, 683, 507);
        favelas.get(40).setPosition(530, 603, 598, 657);
        favelas.get(41).setPosition(398, 553, 543, 602);

        //Fica em loop? Da problema?
        favelas.get(1).addNeighbourhood(new Favela[]{favelas.get(2), favelas.get(3), favelas.get(4), favelas.get(41)});
        favelas.get(2).addNeighbourhood(new Favela[]{favelas.get(1), favelas.get(3)});
        favelas.get(3).addNeighbourhood(new Favela[]{favelas.get(1), favelas.get(2), favelas.get(4)});
        favelas.get(4).addNeighbourhood(new Favela[]{favelas.get(1), favelas.get(3), favelas.get(5)});

        favelas.get(5).addNeighbourhood(new Favela[]{favelas.get(6), favelas.get(7), favelas.get(4)});
        favelas.get(6).addNeighbourhood(new Favela[]{favelas.get(5), favelas.get(7), favelas.get(10), favelas.get(11)});
        favelas.get(7).addNeighbourhood(new Favela[]{favelas.get(5), favelas.get(6), favelas.get(8), favelas.get(10)});
        favelas.get(8).addNeighbourhood(new Favela[]{favelas.get(7), favelas.get(9), favelas.get(10)});
        favelas.get(9).addNeighbourhood(new Favela[]{favelas.get(8), favelas.get(12), favelas.get(14)});
        favelas.get(10).addNeighbourhood(new Favela[]{favelas.get(6), favelas.get(7), favelas.get(8), favelas.get(11), favelas.get(12)});
        favelas.get(11).addNeighbourhood(new Favela[]{favelas.get(6), favelas.get(10), favelas.get(12), favelas.get(13)});
        favelas.get(12).addNeighbourhood(new Favela[]{favelas.get(9), favelas.get(10), favelas.get(11), favelas.get(13)});
        favelas.get(13).addNeighbourhood(new Favela[]{favelas.get(11), favelas.get(12), favelas.get(26)});

        favelas.get(14).addNeighbourhood(new Favela[]{favelas.get(9), favelas.get(15)});
        favelas.get(15).addNeighbourhood(new Favela[]{favelas.get(14), favelas.get(16), favelas.get(17), favelas.get(18)});
        favelas.get(16).addNeighbourhood(new Favela[]{favelas.get(15), favelas.get(20)});
        favelas.get(17).addNeighbourhood(new Favela[]{favelas.get(15), favelas.get(18), favelas.get(19)});
        favelas.get(18).addNeighbourhood(new Favela[]{favelas.get(15), favelas.get(17), favelas.get(19), favelas.get(39), favelas.get(41)});
        favelas.get(19).addNeighbourhood(new Favela[]{favelas.get(17), favelas.get(18), favelas.get(20), favelas.get(22), favelas.get(39)});
        favelas.get(20).addNeighbourhood(new Favela[]{favelas.get(16), favelas.get(19), favelas.get(21), favelas.get(22), favelas.get(23)});

        favelas.get(21).addNeighbourhood(new Favela[]{favelas.get(20), favelas.get(23), favelas.get(27), favelas.get(30)});
        favelas.get(22).addNeighbourhood(new Favela[]{favelas.get(19), favelas.get(20), favelas.get(23), favelas.get(31), favelas.get(39)});
        favelas.get(23).addNeighbourhood(new Favela[]{favelas.get(20), favelas.get(21), favelas.get(22), favelas.get(30), favelas.get(31)});
        favelas.get(24).addNeighbourhood(new Favela[]{favelas.get(25), favelas.get(26), favelas.get(27), favelas.get(30)});
        favelas.get(25).addNeighbourhood(new Favela[]{favelas.get(24), favelas.get(26), favelas.get(27)});
        favelas.get(26).addNeighbourhood(new Favela[]{favelas.get(13), favelas.get(24), favelas.get(25), favelas.get(29), favelas.get(30)});
        favelas.get(27).addNeighbourhood(new Favela[]{favelas.get(21), favelas.get(24), favelas.get(25), favelas.get(30)});
        favelas.get(28).addNeighbourhood(new Favela[]{favelas.get(30), favelas.get(31), favelas.get(32)});
        favelas.get(29).addNeighbourhood(new Favela[]{favelas.get(26), favelas.get(30)});
        favelas.get(30).addNeighbourhood(new Favela[]{favelas.get(21), favelas.get(23), favelas.get(24), favelas.get(26), favelas.get(27), favelas.get(28), favelas.get(29), favelas.get(31)});
        favelas.get(31).addNeighbourhood(new Favela[]{favelas.get(22), favelas.get(23), favelas.get(28), favelas.get(30), favelas.get(34)});

        favelas.get(32).addNeighbourhood(new Favela[]{favelas.get(28), favelas.get(33), favelas.get(35)});
        favelas.get(33).addNeighbourhood(new Favela[]{favelas.get(32), favelas.get(35)});
        favelas.get(34).addNeighbourhood(new Favela[]{favelas.get(31), favelas.get(35)});
        favelas.get(35).addNeighbourhood(new Favela[]{favelas.get(32), favelas.get(33), favelas.get(34)});

        favelas.get(36).addNeighbourhood(new Favela[]{favelas.get(37), favelas.get(38)});
        favelas.get(37).addNeighbourhood(new Favela[]{favelas.get(36), favelas.get(38)});
        favelas.get(38).addNeighbourhood(new Favela[]{favelas.get(36), favelas.get(37), favelas.get(39), favelas.get(40), favelas.get(41)});
        favelas.get(39).addNeighbourhood(new Favela[]{favelas.get(18), favelas.get(19), favelas.get(22), favelas.get(38), favelas.get(41)});
        favelas.get(40).addNeighbourhood(new Favela[]{favelas.get(38), favelas.get(41)});
        favelas.get(41).addNeighbourhood(new Favela[]{favelas.get(1), favelas.get(18), favelas.get(38), favelas.get(39), favelas.get(40)});
    }
    public static Map<Integer, Dice> dicesAttack = new HashMap<Integer, Dice>();

    static {
        dicesAttack.put(1, new Dice("", 876, 15, 0));
        dicesAttack.put(2, new Dice("", 1028, 15, 0));
        dicesAttack.put(3, new Dice("", 1186, 15, 0));
    }
    public static Map<Integer, Dice> dicesDefense = new HashMap<Integer, Dice>();

    static {
        dicesDefense.put(1, new Dice("", 876, 155, 0));
        dicesDefense.put(2, new Dice("", 1028, 155, 0));
        dicesDefense.put(3, new Dice("", 1186, 155, 0));
    }
    public static ArrayList<Card> deck_init = new ArrayList<Card>();

    static {
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(18), "cards/agua_santa.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(35), "cards/baronesa.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(11), "cards/bento_ribeiro.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(19), "cards/borda_do_mato.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(39), "cards/dona_marta.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(2), "cards/gardenia_azul.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(21), "cards/higienopolis.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(29), "cards/nova_esperanca.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(25), "cards/parque_uniao.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(33), "cards/providencia.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(28), "cards/sao_carlos.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(8), "cards/serrinha.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(15), "cards/tomas_coelho.png"));
        deck_init.add(new Card(Card.TYPE_CIRCLE, favelas.get(40), "cards/vidigal.png"));

        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(38), "cards/cantagalo.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(12), "cards/honorio_gurgel.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(20), "cards/jacarezinho.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(30), "cards/mangueira.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(34), "cards/morro_da_coroa.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(7), "cards/morro_do_fuba.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(14), "cards/morro_do_juramento.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(26), "cards/nova_holanda.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(27), "cards/oswaldo_cruz.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(36), "cards/pavao_pavaozinho.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(1), "cards/rio_das_pedras.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(9), "cards/rocha_miranda.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(27), "cards/vila_arara.png"));
        deck_init.add(new Card(Card.TYPE_TRIANGLE, favelas.get(13), "cards/vila_eugenia.png"));

        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(37), "cards/chapeu_mangueira.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(5), "cards/covanca.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(6), "cards/jardim_sulacap.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(32), "cards/mineira.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(22), "cards/morro_do_borel.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(17), "cards/morro_do_trajano.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(23), "cards/morro_dos_macacos.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(4), "cards/nova_aurora.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(41), "cards/rocinha.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(31), "cards/salgueiro.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(16), "cards/vila_cruzeiro.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(24), "cards/vila_do_joao.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(10), "cards/vila_santa.png"));
        deck_init.add(new Card(Card.TYPE_SQUARE, favelas.get(3), "cards/cidade_de_deus.png"));
    }
}