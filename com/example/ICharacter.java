package com.example;
public interface ICharacter {

	boolean isLifeStatus();
	int getHealth();
	int getArmor();
	int getDamage();
	int getScore();
	void setScore(int score);
	void setHealth(int Health);
	int comboAttack();
	void reset();
	
	
}
