package com.example;
public class Character implements ICharacter {
	private int health;
	private int armor;
	private int damage;
	private boolean lifeStatus = true;
	private int initialHealth; 
	private int score;
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isLifeStatus() {
		return lifeStatus;
	}
	public void setLifeStatus(boolean lifeStatus) {
		this.lifeStatus = lifeStatus;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		if(health <= 0) {
			this.setLifeStatus(false);
			this.health = 0;

		}else {
			this.health = health;

		}
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setInitialHealth(int health) {
		this.initialHealth = health;
	}
	
	public int getInitialHealth() {
		return initialHealth;
	}
	
	public void reset() {
		this.health = initialHealth;
	}

	

	
	/**
	 * Generating combo attack power. Function override from each subclasses
	 */
	@Override
	public int comboAttack() {
	// TODO Auto-generated method stub
	return 0;
}
	
	/**
	 *  Printing character status 
	 */
	public String toString() {
		
		return "Health:" + getHealth() +"  "
		+"Armor:" + getArmor() +"  "
		+"Damage:" + getDamage() + "\n"
		+ "Life status:" + isLifeStatus();  
		
	}




}