package br.uff.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.uff.controller.Main;
import java.util.Scanner;

public abstract class PlayerAbstract implements Player {

    public Main main = new Main();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Region> getRegions() {
    // Retorna todas as regiões que eu estou dominando no momento
        ArrayList<Region> regions = new ArrayList<Region>();
        Region reg;
        for (int i = 1; i <= Data.regions.size(); i++) {
            reg = Data.regions.get(i);

            if ((reg.getPlayer() != null) && reg.getPlayer().equals(this)) {
                regions.add(reg);
            }
        }

        return regions;
    }

    public ArrayList<Region> getEnemyRegions() {
    // Retorna todas as regiões que eu NÃO estou dominando no momento
        ArrayList<Region> regions = new ArrayList<Region>();
        Region reg;
        for (int i = 1; i <= Data.regions.size(); i++) {
            reg = Data.regions.get(i);
            if ((reg.getPlayer() != null) && !reg.getPlayer().equals(this)) {
                regions.add(reg);
            }
        }

        return regions;
    }

    public ArrayList<Region[]> getPossibleMoves() {
    // Retorna todas as minhas possíveis jogadas
    // Uma jogada é possível desde que uma região minha seja vizinha de uma região inimiga
    // e desde que eu tenha mais de 1 soldado nesta minha região
        ArrayList<Region[]> moves = new ArrayList<Region[]>();
        ArrayList<Region> myRegions = this.getRegions();
        ArrayList<Region> enemyRegions = this.getEnemyRegions();

        for (int i = 0; i < myRegions.size(); i++) {
            Region myRegion = myRegions.get(i);
            for (int j = 0; j < enemyRegions.size(); j++) {
                Region enemyRegion = enemyRegions.get(j);
                if (myRegion.isNeighbour(enemyRegion) && (myRegion.getNumArmy() > 1)) {
                    Region[] move = {myRegion, enemyRegion};
                    moves.add(move);
                }
            }
        }
        return moves;
    }

    @Override
    public void attack(Region regionAttack, Region regionDefense, Integer attackQty) {
        List<Integer> diceAttack = new ArrayList<Integer>();
        List<Integer> diceDefense = new ArrayList<Integer>();

        //Total exército defesa
        Integer defenseQty = regionDefense.getNumArmy();

        //Máximo de 3 para ataque e defesa
        if (attackQty > 3) {
            attackQty = 3;
        }
        if (defenseQty > 3) {
            defenseQty = 3;
        }

        //Joga Dados Ataque (total escolhido)
        for (int i = 0; i < attackQty; i++) {
            diceAttack.add(Helper.throwDice());
        }

        //Joga dados Defesa (total no pais)
        for (int i = 0; i < defenseQty; i++) {
            diceDefense.add(Helper.throwDice());
        }

        //Ordena do maior pro menor
        Collections.sort(diceAttack, Collections.reverseOrder());
        Collections.sort(diceDefense, Collections.reverseOrder());

        //Mostra Resultado dos Dados do Ataque
        System.out.println("Ataque");
        for (int i = 0; i < attackQty; i++) {
            System.out.print(diceAttack.get(i) + ",");
        }
        System.out.println();
        //Mostra Resultado dos Dados da Defesa
        System.out.println("Defesa");
        for (int i = 0; i < defenseQty; i++) {
            System.out.print(diceDefense.get(i) + ",");
        }
        System.out.println();
        System.out.println();

        //Número de dados para ser comparado = menor número de exercito
        Integer nDados = (attackQty > defenseQty) ? defenseQty : attackQty;

        //Compara Dados (maior com maior)
        for (int i = 0; i < nDados; i++) {
            if ((int) diceAttack.get(i) > (int) diceDefense.get(i)) {
                //Ataque venceu: reduz tropa da defesa
                regionDefense.setNumArmy(regionDefense.getNumArmy() - 1);
                System.out.println("Ataque Maior: " + diceAttack.get(i) + " > " + diceDefense.get(i));
            } else {
                //Defesa venceu: reduz tropa do ataque
                regionAttack.setNumArmy(regionAttack.getNumArmy() - 1);
                System.out.println("Defesa Maior: " + diceDefense.get(i) + " >= " + diceAttack.get(i));
            }
        }

    }
    @Override
    public boolean moveSoldiersAttack(Region base, Region destination, Integer soldiersNumber) {
        if ((base.getNumArmy() - soldiersNumber) > 0){
            base.setNumArmy(base.getNumArmy() - soldiersNumber);
            destination.setNumArmy(destination.getNumArmy() - soldiersNumber);
            System.out.println("Soldados enviados a nova regiao com sucesso.");
            return true;
        }
        System.out.println("Número de soldados inválido. Deve ter pelo menos 1 soldado tomando conta da base antiga! Digite novamente:");
        return false;
        
    }
}
