package br.uff.view;

import br.uff.jplay.*;
import java.io.File;

public class Menu {

    Window window;
    Mouse mouse;
    Keyboard keyboard;
    GameImage fundo;
    Sound musicaFundo;
    Sound tiro;
    boolean executando = true;
    Sprite sprite;

    Menu() {
        window = new Window(1024, 768);
        window.setCursor(window.createCustomCursor("media/mouse.png"));
        fundo = new GameImage("media/menu/menu.png");
        fundo.draw();
        keyboard = window.getKeyboard();
        mouse = window.getMouse();
        sprite = new Sprite("media/menu/botao jogar.png");
        sprite.x = 326;
        musicaFundo = new Sound("media/audio/rap das armas cortado.wav");
        musicaFundo.increaseVolume(6.0206f);
        musicaFundo.play();
        musicaFundo.setRepeat(true);
        tiro = new Sound("media/audio/gun fire.wav");
        loop();
    }

    public void loop() {
        while (executando) {
            window.update();
            fundo.draw();
            if (mouse.isOverArea(326, 242, 689, 311)) {
                sprite.loadImage("media/menu/botao jogar.png");
                sprite.y = 242;
                sprite.draw();                
            }
            if ((mouse.isLeftButtonPressed()) && (mouse.isOverArea(326, 242, 689, 311))) {
                    musicaFundo.stop();
                    try{
                        wait(100);
                    }catch(Exception e ){
                        
                    }
                    tiro.play();
                    window.dispose();
                    new Game();

                }
            
            if (mouse.isOverArea(326, 352, 689, 441)) {
                sprite.y = 352;
                sprite.loadImage("media/menu/botao regras.png");
                sprite.draw();
            }

            if (mouse.isOverArea(326, 462, 689, 551)) {
                sprite.y = 462;
                sprite.loadImage("media/menu/botao creditos.png");
                sprite.draw();
            }
            if (keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
                window.exit();

            }

        }
    }
}
