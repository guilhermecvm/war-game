package br.uff.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.uff.controller.Main;

public abstract class PlayerAbstract implements Player {
	
	public Main main = new Main();
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void attack(Region regionAttack, Region regionDefense, Integer attackQty) {
		List<Integer> diceAttack = new ArrayList<Integer>();
		List<Integer> diceDefense = new ArrayList<Integer>();
		
		//Total exército defesa
		Integer defenseQty = regionDefense.getNumArmy();
	
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
}
