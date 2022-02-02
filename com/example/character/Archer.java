package com.example.character;
import java.util.Random;

import com.example.Character;

public class Archer extends Character{
	private Random generator =new Random();
	
	/**
	 * Generating Archer class attributes randomly
	 */
	public Archer() {
		setHealth((int)(generator.nextDouble()*20 + 10));
		setArmor((int)(generator.nextDouble()*10 + 12));
		setDamage((int)(generator.nextDouble()*20 + 30));
		setInitialHealth(getHealth()+5);
	}
	
	public int comboAttack() {
		return 4;
	}
	
}
