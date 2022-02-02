package com.example.character;
import java.util.Random;

import com.example.Character;

public class Warrior extends Character {
	private Random generator =new Random();


	/**
	 * Generating Warrior class attributes randomly
	 */
	
	public Warrior() {
		setHealth((int)(generator.nextDouble()*20 + 15));
		setArmor((int)(generator.nextDouble()*20 + 8));
		setDamage((int)(generator.nextDouble()*20 + 30));
		setInitialHealth(getHealth()+5);
	}

	public int comboAttack() {
		return 4;
	}

}
