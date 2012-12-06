package br.uff.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerUser implements Player {
	
	private String name;
	
	public PlayerUser(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void attack(Region regionAttack, Region regionDefense, Integer attackQty) {
		Player playerAttack = regionAttack.getPlayer();
		Player playerDefense = regionDefense.getPlayer();

		List<Integer> diceAttack = new ArrayList<Integer>();
		List<Integer> diceDefense = new ArrayList<Integer>();
		
		//Total exército defesa
		Integer defenseQty = regionDefense.getNumArmy();

		//Confere se é o dono da região
		if (this == playerAttack) {
			
			//Confere se faz divisa
			if (regionAttack.isNeighbour(regionDefense)) {
			
				//Confere se tem army suficiente (qtd selecionada < total na regiao e total na regiao > 1)
				if (attackQty < regionAttack.getNumArmy() && regionAttack.getNumArmy() > 1) {
					
					//Máximo de 3 para ataque e defesa
					if (attackQty > 3) attackQty = 3;
					if (defenseQty > 3) defenseQty = 3;
					
					//Joga Dados Ataque (total escolhido)
					for (int i=0; i < attackQty; i++)
						diceAttack.add(Helper.throwDice());
					
					//Joga dados Defesa (total no pais)
					for (int i=0; i < defenseQty; i++)
						diceDefense.add(Helper.throwDice());
					
					//Ordena do maior pro menor
					Collections.sort(diceAttack, Collections.reverseOrder());
					Collections.sort(diceDefense, Collections.reverseOrder());
					
					//Mostra Resultado dos Dados do Ataque
					System.out.println("Ataque");
					for (int i=0; i < attackQty; i++) {
						System.out.print(diceAttack.get(i) + ",");
					}
					System.out.println();
					//Mostra Resultado dos Dados da Defesa
					System.out.println("Defesa");
					for (int i=0; i < defenseQty; i++) {
						System.out.print(diceDefense.get(i) + ",");
					}
					System.out.println();System.out.println();
					
					//Número de dados para ser comparado = menor número de exercito
					Integer nDados = (attackQty > defenseQty) ? defenseQty : attackQty;
					
					//Compara Dados (maior com maior)
					for (int i=0; i < nDados; i++) {
						if ((int) diceAttack.get(i) > (int) diceDefense.get(i)) {
							//Ataque venceu: reduz tropa da defesa
							regionDefense.setNumArmy(regionDefense.getNumArmy() - 1);
							System.out.println("Ataque Maior: " + diceAttack.get(i) + " > " + diceDefense.get(i));
						}
						else {
							//Defesa venceu: reduz tropa do ataque
							regionAttack.setNumArmy(regionAttack.getNumArmy() - 1);
							System.out.println("Defesa Maior: " + diceDefense.get(i) + " >= " + diceAttack.get(i));
						}
					}
					
					//Verifica se a região ainda tem exército
					if (regionDefense.getNumArmy() == 0)
						System.out.println("Ataque tomou o terrório, escolha o número de soldados para passar");
				}
				else {
					System.out.println("Você não tem a quantidade de exercito escolhida ou não tem o mínimo para atacar (1)");
				}
			}
			else {
				System.out.println("A região selecionada não faz divisa");
			}
		}
		else {
			System.out.println("Você não é o dono da região selecionada");
		}
	}
	
}
