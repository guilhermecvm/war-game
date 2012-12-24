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
        carregarObjetos();
        loop();
        descarregarObjetos();
    }

    private void carregarObjetos() {
        //A windows SEMPRE deve ser a primeira a ser CARREGADA
        window = new Window(800, 600);
        window.setCursor(window.createCustomCursor("media/mouse.png"));
        keyboard = window.getKeyboard();
        mouse = window.getMouse();
        fundo = new GameImage("media/map/Mapa War.jpg");
        sprite = new Sprite("media/map/rio.png");
        fundo.draw();
    }

    private void loop() {
        while (!keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
            desenhar();
            this.mouseOverRegion(1);
//            verificaMouseSobBairro();
        }
    }
    
    private void mouseOverRegion(Integer i) {
    	Region region = Data.regions.get(i);
    	if ((mouse.getPosition().x >= region.getX1()) && (mouse.getPosition().x <= region.getX2()) && (mouse.getPosition().y >= region.getY1()) && (mouse.getPosition().y <= region.getY2())) {
			fundo.draw();
			sprite.loadImage("media/map/"+region.getImg());
			sprite.x = region.getX();
			sprite.y = region.getY();
			sprite.draw();
		}
    	else {
    		//Se está na última região e não entrou no if é pq o mouse não está em cima de nada, então desenha o fundo e para a recursão
    		if (i == Data.regions.size()) {
    			fundo.draw();
    		}
    		else {
    			mouseOverRegion(++i);
    		}
    	}
    }

    private void verificaMouseSobBairro() {
        //RIO DAS PEDRAS
        if ((mouse.getPosition().x >= 185) && (mouse.getPosition().x <= 275) && (mouse.getPosition().y >= 254) && (mouse.getPosition().y <= 484)) {
            fundo.draw();
            sprite.loadImage("media/map/rio.png");
            sprite.x = 145;
            sprite.y = 248;
            sprite.draw();
        } else {
            //gardenia azul
            if ((mouse.getPosition().x >= 136) && (mouse.getPosition().x <= 185) && (mouse.getPosition().y >= 320) && (mouse.getPosition().y <= 437)) {
                fundo.draw();
                sprite.loadImage("media/map/gardenia.png");
                sprite.x = 110;
                sprite.y = 302;
                sprite.draw();

            } else if ((mouse.getPosition().x >= 49) && (mouse.getPosition().x <= 131) && (mouse.getPosition().y >= 313) && (mouse.getPosition().y <= 430)) {
                fundo.draw();
                sprite.loadImage("media/map/cidadeDeDeus.png");
                sprite.x = 45;
                sprite.y = 270;
                sprite.draw();
            } else {
                if ((mouse.getPosition().x >= 36) && (mouse.getPosition().x <= 196) && (mouse.getPosition().y >= 221) && (mouse.getPosition().y <= 310)) {
                    fundo.draw();
                    sprite.loadImage("media/map/zonaOeste1.png");
                    sprite.x = 36;
                    sprite.y = 216;
                    sprite.draw();
                } else {
                    if ((mouse.getPosition().x >= 122) && (mouse.getPosition().x <= 184) && (mouse.getPosition().y >= 161) && (mouse.getPosition().y <= 217)) {
                        fundo.draw();
                        sprite.loadImage("media/map/baixada1.png");
                        sprite.x = 110;
                        sprite.y = 161;
                        sprite.draw();
                    } else {
                        if ((mouse.getPosition().x >= 43) && (mouse.getPosition().x <= 125) && (mouse.getPosition().y >= 111) && (mouse.getPosition().y <= 207)) {
                            fundo.draw();
                            sprite.loadImage("media/map/baixada2.png");
                            sprite.x = 43;
                            sprite.y = 111;
                            sprite.draw();
                        } else {
                            if ((mouse.getPosition().x >= 149) && (mouse.getPosition().x <= 236) && (mouse.getPosition().y >= 104) && (mouse.getPosition().y <= 167)) {
                                fundo.draw();
                                sprite.loadImage("media/map/baixada3.png");
                                sprite.x = 136;
                                sprite.y = 102;
                                sprite.draw();
                            } else {
                                if ((mouse.getPosition().x >= 178) && (mouse.getPosition().x <= 226) && (mouse.getPosition().y >= 53) && (mouse.getPosition().y <= 107)) {
                                    fundo.draw();
                                    sprite.loadImage("media/map/baixada4.png");
                                    sprite.x = 176;
                                    sprite.y = 48;
                                    sprite.draw();
                                } else {
                                    if ((mouse.getPosition().x >= 143) && (mouse.getPosition().x <= 239) && (mouse.getPosition().y >= 8) && (mouse.getPosition().y <= 53)) {
                                        fundo.draw();
                                        sprite.loadImage("media/map/baixada5.png");
                                        sprite.x = 143;
                                        sprite.y = 8;
                                        sprite.draw();
                                    } else {
                                        if ((mouse.getPosition().x >= 140) && (mouse.getPosition().x <= 179) && (mouse.getPosition().y >= 42) && (mouse.getPosition().y <= 130)) {
                                            fundo.draw();
                                            sprite.loadImage("media/map/baixada6.png");
                                            sprite.x = 140;
                                            sprite.y = 42;
                                            sprite.draw();
                                        } else {
                                            if ((mouse.getPosition().x >= 110) && (mouse.getPosition().x <= 138) && (mouse.getPosition().y >= 42) && (mouse.getPosition().y <= 112)) {
                                                fundo.draw();
                                                sprite.loadImage("media/map/baixada7.png");
                                                sprite.x = 101;
                                                sprite.y = 36;
                                                sprite.draw();
                                            } else {
                                                if ((mouse.getPosition().x >= 71) && (mouse.getPosition().x <= 143) && (mouse.getPosition().y >= 9) && (mouse.getPosition().y <= 51)) {
                                                    fundo.draw();
                                                    sprite.loadImage("media/map/baixada8.png");
                                                    sprite.x = 71;
                                                    sprite.y = 9;
                                                    sprite.draw();
                                                } else {
                                                    if ((mouse.getPosition().x >= 46) && (mouse.getPosition().x <= 115) && (mouse.getPosition().y >= 34) && (mouse.getPosition().y <= 101)) {
                                                        fundo.draw();
                                                        sprite.loadImage("media/map/baixada9.png");
                                                        sprite.x = 46;
                                                        sprite.y = 34;
                                                        sprite.draw();
                                                    } else {
                                                        if ((mouse.getPosition().x >= 240) && (mouse.getPosition().x <= 285) && (mouse.getPosition().y >= 19) && (mouse.getPosition().y <= 58)) {
                                                            fundo.draw();
                                                            sprite.loadImage("media/map/avenida1.png");
                                                            sprite.x = 240;
                                                            sprite.y = 19;
                                                            sprite.draw();
                                                        } else {
                                                            if ((mouse.getPosition().x >= 263) && (mouse.getPosition().x <= 321) && (mouse.getPosition().y >= 19) && (mouse.getPosition().y <= 124)) {
                                                                fundo.draw();
                                                                sprite.loadImage("media/map/avenida2.png");
                                                                sprite.x = 263;
                                                                sprite.y = 19;
                                                                sprite.draw();
                                                            } else {
                                                                if ((mouse.getPosition().x >= 322) && (mouse.getPosition().x <= 378) && (mouse.getPosition().y >= 15) && (mouse.getPosition().y <= 69)) {
                                                                    fundo.draw();
                                                                    sprite.loadImage("media/map/vilaCruzeiro.png");
                                                                    sprite.x = 322;
                                                                    sprite.y = 15;
                                                                    sprite.draw();
                                                                } else {
                                                                    if ((mouse.getPosition().x >= 282) && (mouse.getPosition().x <= 343) && (mouse.getPosition().y >= 112) && (mouse.getPosition().y <= 183)) {
                                                                        fundo.draw();
                                                                        sprite.loadImage("media/map/avenida4.png");
                                                                        sprite.x = 282;
                                                                        sprite.y = 112;
                                                                        sprite.draw();
                                                                    } else {
                                                                        if ((mouse.getPosition().x >= 250) && (mouse.getPosition().x <= 345) && (mouse.getPosition().y >= 145) && (mouse.getPosition().y <= 285)) {
                                                                            fundo.draw();
                                                                            sprite.loadImage("media/map/aguaSanta.png");
                                                                            sprite.x = 250;
                                                                            sprite.y = 145;
                                                                            sprite.draw();
                                                                        } else {
                                                                            if ((mouse.getPosition().x >= 338) && (mouse.getPosition().x <= 427) && (mouse.getPosition().y >= 159) && (mouse.getPosition().y <= 293)) {
                                                                                fundo.draw();
                                                                                sprite.loadImage("media/map/avenida6.png");
                                                                                sprite.x = 338;
                                                                                sprite.y = 159;
                                                                                sprite.draw();
                                                                            } else {
                                                                                if ((mouse.getPosition().x >= 349) && (mouse.getPosition().x <= 413) && (mouse.getPosition().y >= 51) && (mouse.getPosition().y <= 159)) {
                                                                                    fundo.draw();
                                                                                    sprite.loadImage("media/map/jacarezinho.png");
                                                                                    sprite.x = 349;
                                                                                    sprite.y = 51;
                                                                                    sprite.draw();
                                                                                } else {
                                                                                    fundo.draw();
                                                                                }

                                                                            }

                                                                        }


                                                                    }

                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }

        }
    }

    private void descarregarObjetos() {
        mouse = null;
        window.exit();

    }

    private void desenhar() {
        // fundo.draw();
        window.update();

    }
}
