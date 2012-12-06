package br.uff.model;

import java.util.Random;

public class Helper {
	
	public static int throwDice() {
		Random r = new Random();
		return r.nextInt(6) + 1; //0~5 + 1 = 1~6
	}

}
