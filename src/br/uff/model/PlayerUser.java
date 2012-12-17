package br.uff.model;

import java.util.Scanner;

public class PlayerUser extends PlayerAbstract {
	
	public PlayerUser(String name) {
		this.setName(name);
	}

	@Override
	public void play() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("Com qual país quer atacar?");
		Region regionAttack = Data.regions.get(in.nextInt());
		//Confere se é o dono da região
		if (Data.player != regionAttack.getPlayer()) {
			System.out.println("Você não é o dono da região selecionada");
			return;
		}
		
		System.out.println("Qual país quer atacar?");
		Region regionDefense = Data.regions.get(in.nextInt());
		//Confere se faz divisa
		if (!regionAttack.isNeighbour(regionDefense)) {
			System.out.println("A região selecionada não faz divisa");
			return;
		}
		
		System.out.println("Atacando:" + regionAttack.getName());
		System.out.println("Defendendo:" + regionDefense.getName());
		System.out.println("Ataque # Num Army:" + regionAttack.getNumArmy());
		System.out.println("Defesa # Num Army:" + regionDefense.getNumArmy());
		System.out.println();
		
		System.out.println("Quantos soldados quer usar?");
		int attackQty =  in.nextInt();
		//Confere se tem army suficiente (qtd selecionada < total na regiao e total na regiao > 1)
		if (!(attackQty < regionAttack.getNumArmy() && regionAttack.getNumArmy() > 1)) {
			System.out.println("Você não tem a quantidade de exercito escolhida ou não tem o mínimo para atacar (1)");
			return;
		}
		
		this.attack(regionAttack, regionDefense, attackQty);
                //Verifica se a região sob ataque ainda tem exército
                if (regionDefense.getNumArmy() == 0){
                    System.out.println("Ataque tomou o terrório, escolha o número de soldados para passar");
                    Boolean armyMoved = false;
                    while(!armyMoved) {
                        armyMoved = this.moveSoldiersAttack(regionAttack, regionDefense, in.nextInt());
                    }
                }
	}	
}
