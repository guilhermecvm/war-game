package br.uff.view;

import br.uff.model.*;
import br.uff.jplay.*;

public class WarInRio {

	Window window;
	Mouse mouse;
	Keyboard keyboard;
	GameImage fundo;
	Sprite sprite;

	WarInRio() {
		this.startGame();

		carregarObjetos();
		loop();
		descarregarObjetos();
	}

	private void startGame() {
		// Distribui Regiões para os players no inicio do jogo
		Helper.distributeFavelas();
		Data.player = Data.players.get(1);
                Deck deck = new Deck();
	}

	private void carregarObjetos() {
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
			desenhar();

			checkMouseOverFavela();
			
			checkSelectedFavelas();
		}
	}
	
	private void checkSelectedFavelas() {
		for (Favela favela : Data.favelas.values()) {
			if (Data.attacking == favela || Data.defending == favela)
				this.drawFavela(favela);
		}
	}

	private void checkMouseOverFavela() {
		Favela favela;

		if (this.isOverArea(185, 254, 275, 484)) {
			favela = Data.favelas.get(1);

			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (this.isOverArea(136, 320, 185, 437)) {
			favela = Data.favelas.get(2);

			this.drawFavela(favela);
			this.checkMouseClickFavela(favela);
		} else if (this.isOverArea(49, 313, 131, 430)) {
			favela = Data.favelas.get(3);

			this.drawFavela(favela);

			this.checkMouseClickFavela(favela);
		} else if (this.isOverArea(36, 221, 196, 310)) {

			sprite.loadImage("media/map/zonaOeste1.png");
			sprite.x = 36;
			sprite.y = 216;
			sprite.draw();
		} else if (this.isOverArea(122, 161, 184, 217)) {

			sprite.loadImage("media/map/baixada1.png");
			sprite.x = 110;
			sprite.y = 161;
			sprite.draw();
		} else if (this.isOverArea(43, 111, 125, 207)) {

			sprite.loadImage("media/map/baixada2.png");
			sprite.x = 43;
			sprite.y = 111;
			sprite.draw();
		} else if (this.isOverArea(149, 104, 236, 167)) {

			sprite.loadImage("media/map/baixada3.png");
			sprite.x = 136;
			sprite.y = 102;
			sprite.draw();
		} else if (this.isOverArea(178, 53, 226, 107)) {

			sprite.loadImage("media/map/baixada4.png");
			sprite.x = 176;
			sprite.y = 48;
			sprite.draw();
		} else if (this.isOverArea(143, 8, 239, 53)) {

			sprite.loadImage("media/map/baixada5.png");
			sprite.x = 143;
			sprite.y = 8;
			sprite.draw();
		} else if (this.isOverArea(140, 42, 179, 130)) {

			sprite.loadImage("media/map/baixada6.png");
			sprite.x = 140;
			sprite.y = 42;
			sprite.draw();
		} else if (this.isOverArea(110, 138, 42, 112)) {

			sprite.loadImage("media/map/baixada7.png");
			sprite.x = 101;
			sprite.y = 36;
			sprite.draw();
		} else if (this.isOverArea(71, 9, 143, 51)) {

			sprite.loadImage("media/map/baixada8.png");
			sprite.x = 71;
			sprite.y = 9;
			sprite.draw();
		} else if (this.isOverArea(46, 34, 115, 101)) {

			sprite.loadImage("media/map/baixada9.png");
			sprite.x = 46;
			sprite.y = 34;
			sprite.draw();
		} else if (this.isOverArea(240, 19, 285, 58)) {

			sprite.loadImage("media/map/avenida1.png");
			sprite.x = 240;
			sprite.y = 19;
			sprite.draw();
		} else if (this.isOverArea(263, 19, 321, 124)) {

			sprite.loadImage("media/map/avenida2.png");
			sprite.x = 263;
			sprite.y = 19;
			sprite.draw();
		} else if (this.isOverArea(322, 15, 378, 69)) {

			sprite.loadImage("media/map/vilaCruzeiro.png");
			sprite.x = 322;
			sprite.y = 15;
			sprite.draw();
		} else if (this.isOverArea(282, 112, 343, 183)) {

			sprite.loadImage("media/map/avenida4.png");
			sprite.x = 282;
			sprite.y = 112;
			sprite.draw();
		} else if (this.isOverArea(250, 145, 345, 285)) {

			sprite.loadImage("media/map/aguaSanta.png");
			sprite.x = 250;
			sprite.y = 145;
			sprite.draw();
		} else if (this.isOverArea(338, 159, 427, 293)) {

			sprite.loadImage("media/map/avenida6.png");
			sprite.x = 338;
			sprite.y = 159;
			sprite.draw();
		} else if (this.isOverArea(349, 51, 413, 159)) {

			sprite.loadImage("media/map/jacarezinho.png");
			sprite.x = 349;
			sprite.y = 51;
			sprite.draw();
		} else if (isOverArea(407, 89, 445, 164)
				|| isOverArea(420, 148, 501, 171)) {

			sprite.loadImage("media/map/zonaNorte2.png");
			sprite.x = 408;
			sprite.y = 89;
			sprite.draw();
		} else if (isOverArea(394, 198, 479, 308)) {

			sprite.loadImage("media/map/zonaNorte1.png");
			sprite.x = 392;
			sprite.y = 179;
			sprite.draw();
		} else if (isOverArea(396, 158, 501, 264)) {

			sprite.loadImage("media/map/morro do macaco.png");
			sprite.x = 397;
			sprite.y = 159;
			sprite.draw();
		} else if (isOverArea(453, 79, 490, 125)) {

			sprite.loadImage("media/map/zonaNorte4.png");
			sprite.x = 453;
			sprite.y = 70;
			sprite.draw();
		} else if (isOverArea(427, 23, 463, 80)) {

			sprite.loadImage("media/map/zonaNorte5.png");
			sprite.x = 427;
			sprite.y = 23;
			sprite.draw();
		} else if (isOverArea(478, 34, 530, 128)) {

			sprite.loadImage("media/map/novaHolanda.png");
			sprite.x = 478;
			sprite.y = 34;
			sprite.draw();
		} else if (isOverArea(430, 71, 510, 161)) {

			sprite.loadImage("media/map/zonaNorte3.png");
			sprite.x = 430;
			sprite.y = 71;
			sprite.draw();
		} else if (isOverArea(533, 176, 570, 221)) {

			sprite.loadImage("media/map/saoCarlos.png");
			sprite.x = 533;
			sprite.y = 164;
			sprite.draw();
		} else if (isOverArea(489, 120, 567, 121)) {

			sprite.loadImage("media/map/mangueira.png");
			sprite.x = 489;
			sprite.y = 120;
			sprite.draw();
		} else if (isOverArea(475, 215, 577, 292)) {

			sprite.loadImage("media/map/salgueiro.png");
			sprite.x = 475;
			sprite.y = 215;
			sprite.draw();
		} else if (isOverArea(562, 165, 597, 210)) {

			sprite.loadImage("media/map/central1.png");
			sprite.x = 562;
			sprite.y = 165;
			sprite.draw();
		} else if (isOverArea(586, 153, 682, 194)) {

			sprite.loadImage("media/map/providencia.png");
			sprite.x = 587;
			sprite.y = 153;
			sprite.draw();
		} else if (isOverArea(565, 218, 637, 288)) {

			sprite.loadImage("media/map/coroa.png");
			sprite.x = 565;
			sprite.y = 218;
			sprite.draw();
		} else if (isOverArea(617, 179, 720, 253)) {

			sprite.loadImage("media/map/central2.png");
			sprite.x = 617;
			sprite.y = 179;
			sprite.draw();
		} else if (isOverArea(609, 416, 654, 469)) {

			sprite.loadImage("media/map/pavaoPavaozinho.png");
			sprite.x = 609;
			sprite.y = 416;
			sprite.draw();
		} else if (isOverArea(666, 304, 748, 390)
				|| isOverArea(618, 375, 685, 420)) {

			sprite.loadImage("media/map/chapeuMangueira.png");
			sprite.x = 607;
			sprite.y = 304;
			sprite.draw();
		} else if (isOverArea(576, 378, 653, 487) || isOverArea(528, 425, 610, 457)	|| isOverArea(486, 401, 551, 430)) {

			sprite.loadImage("media/map/cantagalo.png");
			sprite.x = 485;
			sprite.y = 359;
			sprite.draw();
		} else if (isOverArea(491, 321, 653, 400)) {

			sprite.loadImage("media/map/donaMarta.png");
			sprite.x = 491;
			sprite.y = 321;
			sprite.draw();
		} else if (isOverArea(428, 474, 506, 497) || isOverArea(491, 431, 534, 498)) {

			sprite.loadImage("media/map/vidigal.png");
			sprite.x = 429;
			sprite.y = 431;
			sprite.draw();
		} else if (isOverArea(327, 392, 521, 519)) {

			sprite.loadImage("media/map/rocinha.png");
			sprite.x = 327;
			sprite.y = 392;
			sprite.draw();
		} else if (isOverArea(15, 498, 197, 557)) {

			sprite.loadImage("media/menu/comprar.png");
			sprite.x = 15;
			sprite.y = 498;
			sprite.draw();
		} else if (isOverArea(15, 584, 197, 643)) {

			sprite.loadImage("media/menu/verCartas.png");
			sprite.x = 15;
			sprite.y = 584;
			sprite.draw();
		} else if (isOverArea(563, 503, 745, 562)) {

			sprite.loadImage("media/menu/atacar.png");
			sprite.x = 563;
			sprite.y = 503;
			sprite.draw();
		} else if (isOverArea(563, 589, 745, 648)) {

			sprite.loadImage("media/menu/passarJogada.png");
			sprite.x = 563;
			sprite.y = 589;
			sprite.draw();
		} else {
			if (mouse.isLeftButtonPressed()) {
				Data.attacking = null;
				Data.defending = null;
			}
		}
	}

	public boolean isOverArea(int minX, int minY, int maxX, int maxY) {
		if ((mouse.getPosition().x < minX) || (mouse.getPosition().x > maxX)) {
			return false;
		}

		if ((mouse.getPosition().y < minY) || (mouse.getPosition().y > maxY)) {
			return false;
		}

		return true;
	}

	private void drawFavela(Favela favela) {
		sprite.loadImage("media/map/" + favela.getImg());
		sprite.x = favela.getX();
		sprite.y = favela.getY();
		sprite.draw();
	}

	private void checkMouseClickFavela(Favela favela) {
		if (mouse.isLeftButtonPressed()) {
			if (Data.attacking == null) {
				// Se região clicada pertence ao jogador atual
				if (favela.getPlayer() == Data.player) {
					Data.attacking = favela;
					System.out.println("Atacando com:" + Data.attacking.getName());
				} else {
					System.out.println("Você não é o dono da região");
				}
			} else {
				// Se a região faz divisa e pais pertence a inimigo
				if (favela.isNeighbour(Data.attacking) && favela.getPlayer() != Data.player) {
					Data.defending = favela;
					System.out.println("Defendendo com:" + Data.defending.getName());
					// Alerta, escolha com quantos soldados deseja atacar
					int attackQty = 2;
					  
					// Chama função de ataque
					try {
						Data.player.attack(Data.attacking, Data.defending, attackQty);

						// Verifica se a região sob ataque ainda tem exército
						if (Data.defending.getNumArmy() == 0) {
							System.out.println("Ataque tomou o terrório, escolha o número de soldados para passar");
							Boolean armyMoved = false;
							while (!armyMoved) {
								int moveQty = 2;
								armyMoved = Data.player.moveSoldiersAttack(Data.attacking, Data.defending, moveQty);
							}
						}

						// Zera attacking e defending
						Data.attacking = null;
						Data.defending = null;
					} catch (Error e) {
						System.out.println(e.getMessage());
						Data.defending = null;
					}
				} else {
					System.out.println("Você não pode atacar essa região, pois ela faz não faz divisa ou não percente a você.");
				}
			}
		}
	}

	private void descarregarObjetos() {
		mouse = null;
		window.exit();
	}

	private void desenhar() {
		window.update();

		fundo.draw();
	}
}
