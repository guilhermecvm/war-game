package br.uff.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PlayerAbstract implements Player {

	private String name;
	private int armyAvaiable = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArmyAvaiable() {
		return armyAvaiable;
	}

	public void setArmyAvaiable(int armyAvaiable) {
		this.armyAvaiable = armyAvaiable;
	}

	public void updateArmy() {
		int numberOfFavelas = this.getFavelas().size();

		// Aumenta army para distribuir de acordo com regiões dominadas
		if (numberOfFavelas <= 6) {
			this.setArmyAvaiable(this.getArmyAvaiable() + 3);
		} else {
			this.setArmyAvaiable(this.getArmyAvaiable() + numberOfFavelas / 2);
		}

		// Aumenta army para distribuir caso seja dono de um continente
		for (Continent cont : Data.continents.values()) {
			if (this.getFavelas().containsAll(cont.getFavelas())) {
				this.setArmyAvaiable(this.getArmyAvaiable()	+ cont.getFavelas().size() / 2);
			}
		}
	}

	public boolean sendArmyTo(Favela destination, int numArmy) {
		if (this.getFavelas().contains(destination)) {
			destination.setNumArmy(destination.getNumArmy() + numArmy);
			this.setArmyAvaiable(this.getArmyAvaiable() - numArmy);
			return true;
		}
		return false;
	}

	public ArrayList<Favela> getFavelas() {
		// Retorna todas as regiões que eu estou dominando no momento
		ArrayList<Favela> favelas = new ArrayList<Favela>();
		Favela favela;
		for (int i = 1; i <= Data.favelas.size(); i++) {
			favela = Data.favelas.get(i);

			if ((favela.getPlayer() != null) && favela.getPlayer().equals(this)) {
				favelas.add(favela);
			}
		}

		return favelas;
	}

	public ArrayList<Favela> getEnemyFavelas() {
		// Retorna todas as regiões que eu NÃO estou dominando no momento
		ArrayList<Favela> favelas = new ArrayList<Favela>();
		Favela reg;
		for (int i = 1; i <= Data.favelas.size(); i++) {
			reg = Data.favelas.get(i);
			if ((reg.getPlayer() != null) && !reg.getPlayer().equals(this)) {
				favelas.add(reg);
			}
		}

		return favelas;
	}

	public ArrayList<Favela[]> getPossibleMoves() {
		// Retorna todas as minhas possíveis jogadas
		// Uma jogada é possível desde que uma região minha tenha mais de 1
		// soldado
		// e que a região vizinha seja de um inimigo
		ArrayList<Favela[]> moves = new ArrayList<Favela[]>();
		ArrayList<Favela> myFavelas = this.getFavelas();

		for (int i = 0; i < myFavelas.size(); i++) {
			Favela myFavela = myFavelas.get(i);
			ArrayList<Favela> neigbourhood = (ArrayList<Favela>) myFavela.getNeighbourhood();
			if (myFavela.getNumArmy() > 1) {
				for (int j = 0; j < neigbourhood.size(); j++) {
					Favela neigbour = neigbourhood.get(j);
					if (!neigbour.getPlayer().equals(this)) {
						Favela[] move = { myFavela, neigbour };
						moves.add(move);
					}
				}
			}
		}
		return moves;
	}

	@Override
	public void attack(Favela favelaAttack, Favela favelaDefense, Integer attackQty) {
		List<Integer> diceAttack = new ArrayList<Integer>();
		List<Integer> diceDefense = new ArrayList<Integer>();
		
		// Total exército defesa
		Integer defenseQty = favelaDefense.getNumArmy();

		// Regras
		if (!Helper.hasArmy(favelaAttack, attackQty))
			throw new Error("Você não tem a quantidade de exercito escolhida ou não tem o mínimo para atacar (1)");

		// Máximo de 3 para ataque e defesa
		if (attackQty > 3)
			attackQty = 3;
		if (defenseQty > 3)
			defenseQty = 3;
		
		
		
		// Joga Dados Ataque (total escolhido)
		for (int i = 0; i < attackQty; i++) {
			diceAttack.add(Helper.throwDice());
		}

		// Joga dados Defesa (total no pais)
		for (int i = 0; i < defenseQty; i++) {
			diceDefense.add(Helper.throwDice());
		}

		// Ordena do maior pro menor
		Collections.sort(diceAttack, Collections.reverseOrder());
		Collections.sort(diceDefense, Collections.reverseOrder());

		// Mostra Resultado dos Dados do Ataque
		System.out.println("Ataque");
		for (int i = 0; i < attackQty - 1; i++) {
			System.out.print(diceAttack.get(i) + ",");
		}
		System.out.print(diceAttack.get(attackQty - 1));

		System.out.println();
		// Mostra Resultado dos Dados da Defesa
		System.out.println("Defesa");
		for (int i = 0; i < defenseQty - 1; i++) {
			System.out.print(diceDefense.get(i) + ",");
		}
		System.out.print(diceDefense.get(defenseQty - 1));
		System.out.println();
		System.out.println();

		// Número de dados para ser comparado = menor número de exercito
		Integer nDados = (attackQty > defenseQty) ? defenseQty : attackQty;

		// Compara Dados (maior com maior)
		for (int i = 0; i < nDados; i++) {
			if ((int) diceAttack.get(i) > (int) diceDefense.get(i)) {
				// Ataque venceu: reduz tropa da defesa
				favelaDefense.setNumArmy(favelaDefense.getNumArmy() - 1);
				System.out.println("Ataque Maior: " + diceAttack.get(i) + " > " + diceDefense.get(i));
			} else {
				// Defesa venceu: reduz tropa do ataque
				favelaAttack.setNumArmy(favelaAttack.getNumArmy() - 1);
				System.out.println("Defesa Maior: " + diceDefense.get(i) + " >= " + diceAttack.get(i));
			}
		}
	}

	@Override
	public boolean moveSoldiersAttack(Favela base, Favela destination, Integer qtyArmy) {
		if (!Helper.hasArmy(base, qtyArmy)) {
			base.setNumArmy(base.getNumArmy() - qtyArmy);
			destination.setNumArmy(destination.getNumArmy() + qtyArmy);
			System.out.println("Soldados enviados a nova regiao com sucesso.");
			return true;
		}
		System.out.println("Número de soldados inválido. Deve ter pelo menos 1 soldado tomando conta da base antiga! Digite novamente:");
		return false;
	}
}
