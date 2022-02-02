package com.example.character;
import java.util.Random;

import com.example.Character;

public class Berserker extends Character {
private Random generator =new Random();

/**
 * Generating Berserker class attributes randomly
 */
	public Berserker() {
		setHealth((int)(generator.nextDouble()*30 + 20));
		setArmor((int)(generator.nextDouble()*20 + 9));
		setDamage((int)(generator.nextDouble()*10 + 27));
		setInitialHealth(getHealth()+5);
	}
	
	public int comboAttack() {
		return 2;
	}
	
}