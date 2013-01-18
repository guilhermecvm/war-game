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
        window = new Window(1366, 768);
        window.setCursor(window.createCustomCursor("mouse.png"));
        keyboard = window.getKeyboard();
        mouse = window.getMouse();
        fundo = new GameImage("Mapa War.png");
        sprite = new Sprite("rio.png");
        fundo.draw();
    }

    private void loop() {
        while (!keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
            desenhar();
//            this.mouseOverRegion(1);
            verificaMouseSobBairroSprite();
        }
    }

    private void mouseOverRegion(Integer i) {
        Region region = Data.regions.get(i);
        if ((mouse.getPosition().x >= region.getX1()) && (mouse.getPosition().x <= region.getX2()) && (mouse.getPosition().y >= region.getY1()) && (mouse.getPosition().y <= region.getY2())) {
            fundo.draw();
            sprite.loadImage("" + region.getImg());
            sprite.x = region.getX();
            sprite.y = region.getY();
            sprite.draw();
        } else {
            //Se est� na �ltima regi�o e n�o entrou no if � pq o mouse n�o est� em cima de nada, ent�o desenha o fundo e para a recurs�o
            if (i == Data.regions.size()) {
                fundo.draw();
            } else {
                mouseOverRegion(++i);
            }
        }
    }
    
    private void drawRegion(Integer i) {
        Region region = Data.regions.get(i);
            fundo.draw();
            sprite.loadImage("" + region.getImg());
            sprite.x = region.getX();
            sprite.y = region.getY();
            sprite.draw();
    }

    private void verificaMouseSobBairroSprite() {
        //RIO DAS PEDRAS
        if ((mouse.getPosition().x >= 185) && (mouse.getPosition().x <= 275) && (mouse.getPosition().y >= 254) && (mouse.getPosition().y <= 484)) {
            fundo.draw();
            sprite.loadImage("rio.png");
            sprite.x = 145;
            sprite.y = 248;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 136) && (mouse.getPosition().x <= 185) && (mouse.getPosition().y >= 320) && (mouse.getPosition().y <= 437)) {
            fundo.draw();
            sprite.loadImage("gardenia.png");
            sprite.x = 110;
            sprite.y = 302;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 49) && (mouse.getPosition().x <= 131) && (mouse.getPosition().y >= 313) && (mouse.getPosition().y <= 430)) {
            fundo.draw();
            sprite.loadImage("cidadeDeDeus.png");
            sprite.x = 45;
            sprite.y = 270;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 36) && (mouse.getPosition().x <= 196) && (mouse.getPosition().y >= 221) && (mouse.getPosition().y <= 310)) {
            fundo.draw();
            sprite.loadImage("zonaOeste1.png");
            sprite.x = 36;
            sprite.y = 216;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 122) && (mouse.getPosition().x <= 184) && (mouse.getPosition().y >= 161) && (mouse.getPosition().y <= 217)) {
            fundo.draw();
            sprite.loadImage("baixada1.png");
            sprite.x = 110;
            sprite.y = 161;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 43) && (mouse.getPosition().x <= 125) && (mouse.getPosition().y >= 111) && (mouse.getPosition().y <= 207)) {
            fundo.draw();
            sprite.loadImage("baixada2.png");
            sprite.x = 43;
            sprite.y = 111;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 149) && (mouse.getPosition().x <= 236) && (mouse.getPosition().y >= 104) && (mouse.getPosition().y <= 167)) {
            fundo.draw();
            sprite.loadImage("baixada3.png");
            sprite.x = 136;
            sprite.y = 102;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 178) && (mouse.getPosition().x <= 226) && (mouse.getPosition().y >= 53) && (mouse.getPosition().y <= 107)) {
            fundo.draw();
            sprite.loadImage("baixada4.png");
            sprite.x = 176;
            sprite.y = 48;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 143) && (mouse.getPosition().x <= 239) && (mouse.getPosition().y >= 8) && (mouse.getPosition().y <= 53)) {
            fundo.draw();
            sprite.loadImage("baixada5.png");
            sprite.x = 143;
            sprite.y = 8;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 140) && (mouse.getPosition().x <= 179) && (mouse.getPosition().y >= 42) && (mouse.getPosition().y <= 130)) {
            fundo.draw();
            sprite.loadImage("baixada6.png");
            sprite.x = 140;
            sprite.y = 42;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 110) && (mouse.getPosition().x <= 138) && (mouse.getPosition().y >= 42) && (mouse.getPosition().y <= 112)) {
            fundo.draw();
            sprite.loadImage("baixada7.png");
            sprite.x = 101;
            sprite.y = 36;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 71) && (mouse.getPosition().x <= 143) && (mouse.getPosition().y >= 9) && (mouse.getPosition().y <= 51)) {
            fundo.draw();
            sprite.loadImage("baixada8.png");
            sprite.x = 71;
            sprite.y = 9;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 46) && (mouse.getPosition().x <= 115) && (mouse.getPosition().y >= 34) && (mouse.getPosition().y <= 101)) {
            fundo.draw();
            sprite.loadImage("baixada9.png");
            sprite.x = 46;
            sprite.y = 34;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 240) && (mouse.getPosition().x <= 285) && (mouse.getPosition().y >= 19) && (mouse.getPosition().y <= 58)) {
            fundo.draw();
            sprite.loadImage("avenida1.png");
            sprite.x = 240;
            sprite.y = 19;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 263) && (mouse.getPosition().x <= 321) && (mouse.getPosition().y >= 19) && (mouse.getPosition().y <= 124)) {
            fundo.draw();
            sprite.loadImage("avenida2.png");
            sprite.x = 263;
            sprite.y = 19;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 322) && (mouse.getPosition().x <= 378) && (mouse.getPosition().y >= 15) && (mouse.getPosition().y <= 69)) {
            fundo.draw();
            sprite.loadImage("vilaCruzeiro.png");
            sprite.x = 322;
            sprite.y = 15;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 282) && (mouse.getPosition().x <= 343) && (mouse.getPosition().y >= 112) && (mouse.getPosition().y <= 183)) {
            fundo.draw();
            sprite.loadImage("avenida4.png");
            sprite.x = 282;
            sprite.y = 112;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 250) && (mouse.getPosition().x <= 345) && (mouse.getPosition().y >= 145) && (mouse.getPosition().y <= 285)) {
            fundo.draw();
            sprite.loadImage("aguaSanta.png");
            sprite.x = 250;
            sprite.y = 145;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 338) && (mouse.getPosition().x <= 427) && (mouse.getPosition().y >= 159) && (mouse.getPosition().y <= 293)) {
            fundo.draw();
            sprite.loadImage("avenida6.png");
            sprite.x = 338;
            sprite.y = 159;
            sprite.draw();
        } else if ((mouse.getPosition().x >= 349) && (mouse.getPosition().x <= 413) && (mouse.getPosition().y >= 51) && (mouse.getPosition().y <= 159)) {
            fundo.draw();
            sprite.loadImage("jacarezinho.png");
            sprite.x = 349;
            sprite.y = 51;
            sprite.draw();
        } else if (isOverArea(407, 89, 445, 164) || isOverArea(420, 148, 501, 171)) {
            fundo.draw();
            sprite.loadImage("zonaNorte2.png");
            sprite.x = 408;
            sprite.y = 89;
            sprite.draw();
        } else if (isOverArea(394, 198, 479, 308)) {
            fundo.draw();
            sprite.loadImage("zonaNorte1.png");
            sprite.x = 392;
            sprite.y = 179;
            sprite.draw();
        } else if (isOverArea(396, 158, 501, 264)) {
            fundo.draw();
            sprite.loadImage("morro do macaco.png");
            sprite.x = 397;
            sprite.y = 159;
            sprite.draw();
        } else if (isOverArea(453, 79, 490, 125)) {
            fundo.draw();
            sprite.loadImage("zonaNorte4.png");
            sprite.x = 453;
            sprite.y = 70;
            sprite.draw();
        } else if (isOverArea(427, 23, 463, 80)) {
            fundo.draw();
            sprite.loadImage("zonaNorte5.png");
            sprite.x = 427;
            sprite.y = 23;
            sprite.draw();
        } else if (isOverArea(478, 34, 530, 128)) {
            fundo.draw();
            sprite.loadImage("novaHolanda.png");
            sprite.x = 478;
            sprite.y = 34;
            sprite.draw();
        } else if (isOverArea(430, 71, 510, 161)) {
            fundo.draw();
            sprite.loadImage("zonaNorte3.png");
            sprite.x = 430;
            sprite.y = 71;
            sprite.draw();
        } else if (isOverArea(533, 176, 570, 221)) {
            fundo.draw();
            sprite.loadImage("saoCarlos.png");
            sprite.x = 533;
            sprite.y = 164;
            sprite.draw();
        } else if (isOverArea(489, 120, 567, 121)) {
            fundo.draw();
            sprite.loadImage("mangueira.png");
            sprite.x = 489;
            sprite.y = 120;
            sprite.draw();
        } else if (isOverArea(475, 215, 577, 292)) {
            fundo.draw();
            sprite.loadImage("salgueiro.png");
            sprite.x = 475;
            sprite.y = 215;
            sprite.draw();
        } else if (isOverArea(562, 165, 597, 210)) {
            fundo.draw();
            sprite.loadImage("central1.png");
            sprite.x = 562;
            sprite.y = 165;
            sprite.draw();
        } else if (isOverArea(586, 153, 682, 194)) {
            fundo.draw();
            sprite.loadImage("providencia.png");
            sprite.x = 587;
            sprite.y = 153;
            sprite.draw();
        } else if (isOverArea(565, 218, 637, 288)) {
            fundo.draw();
            sprite.loadImage("coroa.png");
            sprite.x = 565;
            sprite.y = 218;
            sprite.draw();
        } else if (isOverArea(617, 179, 720, 253)) {
            fundo.draw();
            sprite.loadImage("central2.png");
            sprite.x = 617;
            sprite.y = 179;
            sprite.draw();
        } else if (isOverArea(609, 416, 654, 469)) {
            fundo.draw();
            sprite.loadImage("pavaoPavaozinho.png");
            sprite.x = 609;
            sprite.y = 416;
            sprite.draw();
        } else if (isOverArea(666, 304, 748, 390) || isOverArea(618, 375, 685, 420)) {
            fundo.draw();
            sprite.loadImage("chapeuMangueira.png");
            sprite.x = 607;
            sprite.y = 304;
            sprite.draw();
        } else if (isOverArea(576, 378, 653, 487) || isOverArea(528, 425, 610, 457) || isOverArea(486, 401, 551, 430)) {
            fundo.draw();
            sprite.loadImage("cantagalo.png");
            sprite.x = 485;
            sprite.y = 359;
            sprite.draw();
        } else if (isOverArea(491, 321, 653, 400)) {
            fundo.draw();
            sprite.loadImage("donaMarta.png");
            sprite.x = 491;
            sprite.y = 321;
            sprite.draw();
        } else if (isOverArea(428, 474, 506, 497) || isOverArea(491, 431, 534, 498)) {
            fundo.draw();
            sprite.loadImage("vidigal.png");
            sprite.x = 429;
            sprite.y = 431;
            sprite.draw();
        } else if (isOverArea(327, 392, 521, 519)) {
            fundo.draw();
            sprite.loadImage("rocinha.png");
            sprite.x = 327;
            sprite.y = 392;
            sprite.draw();
        } else if (isOverArea(15, 498, 197, 557)) {
            fundo.draw();
            sprite.loadImage("comprar.png");
            sprite.x = 15;
            sprite.y = 498;
            sprite.draw();
        } else if (isOverArea(15, 584, 197, 643)) {
            fundo.draw();
            sprite.loadImage("verCartas.png");
            sprite.x = 15;
            sprite.y = 584;
            sprite.draw();
        } else if (isOverArea(563, 503, 745, 562)) {
            fundo.draw();
            sprite.loadImage("atacar.png");
            sprite.x = 563;
            sprite.y = 503;
            sprite.draw();
        } else if (isOverArea(563, 589, 745, 648)) {
            fundo.draw();
            sprite.loadImage("passarJogada.png");
            sprite.x = 563;
            sprite.y = 589;
            sprite.draw();
        } else {
            fundo.draw();
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

    private void descarregarObjetos() {
        mouse = null;
        window.exit();

    }

    private void desenhar() {
        // fundo.draw();
        window.update();

    }
}
