package com.example.character;
import java.util.Random;

import com.example.Character;

public class Warlock extends Character {
	private Random generator =new Random();

	/**
	 * Generating Warlock class attributes randomly
	 */
	public Warlock() {
		setHealth((int)(generator.nextDouble()*20 + 10));
		setArmor((int)(generator.nextDouble()*10 + 8));
		setDamage((int)(generator.nextDouble()*25 + 35));
		setInitialHealth(getHealth()+5);
	}
	public int comboAttack() {
		return 5;
	}
	
}
