package br.uff.view;

import java.awt.Container;
import java.awt.FlowLayout;
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
		Data.player = Data.players.get(1);
		
		//TODO distribuir membros para os players alocarem nas favelas
		
		// Só para testar
		Data.favelas.get(1).setNumArmy(5);
		Data.favelas.get(2).setNumArmy(3);
		Data.favelas.get(3).setNumArmy(3);
		Data.favelas.get(4).setNumArmy(2);

		Deck deck = new Deck();
	}

	private void loadObjects() {
		// A windows SEMPRE deve ser a primeira a ser CARREGADA
		window = new Window(1344, 756);
		window.setCursor(window.createCustomCursor("media/mouse.png"));
		keyboard = window.getKeyboard();
		mouse = window.getMouse();
		fundo = new GameImage("media/map/Mapa War.png");
		sprite = new Sprite("media/map/rio.png");
	}

	private void loop() {
		while (!keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
			this.draw();

			this.checkMouseOverFavela();

			this.checkSelectedFavelas();
			
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

		if (mouse.isOverArea(185, 254, 275, 484)) {
			favela = Data.favelas.get(1);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(136, 320, 185, 437)) {
			favela = Data.favelas.get(2);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(49, 313, 131, 430)) {
			favela = Data.favelas.get(3);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(36, 221, 196, 310)) {
			favela = Data.favelas.get(4);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(122, 161, 184, 217)) {
			favela = Data.favelas.get(5);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(43, 107, 125, 207)) {
			favela = Data.favelas.get(6);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(149, 104, 236, 167)) {
			favela = Data.favelas.get(7);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(178, 53, 226, 107)) {
			favela = Data.favelas.get(8);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(143, 8, 239, 53)) {
			favela = Data.favelas.get(9);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(140, 42, 179, 130)) {
			favela = Data.favelas.get(10);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(101, 34, 151, 117)) {
			favela = Data.favelas.get(11);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(71, 9, 143, 51)) {
			favela = Data.favelas.get(12);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(46, 34, 115, 101)) {
			favela = Data.favelas.get(13);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(240, 18, 285, 58)) {
			favela = Data.favelas.get(14);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(263, 18, 321, 124)) {
			favela = Data.favelas.get(15);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(322, 15, 378, 69)) {
			favela = Data.favelas.get(16);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(282, 112, 343, 183)) {
			favela = Data.favelas.get(17);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(250, 145, 345, 285)) {
			favela = Data.favelas.get(18);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(336, 153, 427, 293)) {
			favela = Data.favelas.get(19);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(349, 51, 413, 159)) {
			favela = Data.favelas.get(20);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(407, 89, 445, 164) || mouse.isOverArea(420, 148, 501, 171)) {
			favela = Data.favelas.get(21);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(394, 198, 479, 308)) {
			favela = Data.favelas.get(22);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(396, 158, 501, 264)) {
			favela = Data.favelas.get(23);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(453, 79, 490, 125)) {
			favela = Data.favelas.get(24);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(427, 23, 463, 80)) {
			favela = Data.favelas.get(25);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(478, 34, 530, 128)) {
			favela = Data.favelas.get(26);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(430, 71, 510, 161)) {
			favela = Data.favelas.get(27);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(535, 170, 572, 226)) {
			favela = Data.favelas.get(28);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(522, 76, 595, 133)) {
			favela = Data.favelas.get(29);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(490, 121, 562, 223)) {
			favela = Data.favelas.get(30);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(475, 215, 577, 292)) {
			favela = Data.favelas.get(31);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(562, 165, 597, 210)) {
			favela = Data.favelas.get(32);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(586, 153, 682, 194)) {
			favela = Data.favelas.get(33);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(565, 218, 637, 288)) {
			favela = Data.favelas.get(34);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(617, 179, 720, 253)) {
			favela = Data.favelas.get(35);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(609, 416, 654, 469)) {
			favela = Data.favelas.get(36);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(666, 304, 748, 390) || mouse.isOverArea(618, 375, 685, 420)) {
			favela = Data.favelas.get(37);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(576, 378, 653, 487) || mouse.isOverArea(528, 425, 610, 457) || mouse.isOverArea(486, 401, 551, 430)) {
			favela = Data.favelas.get(38);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(491, 321, 653, 400)) {
			favela = Data.favelas.get(39);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(428, 474, 506, 497) || mouse.isOverArea(491, 431, 534, 498)) {
			favela = Data.favelas.get(40);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(327, 392, 521, 519)) {
			favela = Data.favelas.get(41);
			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (mouse.isOverArea(15, 578, 197, 637)) {
			sprite.loadImage("media/menu/comprar.png");
			sprite.x = 15;
			sprite.y = 578;
			sprite.draw();
		} else if (mouse.isOverArea(15, 664, 197, 723)) {
			sprite.loadImage("media/menu/verCartas.png");
			sprite.x = 15;
			sprite.y = 664;
			sprite.draw();
		} else if (mouse.isOverArea(563, 583, 745, 662)) {
			sprite.loadImage("media/menu/atacar.png");
			sprite.x = 563;
			sprite.y = 583;
			sprite.draw();
		} else if (mouse.isOverArea(563, 669, 745, 728)) {
			sprite.loadImage("media/menu/passarJogada.png");
			sprite.x = 563;
			sprite.y = 669;
			sprite.draw();
		} else {
			if (mouse.isLeftButtonPressed()) {
				Data.attacking = null;
				Data.defending = null;
				
				//Zera o valor dos dados pois vai atacar novamente
				this.eraseDice();
			}
		}
	}

	private void checkMouseClickFavela(Favela favela) {
		if (mouse.isLeftButtonPressed()) {
			if (Data.attacking == null) {
				//Zera o valor dos dados pois vai atacar novamente
				this.eraseDice();
				
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
					if (!(armyMoved = Data.player.moveSoldiersAttack(Data.attacking, Data.defending, moveQty)))
						JOptionPane.showMessageDialog(window, "Número de membros inválido. Deve ter pelo menos 1 membro tomando conta da favela " + Data.attacking.getName() + "!", "Movimentando", JOptionPane.INFORMATION_MESSAGE);
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
				sprite.loadImage("media/dices/a"+dice.getValue()+".png");
				sprite.x = dice.getX();
				sprite.y = dice.getY();
				sprite.draw();
			}
		}
		for (Dice dice : Data.dicesDefense.values()) {
			if (dice.getValue() > 0) {
				sprite.loadImage("media/dices/d"+dice.getValue()+".png");
				sprite.x = dice.getX();
				sprite.y = dice.getY();
				sprite.draw();
			}
		}
	}
	
	private void eraseDice() {
		for (Dice dice : Data.dicesAttack.values()) {
			dice.setValue(0);
		}
		for (Dice dice : Data.dicesDefense.values()) {
			dice.setValue(0);
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
}
