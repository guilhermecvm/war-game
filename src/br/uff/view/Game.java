package br.uff.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.uff.jplay.GameImage;
import br.uff.jplay.Keyboard;
import br.uff.jplay.Mouse;
import br.uff.jplay.Sprite;
import br.uff.jplay.Window;
import br.uff.model.Data;
import br.uff.model.Deck;
import br.uff.model.Dice;
import br.uff.model.Favela;
import br.uff.model.Helper;
import br.uff.model.Player;
import br.uff.model.Status;

public class Game {

    Window window;
    Mouse mouse;
    Keyboard keyboard;
    GameImage fundo;
    Sprite sprite;
    JComboBox comboAtaque;
    JFrame panel;

    Game() {
        this.startGame();

        this.loadObjects();
        this.loop();
        this.unloadObjects();
    }

    private void startGame() {
        // Distribui Favelas para os players no inicio do jogo
        Helper.distributeFavelas();
        Data.status = Status.DISTRIBUTING;

        for (Player p : Data.players.values()) {
            p.setArmyAvaiable(Data.INITIAL_ARMY);
            p.initDistribution();
        }

        Data.player = Data.players.get(1);
        Data.player.receiveRoundArmy();

        Data.deck = new Deck(Data.deck_init);
    }

    private void loadObjects() {
        // A windows SEMPRE deve ser a primeira a ser CARREGADA
        window = new Window(1366, 768);
        window.setCursor(window.createCustomCursor("media/mouse.png"));
        keyboard = window.getKeyboard();
        mouse = window.getMouse();
        fundo = new GameImage("media/map/Mapa War.png");
        sprite = new Sprite("media/map/rio.png");
    }

    private void loop() {
        while (!keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
            this.draw();

            this.drawText();

            this.checkGameStatus();

            this.checkMouseOverFavela();

            this.checkSelectedFavelas();

            this.drawRegionInfo();

            if (Helper.gameOver()) {
                Player winner = Data.favelas.get(1).getPlayer();
                JOptionPane.showMessageDialog(null, "Fim de jogo! Vencedor: " + winner.getName());
                System.exit(0);
            } else {
                if (Data.player.getPossibleMoves().isEmpty()) {
                    Data.player.passTurn();
                } else {
                    Data.player.play();
                }
            }


            window.update();
        }
    }

    private void checkSelectedFavelas() {
        for (Favela favela : Data.favelas.values()) {
            if (Data.attacking == favela || Data.defending == favela) {
                this.drawFavela(favela);
            }
        }
    }

    private void checkMouseOverFavela() {
        Favela favela;

        if (mouse.isOverArea(226, 372, 298, 627)) {
            favela = Data.favelas.get(1);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(148, 467, 198, 591)) {
            favela = Data.favelas.get(2);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(49, 434, 149, 582)) {
            favela = Data.favelas.get(3);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(37, 323, 209, 416)) {
            favela = Data.favelas.get(4);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(138, 249, 203, 320)) {
            favela = Data.favelas.get(5);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(47, 188, 145, 288)) {
            favela = Data.favelas.get(6);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(172, 196, 262, 278)) {
            favela = Data.favelas.get(7);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(207, 112, 264, 174)) {
            favela = Data.favelas.get(8);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(168, 57, 282, 114)) {
            favela = Data.favelas.get(9);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(163, 102, 221, 214)) {
            favela = Data.favelas.get(10);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(118, 92, 169, 194)) {
            favela = Data.favelas.get(11);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(66, 53, 164, 111)) {
            favela = Data.favelas.get(12);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(33, 85, 123, 169)) {
            favela = Data.favelas.get(13);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(285, 66, 341, 115)) {
            favela = Data.favelas.get(14);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(326, 75, 391, 185)) {
            favela = Data.favelas.get(15);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(392, 61, 465, 129)) {
            favela = Data.favelas.get(16);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(341, 195, 419, 272)) {
            favela = Data.favelas.get(17);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(298, 224, 422, 388)) {
            favela = Data.favelas.get(18);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
		} else if ((mouse.isOverArea(423, 304, 526, 402))||(mouse.isOverArea(418, 257, 478, 307))) {
            favela = Data.favelas.get(19);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(461, 109, 503, 291)) {
            favela = Data.favelas.get(20);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(513, 161, 542, 254) || mouse.isOverArea(545, 230, 622, 266)) {
            favela = Data.favelas.get(21);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(485, 297, 587, 417)) {
            favela = Data.favelas.get(22);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(500, 264, 618, 389)) {
            favela = Data.favelas.get(23);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(563, 145, 609, 203)) {
            favela = Data.favelas.get(24);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(542, 74, 597, 135)) {
            favela = Data.favelas.get(25);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(599, 124, 661, 201)) {
            favela = Data.favelas.get(26);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if ((mouse.isOverArea(535, 144, 577, 226)) || (mouse.isOverArea(570, 202, 630, 239))) {
            favela = Data.favelas.get(27);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(670, 269, 713, 332)) {
            favela = Data.favelas.get(28);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(661, 154, 732, 216)) {
            favela = Data.favelas.get(29);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(619, 210, 683, 341)) {
            favela = Data.favelas.get(30);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(617, 341, 721, 414)) {
            favela = Data.favelas.get(31);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(704, 257, 748, 316)) {
            favela = Data.favelas.get(32);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(735, 242, 853, 283)) {
            favela = Data.favelas.get(33);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(719, 330, 785, 409)) {
            favela = Data.favelas.get(34);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(784, 284, 903, 353)) {
            favela = Data.favelas.get(35);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(766, 595, 797, 649)) {
            favela = Data.favelas.get(36);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(773, 526, 841, 585) || mouse.isOverArea(859, 467, 932, 542)) {
            favela = Data.favelas.get(37);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(612, 562, 685, 599) || mouse.isOverArea(663, 602, 762, 634) || mouse.isOverArea(728, 529, 767, 594) || mouse.isOverArea(784, 512, 830, 532)) {
            favela = Data.favelas.get(38);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if ((mouse.isOverArea(713, 478, 770, 526)) || mouse.isOverArea(760, 459, 813, 513) || (mouse.isOverArea(615, 501, 715, 562))) {
            favela = Data.favelas.get(39);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(532, 660, 624, 686) || mouse.isOverArea(623, 606, 631, 675)) {
            favela = Data.favelas.get(40);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(420, 562, 616, 656)) {
            favela = Data.favelas.get(41);
            this.drawFavela(favela);
            this.checkMouseClickFavela(favela);
        } else if (mouse.isOverArea(986, 614, 1346, 674)) {
            sprite.loadImage("media/menu/verCartasVerde.png");
            sprite.x = 986;
            sprite.y = 614;
            sprite.draw();
        } else if (mouse.isOverArea(986, 684, 1346, 744)) {
            sprite.loadImage("media/menu/passarJogadaVerde.png");
            sprite.x = 986;
            sprite.y = 684;
            sprite.draw();

            if (mouse.isLeftButtonPressed()) {
                Helper.nextPlayer();
            }
            /*} else if (mouse.isOverArea(563, 583, 745, 662)) {
            sprite.loadImage("media/menu/atacar.png");
            sprite.x = 563;
            sprite.y = 583;
            sprite.draw();
            
            if (mouse.isLeftButtonPressed()) {
            Data.status = Status.ATTACKING;
            }
            } else if (mouse.isOverArea(986, 544, 1346, 604)) {
            sprite.loadImage("media/menu/pegarCartaVerde.png");
            sprite.x = 986;
            sprite.y = 544;
            sprite.draw();*/
        } else {
            if (mouse.isLeftButtonPressed()) {
                Data.attacking = null;
                Data.defending = null;

                //Zera o valor dos dados pois vai atacar novamente
                Helper.eraseDice();
            }
        }
    }

    private void checkMouseClickFavela(Favela favela) {
        if (mouse.isLeftButtonPressed()) {
            if (Data.status == Status.DISTRIBUTING) {
                if (favela.getPlayer() == Data.player) {
                    //Clicou na favela, abre uma dialog perguntando quantos membros vai alocar na favela.
                    String numArmy = JOptionPane.showInputDialog(window, "Quantos membros deseja alocar nessa favela?", "Alocando Membros", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        if (!Data.player.sendArmyTo(favela, Integer.parseInt(numArmy))) {
                            JOptionPane.showMessageDialog(window, "Você não tem essa quantidade de membros disponível.", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception e) {
                        Data.player.sendArmyTo(favela, 0);
                    }
                }
            } else if (Data.status == Status.ATTACKING) {
                if (Data.attacking == null) {
                    //Zera o valor dos dados pois vai atacar novamente
                    Helper.eraseDice();

                    // Se favela clicada pertence ao jogador atual
                    if (favela.getPlayer() == Data.player) {
                        Data.attacking = favela;
                        System.out.println("Atacando com:" + Data.attacking.getName());
                    } else {
                        JOptionPane.showMessageDialog(window, "Você não é o dono da favela!", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                        Data.attacking = null;
                        // System.out.println("Você não é o dono da favela");
                    }
                } else {
                    // Se a região faz divisa e favela pertence a inimigo
                    if (favela.isNeighbour(Data.attacking) && favela.getPlayer() != Data.player) {
                        if (Data.attacking.getNumArmy() > 1) {
                            Data.defending = favela;
                            System.out.println("Defendendo com:" + Data.defending.getName());

                            //Painel
                            this.showAttackPanel();
                        } else {
                            JOptionPane.showMessageDialog(window, "Você não possui membros suficientes para atacar.", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                            Data.attacking = null;
                            Data.defending = null;
                        }
                    } else {
                        JOptionPane.showMessageDialog(window, "Você não pode atacar essa favela, pois ela faz não faz divisa, ou percente a você.", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                        Data.defending = null;
                    }
                }
            } else if (Data.status == Status.MOVING) {
            }
        }
    }

    private void showAttackPanel() {
        panel = new JFrame(Data.attacking.getName() + " atacando " + Data.defending.getName());
        Container pane = panel.getContentPane();
        pane.setLayout(new GridLayout(4, 1));
        JPanel pane2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pane3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton buttonOk = new JButton("OK");
        JButton buttonCancelar = new JButton("Cancelar");
        comboAtaque = new JComboBox();
        JLabel numArmyAtaque = new JLabel("Sua favela possui " + Data.attacking.getNumArmy() + " membro(s).");
        JLabel numArmyDefesa = new JLabel("Seu inimigo possui " + Data.defending.getNumArmy() + " membro(s).");
        if (Data.attacking.getNumArmy() >= 4) {
            comboAtaque.addItem(1);
            comboAtaque.addItem(2);
            comboAtaque.addItem(3);
        } else {
            for (int i = 1; i < Data.attacking.getNumArmy(); i++) {
                comboAtaque.addItem(i);
            }
        }
        comboAtaque.setSize(50, 50);
        pane.add(numArmyAtaque);
        pane.add(numArmyDefesa);
        pane2.add(new JLabel("Com quantos exércitos você quer atacar: "));
        pane2.add(comboAtaque);
        pane3.add(buttonOk);
        pane3.add(buttonCancelar);
        pane.add(pane2);
        pane.add(pane3);
        buttonOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int attackQty = ((Integer) comboAtaque.getSelectedItem()).intValue();

                attack(attackQty);
                panel.dispose();
            }
        });
        buttonCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.dispose();
                Data.attacking = null;
                Data.defending = null;
            }
        });

        panel.setSize(300, 300);
        panel.setResizable(true);
        panel.setVisible(true);
    }

    private void attack(int attackQty) {
        try {
            Data.player.attack(Data.attacking, Data.defending, attackQty);

            // Verifica se a região sob ataque ainda tem exército
            if (Data.defending.getNumArmy() == 0) {
                String moveArmy;
                System.out.println("Ataque tomou a favela, escolha o número de membros para passar");
                Boolean armyMoved = false;
                while (!armyMoved) {
                    moveArmy = JOptionPane.showInputDialog(window, "Ataque tomou a favela, escolha o número de membros para passar", "Movendo Membros", JOptionPane.INFORMATION_MESSAGE);
                    int moveQty = Integer.parseInt(moveArmy);
                    if (!(armyMoved = Data.player.moveSoldiersAttack(Data.attacking, Data.defending, moveQty))) {
                        JOptionPane.showMessageDialog(window, "Número de membros inválido. Deve ter pelo menos 1 membro tomando conta da favela " + Data.attacking.getName() + "!", "Movimentando", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                JOptionPane.showMessageDialog(window, "Membros enviados a nova favela com sucesso.", "Movimentando", JOptionPane.INFORMATION_MESSAGE);
            }

            // Zera attacking e defending
            Data.attacking = null;
            Data.defending = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(window, e.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Erro " + e.getMessage());
            Data.defending = null;
        }
    }

    private void drawFavela(Favela favela) {
        sprite.loadImage("media/map/" + favela.getImg());
        sprite.x = favela.getX();
        sprite.y = favela.getY();
        sprite.draw();
    }

    private void drawDices() {
        for (Dice dice : Data.dicesAttack.values()) {
            if (dice.getValue() > 0) {
                sprite.loadImage("media/dices/a" + dice.getValue() + ".png");
                sprite.x = dice.getX();
                sprite.y = dice.getY();
                sprite.draw();
            }
        }
        for (Dice dice : Data.dicesDefense.values()) {
            if (dice.getValue() > 0) {
                sprite.loadImage("media/dices/d" + dice.getValue() + ".png");
                sprite.x = dice.getX();
                sprite.y = dice.getY();
                sprite.draw();
            }
        }
    }

    private void unloadObjects() {
        mouse = null;
        window.exit();
    }

    private void draw() {
        fundo.draw();

        this.drawDices();
    }

    private void drawText() {
        window.drawText(Data.player.getName(), 990, 320, Color.black, Font.decode("ARIAL-REGULAR-36"));
        window.drawText("Membros para alocar: " + String.valueOf(Data.player.getArmyAvaiable()), 990, 350, Color.black, Font.decode("ARIAL-REGULAR-22"));
    }

    private void drawRegionInfo() {
        for (Favela favela : Data.favelas.values()) {
            sprite.loadImage("media/" + favela.getPlayer().getImg());
            sprite.x = favela.getArmyX();
            sprite.y = favela.getArmyY();
            sprite.draw();
            window.drawText(String.valueOf(favela.getNumArmy()), favela.getArmyX() + 5, favela.getArmyY() + 15, Color.white, Font.decode("ARIAL-REGULAR-12"));
        }
    }

    private void checkGameStatus() {
        if (Data.status == Status.DISTRIBUTING) {
            if (Data.player.getArmyAvaiable() == 0) {
                Data.status = Status.ATTACKING;
            }
        }
    }
}
